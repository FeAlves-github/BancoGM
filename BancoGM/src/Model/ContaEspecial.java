package Model;

public class ContaEspecial extends ContaComum{

    //private static int contadorDeConta = 1;
    private Double limite_credito;

    public ContaEspecial(Cliente cliente, String dta_abertura, Double limite_valor_transacao, Double limite_credito, Integer tipo_conta) {
        super();
        this.contadorDeConta +=1;
        this.setNumeroConta(getContadorDeConta());
        this.setCliente(cliente);
        this.updateSaldo();
        this.setDta_abertura(dta_abertura);
        this.setLimite_valor_transacao(limite_valor_transacao);
        this.limite_credito = limite_credito;
        this.setTipo_conta(tipo_conta);
        this.setDesc_tipoConta("CONTA ESPECIAL");
    }

    public Double getLimite_credito() {
        return limite_credito;
    }

    public void setLimite_credito(Double limite_credito) {
        this.limite_credito = limite_credito;
    }

    public void sacarContaEspecial (Double valor){
        if(valor > 0 && (this.getSaldo()+this.getLimite_credito()) >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso!");

        } else {
            System.out.println("Não foi possível realizar o saque!");
        }
    }

    public void transferirContaEspecial (ContaComum contaParaDeposito, Double valor){
        if(valor > 0 && (this.getSaldo()+this.getLimite_credito()) >= valor && valor <= this.getLimite_valor_transacao()){
            setSaldo(getSaldo() - valor);

            contaParaDeposito.setSaldo(contaParaDeposito.getSaldo() + valor);
            System.out.println("Transferência realizada com sucesso!");

        } else {
            System.out.println("Não foi possível realizar a transferência!");
        }
    }

    public void alterarLimiteCredito(ContaEspecial contaEspecial, Double novoLimite) {
        contaEspecial.setLimite_credito(novoLimite);
    }
}
