package model;

public class TransporteDePessoas extends Transporte{

    private int quantidadePessoasTransportadas;

    public TransporteDePessoas(int identificador, EspacoPorto origem, EspacoPorto destino, int quantidadePessoasTransportadas) {
        super(identificador, origem, destino);
        this.quantidadePessoasTransportadas = quantidadePessoasTransportadas;
    }

    @Override
    double calculaDistancia() {
        double a = Math.pow(getDestino().getCoordX() - getOrigem().getCoordY(), 2);
        double b = Math.pow(getDestino().getCoordY() - getOrigem().getCoordY(), 2);
        double c = Math.pow(getDestino().getCoordZ() - getOrigem().getCoordZ(), 2);
        return Math.sqrt(a + b + c);
    }

    @Override
    double calculaCusto() {
        double fatorDistancia;
        if(calculaDistancia()<0.5){
            fatorDistancia = 1000000;
        }else {
            fatorDistancia = 100;
        }
        double custoDist = fatorDistancia * calculaDistancia();
        double custoTransp = quantidadePessoasTransportadas * 100;
        return custoDist * custoTransp;
    }

    public int getQuantidadePessoasTransportadas() {
        return quantidadePessoasTransportadas;
    }

    @Override
    public String toString() {
        return "Transporte{ id: " + super.getIdentificador() + " origem: " + super.getOrigem()
                + " destino: " + super.getDestino() + " status: " + super.getStatus() + " tipo: TransporteDePessoas{" +
                " quantidade de pessoas='" + quantidadePessoasTransportadas + '\'' +
                " custo: " + calculaCusto() +
                " distancia: " + calculaDistancia() +
                "}}";
    }
}
