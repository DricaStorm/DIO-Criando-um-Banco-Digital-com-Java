public abstract class Conta implements IConta {
    private String numero;
    private double saldo;

    public Conta(String numero, double saldoInicial) {
        this.numero = numero;
        this.saldo = saldoInicial;
    }

    @Override
    public String getNumero() {
        return numero;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("Valor de depósito deve ser positivo.");
        }
    }

    @Override
    public boolean transferir(IConta destino, double valor) {
        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    // Método protegido para saque, pode ser sobrescrito por subclasses
    protected abstract boolean sacar(double valor);
}
