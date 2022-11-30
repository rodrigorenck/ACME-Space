package model;

import java.util.List;

public class EspaconaveSubLuz extends Espaconave{
    private double velocidadeMaxImpulso;
    private Combustivel combustivel;

    public EspaconaveSubLuz(EspacoPorto espacoPorto, List<Transporte> listaTransportes, double velocidadeMaxImpulso, Combustivel combustivel) {
        super(espacoPorto, listaTransportes);
        this.velocidadeMaxImpulso = velocidadeMaxImpulso;
        this.combustivel = combustivel;

    }

    public enum Combustivel{
        NUCLEAR, IONICO;
    }

    public double getVelocidade() {
        return velocidadeMaxImpulso;
    }

    public void setVelocidade(double velocidade) {
        this.velocidadeMaxImpulso = velocidade;
    }


}
