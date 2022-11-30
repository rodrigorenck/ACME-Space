package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Uma espaçonave só pode ser designada para um transporte de cada
 * vez, mas em seu histórico pode ter realizado vários transportes
 */
public class Espaconave {
    //padrao eh a Terra
    private EspacoPorto espacoPorto;
    private List<Transporte> listaTransportes;
    private String nome;

    public Espaconave(String nome) {
//        this.espacoPorto;
        this.listaTransportes = new ArrayList<>();
        this.nome = nome;
    }

    public Espaconave(String nome, EspacoPorto espacoPorto){
        this.nome = nome;
        this.espacoPorto = espacoPorto;
    }

    public void designarParaTransporte(Transporte t){
        listaTransportes.add(t);
//        t.proximoEstado();
        t.setStatus(StatusTransporte.TRANSPORTANDO);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EspacoPorto getEspacoPorto() {
        return espacoPorto;
    }
}
