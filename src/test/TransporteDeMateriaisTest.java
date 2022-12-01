package test;


import model.espacoporto.EspacoPorto;
import model.transporte.StatusTransporte;
import model.transporte.TransporteDeMateriais;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransporteDeMateriaisTest {

    @Test
    public void testCalculaDistancia(){
        var origem = new EspacoPorto(1, "teste", 100, 200, 400);
        var destino = new EspacoPorto(2, "teste2", 300 , 150, 120);
        var transporte = new TransporteDeMateriais(10, origem, destino, 100, "descricao");
        assertEquals(301.4962686336267, transporte.calculaDistancia());
    }

    @Test
    public void testCalculaCusto(){
        var origem = new EspacoPorto(1, "teste", 0.00001900000000, 0.00001890000000, -0.00002200000000);
        var destino = new EspacoPorto(2, "teste2", -51.23900000000000 , 26.81950000000000, -55.99590000000000);
        var transporte = new TransporteDeMateriais(10, origem, destino, 1000, "descricao");

        assertEquals(4.0250030985387754E9, transporte.calculaCusto());
    }

    @Test
    public void testGetCarga(){
        var origem = new EspacoPorto(1, "teste", 0.00001900000000, 0.00001890000000, -0.00002200000000);
        var destino = new EspacoPorto(2, "teste2", -51.23900000000000 , 26.81950000000000, -55.99590000000000);
        var transporte = new TransporteDeMateriais(10, origem, destino, 1000, "descricao");

        assertEquals(1000, transporte.getCarga());
    }

    @Test
    public void testGetDescricao(){
        var origem = new EspacoPorto(1, "teste", 0.00001900000000, 0.00001890000000, -0.00002200000000);
        var destino = new EspacoPorto(2, "teste2", -51.23900000000000 , 26.81950000000000, -55.99590000000000);
        var transporte = new TransporteDeMateriais(10, origem, destino, 1000, "descricao");

        assertEquals("descricao", transporte.getDescricaoMaterial());
    }

    @Test
    public void testEstado(){
        var origem = new EspacoPorto(1, "teste", 0.00001900000000, 0.00001890000000, -0.00002200000000);
        var destino = new EspacoPorto(2, "teste2", -51.23900000000000 , 26.81950000000000, -55.99590000000000);
        var transporte = new TransporteDeMateriais(10, origem, destino, 1000, "descricao");

        assertEquals(StatusTransporte.PENDENTE, transporte.getStatus());
    }

}
