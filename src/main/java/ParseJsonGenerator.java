import java.io.*;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseJsonGenerator {
    public static void main(String[] args) {
        JSONObject jsonObject;
        //Cria o parse de tratamento
        JSONParser parser = new JSONParser();
        //Variaveis que irao armazenar os dados do arquivo JSON
       FileWriter writeFile = null;

        try {
            //Salva no objeto JSONObject o que o parse tratou do arquivo
            jsonObject = (JSONObject) parser.parse(new FileReader(
                    "teste.json"));
            writeFile = new FileWriter("saida.txt");
            HashMap<String,Object> map =new HashMap<String,Object>((Map<? extends String, ?>) jsonObject.get("data"));
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String id = entry.getKey();
                HashMap<String,Object> map2 =new HashMap<String,Object>((Map<? extends String, ?>) entry.getValue());
                String nome = "";
                for (Map.Entry<String, Object> entra : map2.entrySet()) {
                    if (entra.getKey().equals("image")) {
                        HashMap<String, Object> map3 = new HashMap<>((Map<? extends String, ?>) entra.getValue());
                        nome += map3.get("sprite")+"  ";
                    }
                }
                writeFile.write("id: "+id+" nome: "+ nome);
            }

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