package test;

import model.espaconave.FTL;
import model.espacoporto.EspacoPorto;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Autores: Rodrigo Renck, Arthur Bonazzi, Enrico Cidade
 */
public class FTLTest {

    @Test
    public void testGetVelocidadeMaximaWarp(){
        var espacoPorto = new EspacoPorto(1, "teste", 100, 200, 400);
        var flt = new FTL("teste", espacoPorto, 120, 10);

        assertEquals(120, flt.getVelocidadeMaximaWarp());
    }

    @Test
    public void testGetLimiteTransporte(){
        var espacoPorto = new EspacoPorto(1, "teste", 100, 200, 400);
        var flt = new FTL("teste", espacoPorto, 120, 10);

        assertEquals(10, flt.getLimiteTransporte());
    }
}
