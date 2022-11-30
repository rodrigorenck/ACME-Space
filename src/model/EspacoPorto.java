package model;

import java.util.List;

public class EspacoPorto {
    private int numero;
    private String nome;
    private double coordX;
    private double coordY;
    private double coordZ;
//    private List<Espaconave> listaEspaconaves;
//    private List<Transporte> listaTransportes;

    public EspacoPorto(int numero, String nome, double coordX, double coordY, double coordZ) {
        this.numero = numero;
        this.nome = nome;
        this.coordX = coordX;
        this.coordY = coordY;
        this.coordZ = coordZ;
    }

    //devolve o espacoPorto padrao = terra
    public static EspacoPorto padrao() {
        return new EspacoPorto(0, "Terra", 0, 0, 0);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCoordX() {
        return coordX;
    }

    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }

    public double getCoordZ() {
        return coordZ;
    }

    public void setCoordZ(double coordZ) {
        this.coordZ = coordZ;
    }

    @Override
    public String toString() {
        return "EspacoPorto{" +
                "numero=" + numero +
                ", nome='" + nome + '\'' +
                ", coordX=" + coordX +
                ", coordY=" + coordY +
                ", coordZ=" + coordZ +
                '}';
    }
}
