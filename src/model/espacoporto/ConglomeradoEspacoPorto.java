package model.espacoporto;

import java.util.ArrayList;
import java.util.List;

//classe catalogo de espaco portos
public class ConglomeradoEspacoPorto {
    private List<EspacoPorto> listaEspacoPorto;

    public ConglomeradoEspacoPorto(){
        this.listaEspacoPorto = new ArrayList<>();
        //quando criamos o conglomerado ja salvamos o espaco porto padrao que eh a terra
//        var terra = EspacoPorto.padrao();
//        listaEspacoPorto.add(terra);
    }


    public boolean existsBy(int numero) {
        for (EspacoPorto e :
                listaEspacoPorto) {
            if(e.getNumero() == numero) return true;
        }
        return false;
    }

    public void cadastra(EspacoPorto espacoPorto) {
        listaEspacoPorto.add(espacoPorto);
    }

    public EspacoPorto findById(int numero) {
        for (EspacoPorto e :
                listaEspacoPorto) {
            if(e.getNumero() == numero) return e;
        }
        return null;
    }

    public List<EspacoPorto> findAll() {
        return listaEspacoPorto;
    }
}
