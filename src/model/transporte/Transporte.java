package model.transporte;

import model.espacoporto.EspacoPorto;
import model.espaconave.Espaconave;

public abstract class Transporte {
    private int identificador;
    private EspacoPorto origem;
    private EspacoPorto destino;
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

    public void setEspaconave(Espaconave espaconave) {
        this.espaconave = espaconave;
        espaconave.addTransporte(this);
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
