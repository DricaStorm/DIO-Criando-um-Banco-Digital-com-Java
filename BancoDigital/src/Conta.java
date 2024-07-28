// Classe base Conta
abstract class Conta {
    private String numero;
    private double saldo;

    public Conta(String numero, double saldoInicial) {
        this.numero = numero;
        this.saldo = saldoInicial;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("Valor de depósito deve ser positivo.");
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
            return false;
        }
    }

    public boolean transferir(Conta destino, double valor) {
        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Número: " + numero + ", Saldo: " + saldo;
    }
}

// Conta Corrente
class ContaCorrente extends Conta {
    private static final double TAXA_SAQUE = 5.0;

    public ContaCorrente(String numero, double saldoInicial) {
        super(numero, saldoInicial);
    }

    @Override
    public boolean sacar(double valor) {
        return super.sacar(valor + TAXA_SAQUE);
    }
}

// Conta Poupança
class ContaPoupanca extends Conta {
    private static final double RENDIMENTO = 0.02;

    public ContaPoupanca(String numero, double saldoInicial) {
        super(numero, saldoInicial);
    }

    public void aplicarRendimento() {
        double saldoAtual = getSaldo();
        depositar(saldoAtual * RENDIMENTO);
    }
}

// Banco
class Banco {
    private List<Conta> contas;

    public Banco() {
        contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public Conta buscarConta(String numero) {
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numero)) {
                return conta;
            }
        }
        return null;
    }

    public void realizarTransferencia(String numeroOrigem, String numeroDestino, double valor) {
        Conta origem = buscarConta(numeroOrigem);
        Conta destino = buscarConta(numeroDestino);

        if (origem != null && destino != null) {
            if (origem.transferir(destino, valor)) {
                System.out.println("Transferência realizada com sucesso!");
            } else {
                System.out.println("Falha na transferência.");
            }
        } else {
            System.out.println("Conta de origem ou destino não encontrada.");
        }
    }
}

// Exemplo de uso
public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        
        ContaCorrente contaCorrente = new ContaCorrente("CC123", 500.0);
        ContaPoupanca contaPoupanca = new ContaPoupanca("CP123", 1000.0);

        banco.adicionarConta(contaCorrente);
        banco.adicionarConta(contaPoupanca);

        contaCorrente.depositar(200);
        contaPoupanca.aplicarRendimento();

        banco.realizarTransferencia("CC123", "CP123", 150);
        
        System.out.println(contaCorrente);
        System.out.println(contaPoupanca);
    }
}

