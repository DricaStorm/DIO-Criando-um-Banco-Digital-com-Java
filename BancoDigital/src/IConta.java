public interface IConta {
    void depositar(double valor);
    boolean sacar(double valor);
    boolean transferir(IConta destino, double valor);
    double getSaldo();
    String getNumero();
}

