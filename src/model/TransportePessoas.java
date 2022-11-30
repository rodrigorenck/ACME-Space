package model;

public class TransportePessoas extends Transporte {
    private int quantidade;

    public TransportePessoas(int identificador, EspacoPorto origem, EspacoPorto destino, Tipo tipo, Estado estado, int quantidade) {
        super(identificador, origem, destino, tipo, estado);
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    @Override
    public String toString() {
        return "TransportePessoas{" + "identificador=" + this.getIdentificador() + ", quantidade=" + quantidade+ '}';
    }

    @Override
    public double calculaDistancia() {
        return 0; // nao entendi como calcular a distancia
    }

    @Override
    public double calculaCusto() {
        return 0;
    }
}
