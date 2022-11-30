package model;

public abstract class Transporte {
    private int identificador;
    private Tipo tipo; // CARGA OU PASSAGEIROS
    private Estado estado; // PENDENTE, TRANSPORTANDO, CANCELADO, FINALIZADO
    private EspacoPorto origem;
    private EspacoPorto destino;

    //pode ter 0 ou 1 espaconave
    private boolean temEspaconave;
    public Transporte(int identificador, EspacoPorto origem, EspacoPorto destino, Tipo tipo, Estado estado) {
        this.identificador = identificador;
        this.origem = origem;
        this.destino = destino;
        this.tipo = tipo;
        this.estado = estado;
    }

    public enum Estado {
        PENDENTE, TRANSPORTANDO, CANCELADO, FINALIZADO
    }

    public enum Tipo {
        CARGA, PASSAGEIROS
    }

    public void setEstado(String estado) {
        this.estado = Estado.valueOf(estado);
    }

    public int getIdentificador() {
        return identificador;
    }

    public

    abstract double calculaDistancia();
    abstract double calculaCusto();
}
