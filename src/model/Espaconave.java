package model;

import java.util.List;

/**
 * Uma espaçonave só pode ser designada para um transporte de cada
 * vez, mas em seu histórico pode ter realizado vários transportes
 */
public class Espaconave {
    //padrao eh a Terra
    private EspacoPorto espacoPorto;
    private List<Transporte> listaTransportes;
}
