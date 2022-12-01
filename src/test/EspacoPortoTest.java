package test;

import model.espacoporto.EspacoPorto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EspacoPortoTest {

    @Test
    public void testGetNumero() {
        var espacoPorto = new EspacoPorto(10, "teste", 1, 2, 3);

        assertEquals(10, espacoPorto.getNumero());
    }

    @Test
    public void testGetNome() {
        var espacoPorto = new EspacoPorto(10, "teste", 1, 2, 3);

        assertEquals("teste", espacoPorto.getNome());
    }

    @Test
    public void testGetCoordX() {
        var espacoPorto = new EspacoPorto(10, "teste", 1, 2, 3);

        assertEquals(1, espacoPorto.getCoordX());
    }

    @Test
    public void testGetCoordY() {
        var espacoPorto = new EspacoPorto(10, "teste", 1, 2, 3);

        assertEquals(2, espacoPorto.getCoordY());
    }

    @Test
    public void testGetCoordZ() {
        var espacoPorto = new EspacoPorto(10, "teste", 1, 2, 3);

        assertEquals(3, espacoPorto.getCoordZ());
    }
}