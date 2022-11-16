package model;

import java.util.List;

public abstract class Transporte {
    private int identificador;
    private EspacoPorto origem;
    private EspacoPorto destino;
    //pode ter 0 ou 1 espaconave
    private boolean temEspaconave;
    private StatusTransporte status;
    public Transporte(int identificador, EspacoPorto origem, EspacoPorto destino) {
        this.identificador = identificador;
        this.origem = origem;
        this.destino = destino;
        this.status = StatusTransporte.PENDENTE;
        this.temEspaconave = false;
    }

    abstract double calculaDistancia();
    abstract double calculaCusto();

    public void setStatus(StatusTransporte status) {
        this.status = status;
    }

    public void temEspaconave(){
        this.temEspaconave = true;
    }
}
