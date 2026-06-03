package Banking.model;

public class Movimentacao {
    public enum Tipo {DEPOSITO, SAQUE}
    private final Tipo tipo;
    private final double quantidade;

    Movimentacao(Tipo tipo, double quantidade) {
        this.tipo = tipo;
        this.quantidade = quantidade;
    }

    Movimentacao getMovimentacao() {
        return this;
    }

    @Override
    public String toString() {
        return (this.tipo == Tipo.DEPOSITO ? "Deposito" : "Saque") + " de R$" + this.quantidade;
    }
}
