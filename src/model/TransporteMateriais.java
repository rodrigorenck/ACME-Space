package model;

public class TransporteMateriais extends Transporte {
    private double carga;
    private String descricao;

    public TransporteMateriais(int identificador, EspacoPorto origem, EspacoPorto destino, Tipo tipo, Estado estado, double carga, String descricao) {
        super(identificador, origem, destino, tipo, estado);
        this.carga = carga;
        this.descricao = descricao;
    }

    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "TransporteMateriais{" + "identificador=" + this.getIdentificador() + ", carga=" + carga + ", descricao=" + descricao + '}';
    }

    @Override
    public double calculaDistancia() {
        return 0; // nao entendi como calcular a distancia
    }

    @Override
    public double calculaCusto() {
        return 0;
    }
}

