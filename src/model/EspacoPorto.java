package model;

import java.util.List;

public class EspacoPorto {
    private int numero;
    private String nome;
    private double coordX;
    private double coordY;
    private double coordZ;
    private List<Espaconave> listaEspaconaves;
    private List<Transporte> listaTransportes;

    public EspacoPorto(int numero, String nome, double coordX, double coordY, double coordZ) {
        this.numero = numero;
        this.nome = nome;
        this.coordX = coordX;
        this.coordY = coordY;
        this.coordZ = coordZ;
    }

}
