package model;

import java.util.List;

public abstract class Transporte {
    private int identificador;
    private EspacoPorto origem;
    private EspacoPorto destino;
//    //pode ter 0 ou 1 espaconave
//    private boolean temEspaconave;
    private Espaconave espaconave;
    private StatusTransporte status;
    public Transporte(int identificador, EspacoPorto origem, EspacoPorto destino) {
        this.identificador = identificador;
        this.origem = origem;
        this.destino = destino;
        this.status = StatusTransporte.PENDENTE;
    }

    abstract double calculaDistancia();
    abstract double calculaCusto();

    public void setStatus(StatusTransporte status) {
        this.status = status;
    }


    public int getIdentificador() {
        return identificador;
    }

    public EspacoPorto getOrigem() {
        return origem;
    }

    public EspacoPorto getDestino() {
        return destino;
    }

    public Espaconave getEspaconave() {
        return espaconave;
    }

    public StatusTransporte getStatus() {
        return status;
    }
}
