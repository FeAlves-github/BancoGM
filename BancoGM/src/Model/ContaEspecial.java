package Model;

public class ContaEspecial extends ContaComum{

    //private static int contadorDeConta = 1;
    private Double limite_credito;

    public ContaEspecial(Cliente cliente, String dta_abertura, Double limite_valor_transacao, Double limite_credito) {
        super();
        this.setNumeroConta(getContadorDeConta()+1);
        this.setCliente(cliente);
        this.updateSaldo();
        this.setDta_abertura(dta_abertura);
        this.setLimite_valor_transacao(limite_valor_transacao);
        this.limite_credito = limite_credito;
    }

    public Double getLimite_credito() {
        return limite_credito;
    }

    public void setLimite_credito(Double limite_credito) {
        this.limite_credito = limite_credito;
    }
    
}
