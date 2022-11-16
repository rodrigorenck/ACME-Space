package model;

public class TransporteDePessoas extends Transporte{

    private int quantidadePessoasTransportadas;

    public TransporteDePessoas(int identificador, EspacoPorto origem, EspacoPorto destino) {
        super(identificador, origem, destino);
    }

    @Override
    double calculaDistancia() {
        return 0;
    }

    @Override
    double calculaCusto() {
        return 0;
    }
}
