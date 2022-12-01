package model.espaconave;

import model.espacoporto.EspacoPorto;

public class FTL extends Espaconave {
    private double velocidadeMaximaWarp;
    private int limiteTransporte;

    public FTL(String nome, EspacoPorto espacoPorto, double velocidadeMaximaWarp, int limiteTransporte) {
        super(nome, espacoPorto);
        this.velocidadeMaximaWarp = velocidadeMaximaWarp;
        this.limiteTransporte = limiteTransporte;
    }


    public double getVelocidadeMaximaWarp() {
        return velocidadeMaximaWarp;
    }

    public int getLimiteTransporte() {
        return limiteTransporte;
    }

    @Override
    public String toString() {
        return "Espaconave{nome: " + super.getNome() + " EspacoPorto: " + super.getEspacoPorto().getNumero() + "Tipo: FTL{" +
                "velocidadeMaximaWarp=" + velocidadeMaximaWarp +
                ", limiteTransporte=" + limiteTransporte +
                "}}";
    }
}
