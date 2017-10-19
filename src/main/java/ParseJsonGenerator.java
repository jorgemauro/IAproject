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
    String Key="?api_key=Insira-";
    int countRequest=0;
    public Document RequestApi(String urlbase,String region,String key,String Att){
        Document retorno= Document.createShell("");
        try {
            retorno=Jsoup.connect("https://"+region+urlbase+Att+Key).ignoreContentType(true).get();
            this.countRequest++;
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(this.countRequest==20){
            try {
                new Thread().sleep(1000);
                this.countRequest=0;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return retorno;
    }
    HashMap<Integer,Partidas> P =new HashMap<>();
    Integer countPartidas=0;
    public void coletaMatch(String MatchId,String region, String PlayerId,String Nick,Boolean pro){
        JSONObject finalMatch;
        JSONObject timeLine;
        //Cria o parse de tratamento
        JSONParser parser = new JSONParser();
        try {
            Document document =this.RequestApi(".api.riotgames.com/lol/match/v3/matches/",region,
                    this.Key,MatchId);
            Document document2 = this.RequestApi(".api.riotgames.com/lol/match/v3/timelines/by-match/",region,
                    this.Key,MatchId);
            finalMatch = (JSONObject) parser.parse(document.text());
            timeLine = (JSONObject) parser.parse(document2.text());
            Partidas p = new Partidas();
            p.setNomeJogador(Nick);
            p.setIdPartida(MatchId);
            p.setProplayer(pro);
            JSONArray Lines= (JSONArray)timeLine.get("frames");
            JSONArray participantIdentities  = (JSONArray) finalMatch.get("participantIdentities");
            String idPlayerInMatch=GetidPlayerInGame(participantIdentities,PlayerId);
            p=GetItens(Lines,p,idPlayerInMatch);
            JSONArray players = (JSONArray) finalMatch.get("participants");
            p=GetPlayersStatus((JSONObject)players.get((Integer.valueOf(idPlayerInMatch)-1)),p);
            this.P.put(this.countPartidas,p);
            this.countPartidas++;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    private Partidas GetPlayersStatus(JSONObject jsonObject,Partidas p) {
        p.setCampeao(champ((Long)jsonObject.get("championId")));
        JSONObject stats = (JSONObject) jsonObject.get("stats");
        p.setFarm((Long) stats.get("totalMinionsKilled"));
        p.setGold((Long) stats.get("goldEarned"));
        Long total= (Long) stats.get("totalDamageDealtToChampions")+(Long) stats.get("damageDealtToObjectives")+(Long) stats.get("trueDamageDealt");
        p.setDano(total);
        p.setFirstblood((Boolean) stats.get("firstBloodKill"));
        p.setResultado((Boolean) stats.get("win"));
        JSONObject timeLine= (JSONObject) jsonObject.get("timeline");
        p.setRota((String) timeLine.get("role"));
        return p;
    }

    private String champ(Long championId) {
        JSONObject jsonObject;
        final String champ ="";
        //Cria o parse de tratamento
        JSONParser parser = new JSONParser();
        //Variaveis que irao armazenar os dados do arquivo JSON
        FileWriter writeFile = null;
        try{
            jsonObject = (JSONObject) parser.parse(new FileReader(
                    "campeoesbyid.json"));
            JSONArray champArray= (JSONArray) jsonObject.get("champions");
            for(int k=0;k<champArray.size();k++){

                JSONObject c= (JSONObject) champArray.get(k);
                if(championId==(long)c.get("id")){
                    return c.get("name").toString();
                }}
        }catch (Exception e){

        }
        return champ;
    }

    private Partidas GetItens(JSONArray lines, Partidas p,String id) {
        for(int i=0;i<lines.size();i++){
            JSONObject j= (JSONObject) lines.get(i);
        JSONArray k= (JSONArray) j.get("events");
        if(k.size()>0) {
            for(int y=0;y<k.size();y++) {
                JSONObject j2 = (JSONObject) k.get(y);
                if(j2.containsKey("itemId")&&j2.containsKey("participantId")&&j2.get("participantId").toString().equals(id)){
                    p.itens.replace((Long) j2.get("itemId"),true);
                }
            }
        }
        }

        return p;
    }

    public String GetidPlayerInGame(JSONArray participantIdentities, String Acc) {
        JSONObject j;
        for(int i=0;i<participantIdentities.size();i++){
            j=(JSONObject) participantIdentities.get(i);
            JSONObject k=(JSONObject) j.get("player");
            if(k.get("currentAccountId").toString().equals(Acc)){
                return String.valueOf(i+1);
            }
        }
        return "nogame";

    }

    public void PegaIdAccount(String name, String region,Boolean pro){
        name.replace(" ","%20");
        try {
            JSONObject jsonObject;
            Document document = RequestApi(".api.riotgames.com/lol/summoner/v3/summoners/by-name/",region,
                    this.Key,name);
            jsonObject = (JSONObject) parser.parse(document.text());
            this.BuscaMatchsPlayer(jsonObject.get("accountId").toString(),region,name,pro);
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
    /*
    * @param idAccount id da conta do jogador
    * @param region região aonde o jogador pertence
    * @param Nick nome do jogador
    * @param pro se ele é um jogador profissional
    * */
    public void BuscaMatchsPlayer(String idAccount, String region,String Nick, boolean pro){

        JSONObject jsonObject;
        //Cria o parse de tratamento
        JSONParser parser = new JSONParser();
        try {
            Document document = RequestApi(".api.riotgames.com/lol/match/v3/matchlists/by-account/",region,
                    this.Key,idAccount);
            jsonObject = (JSONObject) parser.parse(document.text());
            JSONArray array = new JSONArray();
            array.add(jsonObject.get("matches"));
            JSONArray matchs = (JSONArray) array.get(0);
            matchs.forEach(match->{
                JSONObject json= (JSONObject) match;
                this.coletaMatch(json.get("gameId").toString(),region,idAccount,Nick,pro);
            });
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
       i.PegaIdAccount("Trashbag Dioud","br1",true);

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