package test;

import model.espaconave.Espaconave;
import model.espaconave.FTL;
import model.espacoporto.EspacoPorto;
import model.transporte.TransporteDeMateriais;
import model.transporte.TransporteDePessoas;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EspaconaveTest {

    @Test
    public void testDesignarParaTransporte(){
        var espacoPorto = new EspacoPorto(1, "teste", 100, 200, 400);
        var ftl = new Espaconave("teste", espacoPorto);

        var origem = new EspacoPorto(9, "a", 1001, 2002, 4003);
        var destino = new EspacoPorto(10, "b", 1002, 2001, 4004);



        var transporte = new TransporteDePessoas(1, origem, destino, 100);

        ftl.designarParaTransporte(transporte);

        var lista = ftl.getListaTransportes();

        assertEquals(transporte, lista.get(0));
    }
}
