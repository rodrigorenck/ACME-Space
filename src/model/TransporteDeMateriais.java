package model;

public class TransporteDeMateriais extends Transporte{

    private String descricaoMaterial;
    //quantidade em toneladas
    private double carga;

    public TransporteDeMateriais(int identificador, EspacoPorto origem, EspacoPorto destino, double carga, String descricaoMaterial) {
        super(identificador, origem, destino);
        this.carga = carga;
        this.descricaoMaterial = descricaoMaterial;
    }

    @Override
    double calculaDistancia() {
        return 0;
    }

    @Override
    double calculaCusto() {
        return 0;
    }

    @Override
    public String toString() {
        return "Transporte{ id: " + super.getIdentificador() + " origem: " + super.getOrigem()
                + " destino: " + super.getDestino() + " status: " + super.getStatus() + " tipo: TransporteDeMateriais{" +
                " descricaoMaterial='" + descricaoMaterial + '\'' +
                ", carga=" + carga +
                "}}";
    }
}
