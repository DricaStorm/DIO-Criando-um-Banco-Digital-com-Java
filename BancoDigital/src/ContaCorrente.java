public class ContaCorrente extends Conta {
    private static final double TAXA_SAQUE = 5.0;

    public ContaCorrente(String numero, double saldoInicial) {
        super(numero, saldoInicial);
    }

    @Override
    protected boolean sacar(double valor) {
        return super.sacar(valor + TAXA_SAQUE);
    }
}
