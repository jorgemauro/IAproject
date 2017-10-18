public class Partidas {
    String idPartida;
    String NomeJogador;
    Boolean FirstToew;
    Boolean FirstDragon;
    Boolean Resultado;
    Boolean []itens;
    Partidas(){
    }

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

    public Boolean[] getItens() {
        return itens;
    }

    public void setItens(Boolean[] itens) {
        this.itens = itens;
    }
}
