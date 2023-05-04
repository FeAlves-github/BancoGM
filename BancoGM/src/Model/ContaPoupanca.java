package Model;

public class ContaPoupanca extends ContaComum{

    //private static int contadorDeConta = 1;
    private Integer dta_aniversario_conta;
    public ContaPoupanca(Cliente cliente, String dta_abertura, Double limite_valor_transacao, Integer dta_aniversario_conta) {
        super();
        this.setNumeroConta(getContadorDeConta()+1);
        this.setNumeroConta(getContadorDeConta());
        this.setCliente(cliente);
        this.updateSaldo();
        this.setDta_abertura(dta_abertura);
        this.setLimite_valor_transacao(limite_valor_transacao);
        this.dta_aniversario_conta = dta_aniversario_conta;
    }

    public Integer getDta_aniversario_conta() {
        return dta_aniversario_conta;
    }

    public void setDta_aniversario_conta(Integer dta_aniversario_conta) {
        this.dta_aniversario_conta = dta_aniversario_conta;
    }

}
