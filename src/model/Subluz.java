package model;

public class Subluz extends Espaconave {
    //limite eh de 0,3 warp
    private double velocidadeMaximaImpulso;
    //nuclear ou ion
    private Combustivel combustivel;

    public Subluz(String nome, EspacoPorto espacoPorto, double velocidadeMaximaImpulso, Combustivel combustivel) {
        super(nome, espacoPorto);
        this.velocidadeMaximaImpulso = velocidadeMaximaImpulso;
        this.combustivel = combustivel;
    }

    @Override
    public String toString() {
        return "Espaconave{nome: " + super.getNome() + " EspacoPorto: " + super.getEspacoPorto().getNumero() + "Tipo: Subluz{" +
                "velocidadeMaximaImpulso=" + velocidadeMaximaImpulso +
                ", combustivel=" + combustivel +
                "}}";
    }
}
