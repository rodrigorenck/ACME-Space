package model.espaconave;

import java.util.ArrayList;
import java.util.List;

//classe catalogo de espaco naves
public class ConglomeradoEspaconave {
    private List<Espaconave> listaEspaconaves = new ArrayList<>();


    public boolean existsBy(String nome) {
        for (Espaconave e :
                listaEspaconaves) {
            if(e.getNome().equals(nome)) return true;
        }
        return false;
    }

    public void cadastra(Espaconave espaconave) {
        listaEspaconaves.add(espaconave);
    }

    public List<Espaconave> findAll(){
        return listaEspaconaves;
    }

    public Espaconave findByName(String nome) {
        for (Espaconave e :
                listaEspaconaves) {
            if(e.getNome().equals(nome)) return e;
        }
        return null;
    }
}
