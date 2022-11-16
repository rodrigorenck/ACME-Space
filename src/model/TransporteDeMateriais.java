package model;

public class TransporteDeMateriais extends Transporte{

    private String descricaoMaterial;
    //quantidade em toneladas
    private double carga;

    public TransporteDeMateriais(int identificador, EspacoPorto origem, EspacoPorto destino) {
        super(identificador, origem, destino);
    }

    @Override
    double calculaDistancia() {
        return 0;
    }

    @Override
    double calculaCusto() {
        return 0;
    }
}
