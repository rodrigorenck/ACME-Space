package model;

public class FTL extends Espaconave{
    private double velocidadeMaximaWarp;
    private int limiteTransporte;

    public FTL(String nome, EspacoPorto espacoPorto, double velocidadeMaximaWarp, int limiteTransporte) {
        super(nome, espacoPorto);
        this.velocidadeMaximaWarp = velocidadeMaximaWarp;
        this.limiteTransporte = limiteTransporte;
    }

    @Override
    public String toString() {
        return "Espaconave{nome: " + super.getNome() + " EspacoPorto: " + super.getEspacoPorto().getNumero() + "Tipo: FTL{" +
                "velocidadeMaximaWarp=" + velocidadeMaximaWarp +
                ", limiteTransporte=" + limiteTransporte +
                "}}";
    }
}
