import java.io.*;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

public class ParseJsonGenerator {
    JSONObject jsonObject;
    //Cria o parse de tratamento
    JSONParser parser = new JSONParser();
    String Key="?api_key=coloque_a_key_aqui";
    public void PegaIdAccount(String name, String region){
        name.replace(" ","%20");
        try {

            Document document = Jsoup.connect("https://"+region+".api.riotgames.com/lol/summoner/v3/summoners/by-name/"+
                    name+this.Key).ignoreContentType(true).get();
            jsonObject = (JSONObject) parser.parse(document.text());
            this.BuscaMatchsPlayer(jsonObject.get("accountId").toString(),region);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public void escreveFimArquivo(String arq, String escrita){

        FileWriter writeFile = null;
        String newLine = System.getProperty("line.separator");
        try {
            writeFile = new FileWriter(arq,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writeFile.append(escrita+newLine);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writeFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void BuscaMatchsPlayer(String idAccount, String region){

        JSONObject jsonObject;
        //Cria o parse de tratamento
        JSONParser parser = new JSONParser();
        try {
            Document document = Jsoup.connect("https://"+region+".api.riotgames.com/lol/match/v3/matchlists/by-account/"+
                    idAccount+this.Key).ignoreContentType(true).get();
            jsonObject = (JSONObject) parser.parse(document.text());
            JSONArray array = new JSONArray();
            array.add(jsonObject.get("matches"));
            JSONArray matchs = (JSONArray) array.get(0);
            matchs.forEach(match->{
                JSONObject json= (JSONObject) match;
                this.escreveFimArquivo("partidas"+idAccount+".txt", json.get("gameId").toString());
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        JSONObject jsonObject;
        //Cria o parse de tratamento
        JSONParser parser = new JSONParser();
        //Variaveis que irao armazenar os dados do arquivo JSON
       FileWriter writeFile = null;
       ParseJsonGenerator i=new ParseJsonGenerator();
       i.PegaIdAccount("TrashbagDioud","br1");

        try {
            //Salva no objeto JSONObject o que o parse tratou do arquivo
            jsonObject = (JSONObject) parser.parse(new FileReader(
                    "teste.json"));
            JSONArray array = new JSONArray();
            array.add(jsonObject.get("matches"));

            writeFile = new FileWriter("saida.txt");
            array.forEach(match->{

            });
            writeFile.write("");
            writeFile.close();
            //Salva nas variaveis os dados retirados do arquivo

        }
        //Trata as exceptions que podem ser lançadas no decorrer do processo
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}