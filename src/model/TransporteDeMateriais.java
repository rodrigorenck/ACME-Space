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

    public double getCarga() {
        return carga;
    }

    public String getDescricaoMaterial() {
        return descricaoMaterial;
    }

    @Override
    double calculaDistancia() {
        double a = Math.pow(getDestino().getCoordX() - getOrigem().getCoordY(), 2);
        double b = Math.pow(getDestino().getCoordY() - getOrigem().getCoordY(), 2);
        double c = Math.pow(getDestino().getCoordZ() - getOrigem().getCoordZ(), 2);
        return Math.sqrt(a + b + c);
    }

    @Override
    double calculaCusto() {
        double fatorDistancia;
        if(calculaDistancia()<0.5){
            fatorDistancia = 1000000;
        }else {
            fatorDistancia = 100;
        }
        double custoDist = fatorDistancia * calculaDistancia();
        double custoTransp = carga * 500;
        return custoDist * custoTransp;
    }

    @Override
    public String toString() {
        return "Transporte{ id: " + super.getIdentificador() + " origem: " + super.getOrigem()
                + " destino: " + super.getDestino() + " status: " + super.getStatus() + " tipo: TransporteDeMateriais{" +
                " descricaoMaterial='" + descricaoMaterial + '\'' +
                ", carga=" + carga +
                ", custo: " + calculaCusto() +
                ", distancia: " + calculaDistancia() +
                "}}";
    }
}
