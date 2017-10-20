import java.util.HashMap;

public class Partidas {

    String idPartida;

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

    public Boolean getFirstTower() {
        return FirstTower;
    }

    public void setFirstTower(Boolean firstTower) {
        FirstTower = firstTower;
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

    public Long getFarm() {
        return farm;
    }

    public void setFarm(Long farm) {
        this.farm = farm;
    }

    public Long getGold() {
        return gold;
    }

    public void setGold(Long gold) {
        this.gold = gold;
    }

    public Long getDano() {
        return dano;
    }

    public void setDano(Long dano) {
        this.dano = dano;
    }

    public Boolean getFirstblood() {
        return firstblood;
    }

    public void setFirstblood(Boolean firstblood) {
        this.firstblood = firstblood;
    }

    public Boolean getFirstaralto() {
        return firstaralto;
    }

    public void setFirstaralto(Boolean firstaralto) {
        this.firstaralto = firstaralto;
    }

    public Boolean getFirstbaron() {
        return firstbaron;
    }

    public void setFirstbaron(Boolean firstbaron) {
        this.firstbaron = firstbaron;
    }

    public Long getDragons() {
        return dragons;
    }

    public void setDragons(Long dragons) {
        this.dragons = dragons;
    }

    public HashMap<Long, Boolean> getItens() {
        return itens;
    }

    public void setItens(HashMap<Long, Boolean> itens) {
        this.itens = itens;
    }

    String NomeJogador;
    Boolean FirstTower;
    Boolean FirstDragon;
    Boolean Resultado;
    Boolean proplayer;
    String rota;
    String campeao;
    Long farm;
    Long gold;
    Long dano;
    Boolean firstblood;
    Boolean firstaralto;
    Boolean firstbaron;
    Long dragons;
    HashMap<Long,Boolean>itens;

    Partidas(){
        this.idPartida="";
        this.NomeJogador="";
        this.FirstTower=false;
        this.FirstDragon=false;
        this.Resultado=false;
        this.proplayer=false;
        this.rota="";
        this.campeao="";
        this.farm= Long.valueOf(0);
        this.gold= Long.valueOf(0);
        this.dano= Long.valueOf(0);
        this.firstblood=false;
        this.firstaralto=false;
        this.firstbaron=false;
        this.dragons=Long.valueOf(0);
        this.itens =new HashMap<>();
        itens.put((long) 1001,false);
        itens.put((long) 1004,false);
        itens.put((long) 1006,false);
        itens.put((long) 1011,false);
        itens.put((long) 1018,false);
        itens.put((long) 1026,false);
        itens.put((long) 1027,false);
        itens.put((long) 1028,false);
        itens.put((long) 1029,false);
        itens.put((long) 1031,false);
        itens.put((long) 1033,false);
        itens.put((long) 1036,false);
        itens.put((long) 1037,false);
        itens.put((long) 1038,false);
        itens.put((long) 1039,false);
        itens.put((long) 1041,false);
        itens.put((long) 1042,false);
        itens.put((long) 1043,false);
        itens.put((long) 1051,false);
        itens.put((long) 1052,false);
        itens.put((long) 1053,false);
        itens.put((long) 1054,false);
        itens.put((long) 1055,false);
        itens.put((long) 1056,false);
        itens.put((long) 1057,false);
        itens.put((long) 1058,false);
        itens.put((long) 1082,false);
        itens.put((long) 1083,false);
        itens.put((long) 1400,false);
        itens.put((long) 1401,false);
        itens.put((long) 1402,false);
        itens.put((long) 1408,false);
        itens.put((long) 1409,false);
        itens.put((long) 1410,false);
        itens.put((long) 1412,false);
        itens.put((long) 1413,false);
        itens.put((long) 1414,false);
        itens.put((long) 1416,false);
        itens.put((long) 1418,false);
        itens.put((long) 1419,false);
        itens.put((long) 2003,false);
        itens.put((long) 2009,false);
        itens.put((long) 2010,false);
        itens.put((long) 2011,false);
        itens.put((long) 2015,false);
        itens.put((long) 2031,false);
        itens.put((long) 2032,false);
        itens.put((long) 2033,false);
        itens.put((long) 2045,false);
        itens.put((long) 2047,false);
        itens.put((long) 2049,false);
        itens.put((long) 2050,false);
        itens.put((long) 2051,false);
        itens.put((long) 2052,false);
        itens.put((long) 2053,false);
        itens.put((long) 2054,false);
        itens.put((long) 2055,false);
        itens.put((long) 2138,false);
        itens.put((long) 2139,false);
        itens.put((long) 2140,false);
        itens.put((long) 2301,false);
        itens.put((long) 2302,false);
        itens.put((long) 2303,false);
        itens.put((long) 3001,false);
        itens.put((long) 3003,false);
        itens.put((long) 3004,false);
        itens.put((long) 3006,false);
        itens.put((long) 3007,false);
        itens.put((long) 3008,false);
        itens.put((long) 3009,false);
        itens.put((long) 3010,false);
        itens.put((long) 3020,false);
        itens.put((long) 3022,false);
        itens.put((long) 3024,false);
        itens.put((long) 3025,false);
        itens.put((long) 3026,false);
        itens.put((long) 3027,false);
        itens.put((long) 3028,false);
        itens.put((long) 3029,false);
        itens.put((long) 3030,false);
        itens.put((long) 3031,false);
        itens.put((long) 3033,false);
        itens.put((long) 3034,false);
        itens.put((long) 3035,false);
        itens.put((long) 3036,false);
        itens.put((long) 3040,false);
        itens.put((long) 3041,false);
        itens.put((long) 3042,false);
        itens.put((long) 3043,false);
        itens.put((long) 3044,false);
        itens.put((long) 3046,false);
        itens.put((long) 3047,false);
        itens.put((long) 3048,false);
        itens.put((long) 3050,false);
        itens.put((long) 3052,false);
        itens.put((long) 3053,false);
        itens.put((long) 3056,false);
        itens.put((long) 3057,false);
        itens.put((long) 3060,false);
        itens.put((long) 3065,false);
        itens.put((long) 3067,false);
        itens.put((long) 3068,false);
        itens.put((long) 3069,false);
        itens.put((long) 3070,false);
        itens.put((long) 3071,false);
        itens.put((long) 3072,false);
        itens.put((long) 3073,false);
        itens.put((long) 3074,false);
        itens.put((long) 3075,false);
        itens.put((long) 3076,false);
        itens.put((long) 3077,false);
        itens.put((long) 3078,false);
        itens.put((long) 3082,false);
        itens.put((long) 3083,false);
        itens.put((long) 3084,false);
        itens.put((long) 3085,false);
        itens.put((long) 3086,false);
        itens.put((long) 3087,false);
        itens.put((long) 3089,false);
        itens.put((long) 3090,false);
        itens.put((long) 3091,false);
        itens.put((long) 3092,false);
        itens.put((long) 3094,false);
        itens.put((long) 3096,false);
        itens.put((long) 3097,false);
        itens.put((long) 3098,false);
        itens.put((long) 3100,false);
        itens.put((long) 3101,false);
        itens.put((long) 3102,false);
        itens.put((long) 3104,false);
        itens.put((long) 3105,false);
        itens.put((long) 3107,false);
        itens.put((long) 3108,false);
        itens.put((long) 3109,false);
        itens.put((long) 3110,false);
        itens.put((long) 3111,false);
        itens.put((long) 3112,false);
        itens.put((long) 3113,false);
        itens.put((long) 3114,false);
        itens.put((long) 3115,false);
        itens.put((long) 3116,false);
        itens.put((long) 3117,false);
        itens.put((long) 3122,false);
        itens.put((long) 3123,false);
        itens.put((long) 3124,false);
        itens.put((long) 3133,false);
        itens.put((long) 3134,false);
        itens.put((long) 3135,false);
        itens.put((long) 3136,false);
        itens.put((long) 3137,false);
        itens.put((long) 3139,false);
        itens.put((long) 3140,false);
        itens.put((long) 3142,false);
        itens.put((long) 3143,false);
        itens.put((long) 3144,false);
        itens.put((long) 3145,false);
        itens.put((long) 3146,false);
        itens.put((long) 3147,false);
        itens.put((long) 3151,false);
        itens.put((long) 3152,false);
        itens.put((long) 3153,false);
        itens.put((long) 3155,false);
        itens.put((long) 3156,false);
        itens.put((long) 3157,false);
        itens.put((long) 3158,false);
        itens.put((long) 3165,false);
        itens.put((long) 3170,false);
        itens.put((long) 3174,false);
        itens.put((long) 3175,false);
        itens.put((long) 3181,false);
        itens.put((long) 3184,false);
        itens.put((long) 3185,false);
        itens.put((long) 3187,false);
        itens.put((long) 3190,false);
        itens.put((long) 3191,false);
        itens.put((long) 3193,false);
        itens.put((long) 3194,false);
        itens.put((long) 3196,false);
        itens.put((long) 3197,false);
        itens.put((long) 3198,false);
        itens.put((long) 3200,false);
        itens.put((long) 3211,false);
        itens.put((long) 3222,false);
        itens.put((long) 3252,false);
        itens.put((long) 3285,false);
        itens.put((long) 3301,false);
        itens.put((long) 3302,false);
        itens.put((long) 3303,false);
        itens.put((long) 3340,false);
        itens.put((long) 3341,false);
        itens.put((long) 3345,false);
        itens.put((long) 3348,false);
        itens.put((long) 3361,false);
        itens.put((long) 3362,false);
        itens.put((long) 3363,false);
        itens.put((long) 3364,false);
        itens.put((long) 3371,false);
        itens.put((long) 3373,false);
        itens.put((long) 3374,false);
        itens.put((long) 3379,false);
        itens.put((long) 3380,false);
        itens.put((long) 3382,false);
        itens.put((long) 3383,false);
        itens.put((long) 3384,false);
        itens.put((long) 3385,false);
        itens.put((long) 3386,false);
        itens.put((long) 3401,false);
        itens.put((long) 3410,false);
        itens.put((long) 3416,false);
        itens.put((long) 3422,false);
        itens.put((long) 3455,false);
        itens.put((long) 3460,false);
        itens.put((long) 3461,false);
        itens.put((long) 3462,false);
        itens.put((long) 3504,false);
        itens.put((long) 3508,false);
        itens.put((long) 3512,false);
        itens.put((long) 3513,false);
        itens.put((long) 3599,false);
        itens.put((long) 3630,false);
        itens.put((long) 3631,false);
        itens.put((long) 3632,false);
        itens.put((long) 3633,false);
        itens.put((long) 3634,false);
        itens.put((long) 3635,false);
        itens.put((long) 3636,false);
        itens.put((long) 3637,false);
        itens.put((long) 3640,false);
        itens.put((long) 3641,false);
        itens.put((long) 3642,false);
        itens.put((long) 3643,false);
        itens.put((long) 3645,false);
        itens.put((long) 3647,false);
        itens.put((long) 3648,false);
        itens.put((long) 3649,false);
        itens.put((long) 3671,false);
        itens.put((long) 3672,false);
        itens.put((long) 3673,false);
        itens.put((long) 3675,false);
        itens.put((long) 3680,false);
        itens.put((long) 3681,false);
        itens.put((long) 3682,false);
        itens.put((long) 3683,false);
        itens.put((long) 3690,false);
        itens.put((long) 3691,false);
        itens.put((long) 3692,false);
        itens.put((long) 3693,false);
        itens.put((long) 3694,false);
        itens.put((long) 3695,false);
        itens.put((long) 3706,false);
        itens.put((long) 3711,false);
        itens.put((long) 3715,false);
        itens.put((long) 3742,false);
        itens.put((long) 3748,false);
        itens.put((long) 3751,false);
        itens.put((long) 3800,false);
        itens.put((long) 3801,false);
        itens.put((long) 3802,false);
        itens.put((long) 3812,false);
        itens.put((long) 3814,false);
        itens.put((long) 3901,false);
        itens.put((long) 3902,false);
        itens.put((long) 3903,false);
    }


}
