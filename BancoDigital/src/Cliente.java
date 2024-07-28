import java.util.HashMap;
import java.util.Map;

public class Cliente {
    private String nome;
    private Map<String, IConta> contas;

    public Cliente(String nome) {
        this.nome = nome;
        this.contas = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarConta(IConta conta) {
        contas.put(conta.getNumero(), conta);
    }

    public IConta getConta(String numero) {
        return contas.get(numero);
    }
}
