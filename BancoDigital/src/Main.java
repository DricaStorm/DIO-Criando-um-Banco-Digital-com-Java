public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        // Criando clientes
        Cliente cliente1 = new Cliente("João");
        Cliente cliente2 = new Cliente("Maria");

        // Adicionando contas aos clientes
        ContaCorrente contaCorrente = new ContaCorrente("CC123", 500.0);
        ContaPoupanca contaPoupanca = new ContaPoupanca("CP123", 1000.0);

        cliente1.adicionarConta(contaCorrente);
        cliente2.adicionarConta(contaPoupanca);

        banco.adicionarCliente(cliente1);
        banco.adicionarCliente(cliente2);

        // Realizando operações
        contaCorrente.depositar(200);
        contaPoupanca.aplicarRendimento();

        banco.realizarTransferencia("João", "CC123", "CP123", 150);

        System.out.println("Conta Corrente: " + contaCorrente.getNumero() + ", Saldo: " + contaCorrente.getSaldo());
        System.out.println("Conta Poupança: " + contaPoupanca.getNumero() + ", Saldo: " + contaPoupanca.getSaldo());
    }
}
