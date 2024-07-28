import java.util.HashMap;
import java.util.Map;

public class Banco {
    private Map<String, Cliente> clientes;

    public Banco() {
        clientes = new HashMap<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.put(cliente.getNome(), cliente);
    }

    public Cliente getCliente(String nome) {
        return clientes.get(nome);
    }

    public boolean realizarTransferencia(String nomeCliente, String numeroOrigem, String numeroDestino, double valor) {
        Cliente cliente = getCliente(nomeCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return false;
        }

        IConta origem = cliente.getConta(numeroOrigem);
        IConta destino = cliente.getConta(numeroDestino);

        if (origem != null && destino != null) {
            return origem.transferir(destino, valor);
        } else {
            System.out.println("Conta de origem ou destino não encontrada.");
            return false;
        }
    }
}
