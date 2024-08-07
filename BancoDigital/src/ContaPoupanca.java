public class ContaPoupanca extends Conta {
    private static final double RENDIMENTO = 0.02;

    public ContaPoupanca(String numero, double saldoInicial) {
        super(numero, saldoInicial);
    }

    @Override
    public boolean sacar(double valor) {
        return sacar(valor);
    }

    public void aplicarRendimento() {
        double rendimento = getSaldo() * RENDIMENTO;
        depositar(rendimento);
    }
}
