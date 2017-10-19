import java.util.HashMap;

public class Partidas {
    public String getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }

    public String getNomeJogador() {
        return NomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        NomeJogador = nomeJogador;
    }

    public Boolean getFirstToew() {
        return FirstToew;
    }

    public void setFirstToew(Boolean firstToew) {
        FirstToew = firstToew;
    }

    public Boolean getFirstDragon() {
        return FirstDragon;
    }

    public void setFirstDragon(Boolean firstDragon) {
        FirstDragon = firstDragon;
    }

    public Boolean getResultado() {
        return Resultado;
    }

    public void setResultado(Boolean resultado) {
        Resultado = resultado;
    }

    public Boolean getProplayer() {
        return proplayer;
    }

    public void setProplayer(Boolean proplayer) {
        this.proplayer = proplayer;
    }

    public String getRota() {
        return rota;
    }

    public void setRota(String rota) {
        this.rota = rota;
    }

    public String getCampeao() {
        return campeao;
    }

    public void setCampeao(String campeao) {
        this.campeao = campeao;
    }

    public Integer getFarm() {
        return farm;
    }

    public void setFarm(Integer farm) {
        this.farm = farm;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Integer getDano() {
        return dano;
    }

    public void setDano(Integer dano) {
        this.dano = dano;
    }

    public Boolean getFirstblood() {
        return firstblood;
    }

    public void setFirstblood(Boolean firstblood) {
        this.firstblood = firstblood;
    }

    public Boolean getAralto() {
        return aralto;
    }

    public void setAralto(Boolean aralto) {
        this.aralto = aralto;
    }

    public HashMap<String, Boolean> getItens() {
        return itens;
    }

    public void setItens(HashMap<String, Boolean> itens) {
        this.itens = itens;
    }

    String idPartida;
    String NomeJogador;
    Boolean FirstToew;
    Boolean FirstDragon;
    Boolean Resultado;
    Boolean proplayer;
    String rota;
    String campeao;
    Integer farm;
    Integer gold;
    Integer dano;
    Boolean firstblood;
    Boolean aralto;
    HashMap<String,Boolean>itens;
    Partidas(){
        this.idPartida="";
        this.NomeJogador="";
        this.FirstToew=false;
        this.FirstDragon=false;
        this.Resultado=false;
        this.proplayer=false;
        this.rota="";
        this.campeao="";
        this.farm=0;
        this.gold=0;
        this.dano=0;
        this.firstblood=false;
        this.aralto=false;
        this.itens =new HashMap<>();
        itens.put("i1001",false);
        itens.put("i1004",false);
        itens.put("i1006",false);
        itens.put("i1011",false);
        itens.put("i1018",false);
        itens.put("i1026",false);
        itens.put("i1027",false);
        itens.put("i1028",false);
        itens.put("i1029",false);
        itens.put("i1031",false);
        itens.put("i1033",false);
        itens.put("i1036",false);
        itens.put("i1037",false);
        itens.put("i1038",false);
        itens.put("i1039",false);
        itens.put("i1041",false);
        itens.put("i1042",false);
        itens.put("i1043",false);
        itens.put("i1051",false);
        itens.put("i1052",false);
        itens.put("i1053",false);
        itens.put("i1054",false);
        itens.put("i1055",false);
        itens.put("i1056",false);
        itens.put("i1057",false);
        itens.put("i1058",false);
        itens.put("i1082",false);
        itens.put("i1083",false);
        itens.put("i1400",false);
        itens.put("i1401",false);
        itens.put("i1402",false);
        itens.put("i1408",false);
        itens.put("i1409",false);
        itens.put("i1410",false);
        itens.put("i1412",false);
        itens.put("i1413",false);
        itens.put("i1414",false);
        itens.put("i1416",false);
        itens.put("i1418",false);
        itens.put("i1419",false);
        itens.put("i2003",false);
        itens.put("i2009",false);
        itens.put("i2010",false);
        itens.put("i2011",false);
        itens.put("i2015",false);
        itens.put("i2031",false);
        itens.put("i2032",false);
        itens.put("i2033",false);
        itens.put("i2045",false);
        itens.put("i2047",false);
        itens.put("i2049",false);
        itens.put("i2050",false);
        itens.put("i2051",false);
        itens.put("i2052",false);
        itens.put("i2053",false);
        itens.put("i2054",false);
        itens.put("i2055",false);
        itens.put("i2138",false);
        itens.put("i2139",false);
        itens.put("i2140",false);
        itens.put("i2301",false);
        itens.put("i2302",false);
        itens.put("i2303",false);
        itens.put("i3001",false);
        itens.put("i3003",false);
        itens.put("i3004",false);
        itens.put("i3006",false);
        itens.put("i3007",false);
        itens.put("i3008",false);
        itens.put("i3009",false);
        itens.put("i3010",false);
        itens.put("i3020",false);
        itens.put("i3022",false);
        itens.put("i3024",false);
        itens.put("i3025",false);
        itens.put("i3026",false);
        itens.put("i3027",false);
        itens.put("i3028",false);
        itens.put("i3029",false);
        itens.put("i3030",false);
        itens.put("i3031",false);
        itens.put("i3033",false);
        itens.put("i3034",false);
        itens.put("i3035",false);
        itens.put("i3036",false);
        itens.put("i3040",false);
        itens.put("i3041",false);
        itens.put("i3042",false);
        itens.put("i3043",false);
        itens.put("i3044",false);
        itens.put("i3046",false);
        itens.put("i3047",false);
        itens.put("i3048",false);
        itens.put("i3050",false);
        itens.put("i3052",false);
        itens.put("i3053",false);
        itens.put("i3056",false);
        itens.put("i3057",false);
        itens.put("i3060",false);
        itens.put("i3065",false);
        itens.put("i3067",false);
        itens.put("i3068",false);
        itens.put("i3069",false);
        itens.put("i3070",false);
        itens.put("i3071",false);
        itens.put("i3072",false);
        itens.put("i3073",false);
        itens.put("i3074",false);
        itens.put("i3075",false);
        itens.put("i3076",false);
        itens.put("i3077",false);
        itens.put("i3078",false);
        itens.put("i3082",false);
        itens.put("i3083",false);
        itens.put("i3084",false);
        itens.put("i3085",false);
        itens.put("i3086",false);
        itens.put("i3087",false);
        itens.put("i3089",false);
        itens.put("i3090",false);
        itens.put("i3091",false);
        itens.put("i3092",false);
        itens.put("i3094",false);
        itens.put("i3096",false);
        itens.put("i3097",false);
        itens.put("i3098",false);
        itens.put("i3100",false);
        itens.put("i3101",false);
        itens.put("i3102",false);
        itens.put("i3104",false);
        itens.put("i3105",false);
        itens.put("i3107",false);
        itens.put("i3108",false);
        itens.put("i3109",false);
        itens.put("i3110",false);
        itens.put("i3111",false);
        itens.put("i3112",false);
        itens.put("i3113",false);
        itens.put("i3114",false);
        itens.put("i3115",false);
        itens.put("i3116",false);
        itens.put("i3117",false);
        itens.put("i3122",false);
        itens.put("i3123",false);
        itens.put("i3124",false);
        itens.put("i3133",false);
        itens.put("i3134",false);
        itens.put("i3135",false);
        itens.put("i3136",false);
        itens.put("i3137",false);
        itens.put("i3139",false);
        itens.put("i3140",false);
        itens.put("i3142",false);
        itens.put("i3143",false);
        itens.put("i3144",false);
        itens.put("i3145",false);
        itens.put("i3146",false);
        itens.put("i3147",false);
        itens.put("i3151",false);
        itens.put("i3152",false);
        itens.put("i3153",false);
        itens.put("i3155",false);
        itens.put("i3156",false);
        itens.put("i3157",false);
        itens.put("i3158",false);
        itens.put("i3165",false);
        itens.put("i3170",false);
        itens.put("i3174",false);
        itens.put("i3175",false);
        itens.put("i3181",false);
        itens.put("i3184",false);
        itens.put("i3185",false);
        itens.put("i3187",false);
        itens.put("i3190",false);
        itens.put("i3191",false);
        itens.put("i3193",false);
        itens.put("i3194",false);
        itens.put("i3196",false);
        itens.put("i3197",false);
        itens.put("i3198",false);
        itens.put("i3200",false);
        itens.put("i3211",false);
        itens.put("i3222",false);
        itens.put("i3252",false);
        itens.put("i3285",false);
        itens.put("i3301",false);
        itens.put("i3302",false);
        itens.put("i3303",false);
        itens.put("i3340",false);
        itens.put("i3341",false);
        itens.put("i3345",false);
        itens.put("i3348",false);
        itens.put("i3361",false);
        itens.put("i3362",false);
        itens.put("i3363",false);
        itens.put("i3364",false);
        itens.put("i3371",false);
        itens.put("i3373",false);
        itens.put("i3374",false);
        itens.put("i3379",false);
        itens.put("i3380",false);
        itens.put("i3382",false);
        itens.put("i3383",false);
        itens.put("i3384",false);
        itens.put("i3385",false);
        itens.put("i3386",false);
        itens.put("i3401",false);
        itens.put("i3410",false);
        itens.put("i3416",false);
        itens.put("i3422",false);
        itens.put("i3455",false);
        itens.put("i3460",false);
        itens.put("i3461",false);
        itens.put("i3462",false);
        itens.put("i3504",false);
        itens.put("i3508",false);
        itens.put("i3512",false);
        itens.put("i3513",false);
        itens.put("i3599",false);
        itens.put("i3630",false);
        itens.put("i3631",false);
        itens.put("i3632",false);
        itens.put("i3633",false);
        itens.put("i3634",false);
        itens.put("i3635",false);
        itens.put("i3636",false);
        itens.put("i3637",false);
        itens.put("i3640",false);
        itens.put("i3641",false);
        itens.put("i3642",false);
        itens.put("i3643",false);
        itens.put("i3645",false);
        itens.put("i3647",false);
        itens.put("i3648",false);
        itens.put("i3649",false);
        itens.put("i3671",false);
        itens.put("i3672",false);
        itens.put("i3673",false);
        itens.put("i3675",false);
        itens.put("i3680",false);
        itens.put("i3681",false);
        itens.put("i3682",false);
        itens.put("i3683",false);
        itens.put("i3690",false);
        itens.put("i3691",false);
        itens.put("i3692",false);
        itens.put("i3693",false);
        itens.put("i3694",false);
        itens.put("i3695",false);
        itens.put("i3706",false);
        itens.put("i3711",false);
        itens.put("i3715",false);
        itens.put("i3742",false);
        itens.put("i3748",false);
        itens.put("i3751",false);
        itens.put("i3800",false);
        itens.put("i3801",false);
        itens.put("i3802",false);
        itens.put("i3812",false);
        itens.put("i3814",false);
        itens.put("i3901",false);
        itens.put("i3902",false);
        itens.put("i3903",false);
    }


}
