package test;

import model.espaconave.Combustivel;
import model.espaconave.Subluz;
import model.espacoporto.EspacoPorto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Autores: Rodrigo Renck, Arthur Bonazzi, Enrico Cidade
 */
public class SubluzTest {

    @Test
    public void testGetVelocidadeMaximaImpulso(){
        var espacoPorto = new EspacoPorto(1, "teste", 100, 200, 400);
        var subluz = new Subluz("teste", espacoPorto, 100, Combustivel.ION);
        assertEquals(100, subluz.getVelocidadeMaximaImpulso());
    }

    @Test
    public void testGetCombustivel(){
        var espacoPorto = new EspacoPorto(1, "teste", 100, 200, 400);
        var subluz = new Subluz("teste", espacoPorto, 100, Combustivel.ION);
        assertEquals(Combustivel.ION, subluz.getCombustivel());
    }

}
