package test;


import model.espacoporto.EspacoPorto;
import model.transporte.StatusTransporte;
import model.transporte.TransporteDeMateriais;
import model.transporte.TransporteDePessoas;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransporteDePessoasTest {

    @Test
    public void testCalculaDistancia(){
        var origem = new EspacoPorto(1, "teste", 100, 200, 400);
        var destino = new EspacoPorto(2, "teste2", 300 , 150, 120);
        var transporte = new TransporteDePessoas(10, origem, destino, 100);
        assertEquals(301.4962686336267, transporte.calculaDistancia());
    }

    @Test
    public void testCalculaCusto(){
        var origem = new EspacoPorto(1, "teste", 0.00001900000000, 0.00001890000000, -0.00002200000000);
        var destino = new EspacoPorto(2, "teste2", -51.23900000000000 , 26.81950000000000, -55.99590000000000);
        var transporte = new TransporteDePessoas(10, origem, destino, 1000);
        assertEquals(8.050006197077551E8, transporte.calculaCusto());
    }

    @Test
    public void testGetPessoas(){
        var origem = new EspacoPorto(1, "teste", 0.00001900000000, 0.00001890000000, -0.00002200000000);
        var destino = new EspacoPorto(2, "teste2", -51.23900000000000 , 26.81950000000000, -55.99590000000000);
        var transporte = new TransporteDePessoas(10, origem, destino, 1000);

        assertEquals(1000, transporte.getQuantidadePessoasTransportadas());
    }

    @Test
    public void testEstado(){
        var origem = new EspacoPorto(1, "teste", 0.00001900000000, 0.00001890000000, -0.00002200000000);
        var destino = new EspacoPorto(2, "teste2", -51.23900000000000 , 26.81950000000000, -55.99590000000000);
        var transporte = new TransporteDePessoas(10, origem, destino, 1000);

        assertEquals(StatusTransporte.PENDENTE, transporte.getStatus());
    }
}
