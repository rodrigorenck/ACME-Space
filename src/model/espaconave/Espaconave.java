package model.espaconave;

import model.espacoporto.EspacoPorto;
import model.transporte.StatusTransporte;
import model.transporte.Transporte;

import java.util.ArrayList;
import java.util.List;

/**
 * Uma espaçonave só pode ser designada para um transporte de cada
 * vez, mas em seu histórico pode ter realizado vários transportes
 */
public class Espaconave {
    //padrao eh a Terra
    private EspacoPorto espacoPorto;
    private List<Transporte> listaTransportes = new ArrayList<>();
    private String nome;

    public Espaconave(String nome) {
        this.listaTransportes = new ArrayList<>();
        this.nome = nome;
    }

    public Espaconave(String nome, EspacoPorto espacoPorto){
        this.nome = nome;
        this.espacoPorto = espacoPorto;
    }

    public void addTransporte(Transporte t){
        listaTransportes.add(t);
    }

    public void designarParaTransporte(Transporte t){
        listaTransportes.add(t);
        t.setStatus(StatusTransporte.TRANSPORTANDO);
    }

    public List<Transporte> getListaTransportes() {
        return listaTransportes;
    }

    public String getNome() {
        return nome;
    }

    public EspacoPorto getEspacoPorto() {
        return espacoPorto;
    }
}
