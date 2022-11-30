package model;

import java.util.List;

public class EspaconaveFLT extends Espaconave{
    private double velocidadeMaxWrap;
    private int limitePeessoas;
    private double limiteCarga;

    public EspaconaveFLT(EspacoPorto espacoPorto, List<Transporte> listaTransportes, double velocidadeMaxWrap, int limitePeessoas, double limiteCarga) {
        super(espacoPorto, listaTransportes);
        this.velocidadeMaxWrap = velocidadeMaxWrap;
        this.limitePeessoas = limitePeessoas;
        this.limiteCarga = limiteCarga;
    }

    public double getVelocidade() {
        return velocidadeMaxWrap;
    }

    public void setVelocidade(double velocidade) {
        this.velocidadeMaxWrap = velocidade;
    }


}
