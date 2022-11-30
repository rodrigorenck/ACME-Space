package model;

public class TransporteDePessoas extends Transporte{

    private int quantidadePessoasTransportadas;

    public TransporteDePessoas(int identificador, EspacoPorto origem, EspacoPorto destino, int quantidadePessoasTransportadas) {
        super(identificador, origem, destino);
        this.quantidadePessoasTransportadas = quantidadePessoasTransportadas;
    }

    @Override
    double calculaDistancia() {
        return 0;
    }

    @Override
    double calculaCusto() {
        return 0;
    }

    @Override
    public String toString() {
        return "Transporte{ id: " + super.getIdentificador() + " origem: " + super.getOrigem()
                + " destino: " + super.getDestino() + " status: " + super.getStatus() + " tipo: TransporteDePessoas{" +
                " quantidade de pessoas='" + quantidadePessoasTransportadas + '\'' +
                "}}";
    }
}
