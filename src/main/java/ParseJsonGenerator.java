import java.io.*;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

public class ParseJsonGenerator {
    String Key="?api_key=";
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
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else if(this.countRequest==100){
            try {
                new Thread().sleep(115000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.countRequest=0;
        }
        return retorno;
    }
    HashMap<Integer,Partidas> P =new HashMap<>();
    Integer countPartidas=0;
    PartidaLucas lucas=new PartidaLucas();
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
            //geraLucas(Lines,idPlayerInMatch);
            p=GetItens(Lines,p,idPlayerInMatch);
            JSONArray players = (JSONArray) finalMatch.get("participants");
            Long time=pegatime((JSONObject)players.get((Integer.valueOf(idPlayerInMatch)-1)));
            p=GetPlayersStatus((JSONObject)players.get((Integer.valueOf(idPlayerInMatch)-1)),p);
            JSONArray times= (JSONArray) finalMatch.get("teams");
            p=GetFirstThings(times,time,p);
            this.P.put(this.countPartidas,p);
            this.countPartidas++;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private Partidas GetFirstThings(JSONArray lines,Long time, Partidas p) {
        for(int i=0;i<lines.size();i++){
            JSONObject t= (JSONObject) lines.get(i);
            if(t.get("teamId")==time){
                p.setFirstblood((Boolean) t.get("firstBlood"));
                p.setFirstTower((Boolean) t.get("firstTower"));
                p.setFirstDragon((Boolean) t.get("firstDragon"));
                p.setFirstaralto((Boolean) t.get("firstRiftHerald"));
                p.setFirstbaron((Boolean) t.get("firstBaron"));
                p.setDragons((Long) t.get("dragonKills"));
            }
        }
        return p;
    }

    private Long pegatime(JSONObject jsonObject) {
        return (Long) jsonObject.get("teamId");
    }


    private Partidas GetPlayersStatus(JSONObject jsonObject,Partidas p) {
        if (jsonObject.containsKey("championId"))
            p.setCampeao(champ((Long) jsonObject.get("championId")));
        JSONObject stats = (JSONObject) jsonObject.get("stats");
        if (stats.containsKey("totalMinionsKilled"))
            p.setFarm((Long) stats.get("totalMinionsKilled"));
        if (stats.containsKey("totalMinionsKilled"))
            p.setGold((Long) stats.get("goldEarned"));
        if (stats.containsKey("totalDamageDealtToChampions")&&stats.containsKey("damageDealtToObjectives")&&stats.containsKey("trueDamageDealt")){
            Long total = (Long) stats.get("totalDamageDealtToChampions") + (Long) stats.get("damageDealtToObjectives") + (Long) stats.get("trueDamageDealt");
            p.setDano(total);
        }
        if (stats.containsKey("firstBloodKill"))
        p.setFirstblood((Boolean) stats.get("firstBloodKill"));
        if (stats.containsKey("win"))
        p.setResultado((Boolean) stats.get("win"));
        JSONObject timeLine= (JSONObject) jsonObject.get("timeline");
        if (timeLine.containsKey("role"))
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
            JSONObject champArray= (JSONObject) jsonObject.get("keys");
            String camp=champArray.get(championId.toString()).toString();
            return camp;
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

    /*private void geraLucas(JSONArray lines, String id) {
        StringBuilder x=new StringBuilder("");
        for(int i=0;i<20;i++){
            JSONObject j= (JSONObject) lines.get(i);
            JSONArray k= (JSONArray) j.get("events");
            JSONObject partFrames= (JSONObject) j.get("participantFrames");
            JSONObject eventesPorFrame= (JSONObject) partFrames.get(id);
            HashMap<String,String> aux=new HashMap<>();
            aux.put("farm",eventesPorFrame.get("minionsKilled").toString());
            for(int n=0;n<k.size();n++){
                JSONObject kObj= (JSONObject) k.get(n);
                if(kObj.containsKey("participantId")){

                }
            }

            this.lucas.Frames.put(i,aux);


            }
        }*/

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

        JSONParser parser = new JSONParser();
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
    public static void escreveFimArquivo(String arq, String escrita){

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
        geraCabecalho();
        i.PegaIdAccount("Trashbag Dioud","br1",true);
        GetPartidas(i);
        i=new ParseJsonGenerator();
        i.PegaIdAccount("Nevereverland","br1",true);
        GetPartidas(i);
        i=new ParseJsonGenerator();
        i.PegaIdAccount("Mirakyuj","br1",true);
        GetPartidas(i);
        i=new ParseJsonGenerator();
        i.PegaIdAccount("Keyd esA","br1",true);
        GetPartidas(i);
        i=new ParseJsonGenerator();
        i.PegaIdAccount("Eryonn","br1",true);
        GetPartidas(i);
        i=new ParseJsonGenerator();
        i.PegaIdAccount("svendead","br1",false);
        GetPartidas(i);
        i=new ParseJsonGenerator();
        i.PegaIdAccount("SheIdon1","br1",false);
        GetPartidas(i);
        i=new ParseJsonGenerator();
        i.PegaIdAccount("Son of the Sun","br1",false);
        GetPartidas(i);
        i=new ParseJsonGenerator();
        i.PegaIdAccount("leytsarK","br1",false);
        GetPartidas(i);
        i=new ParseJsonGenerator();
        i.PegaIdAccount("trust yourself","br1",false);
        GetPartidas(i);
        try {
            //Salva no objeto JSONObject o que o parse tratou do arquivo
            jsonObject = (JSONObject) parser.parse(new FileReader("teste.json"));
            JSONArray array = new JSONArray();
            array.add(jsonObject.get("matches"));

            writeFile = new FileWriter("saida.txt");

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

    private static void geraCabecalho() {
        String heading="";
        StringBuilder head=new StringBuilder(heading);
        head.append("idPartida,");
        head.append("nomeJogador,");
        head.append("campeao,");
        head.append("rota,");
        head.append("danototal,");
        head.append("farm,");
        head.append("gold,");
        head.append("dragons,");
        head.append("firstDragon,");
        head.append("firstArauto,");
        head.append("firstBaron,");
        head.append("FirstBlood,");
        head.append("firstTower,");
        Partidas exemplo=new Partidas();
        Set<Long> keysItens=exemplo.getItens().keySet();
        for (Iterator<Long> iterator = keysItens.iterator(); iterator.hasNext(); ) {
            head.append(iterator.next() + ",");
        }
        head.append("Vitoria");

        escreveFimArquivo("partidas.csv",head.toString());
    }

    private static void GetPartidas(ParseJsonGenerator i) {
        for(Map.Entry<Integer,Partidas> entry:i.P.entrySet()) {
            Partidas imprime = entry.getValue();
            HashMap<Long, Boolean> itens = imprime.getItens();
            Set<Long> keys = imprime.getItens().keySet();
            String linhaini = "";;
            StringBuilder linha=new StringBuilder(linhaini);
            linha.append(imprime.getIdPartida() + ",");
            linha.append(imprime.getNomeJogador() + ",");
            linha.append(imprime.getCampeao() + ",");
            linha.append(imprime.getRota() + ",");
            linha.append(imprime.getDano() + ",");
            linha.append(imprime.getFarm() + ",");
            linha.append(imprime.getGold() + ",");
            linha.append(imprime.getDragons() + ",");
            linha.append(imprime.getFirstDragon() + ",");
            linha.append(imprime.getFirstaralto() + ",");
            linha.append(imprime.getFirstbaron() + ",");
            linha.append(imprime.getFirstblood() + ",");
            linha.append(imprime.getFirstTower() + ",");
            for (Iterator<Long> iterator = keys.iterator(); iterator.hasNext(); ) {
                linha.append(String.valueOf(itens.get(iterator.next()) + ","));
            }
            linha.append(imprime.getResultado());
            escreveFimArquivo("partidas.csv",linha.toString());
        }
    }


}