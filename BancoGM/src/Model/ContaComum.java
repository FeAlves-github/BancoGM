package Model;

import Utilitarios.Utils;

public class ContaComum {

    public static int contadorDeConta = 0;
    private int numeroConta;
    private Cliente cliente;
    private String dta_abertura;
    private Double saldo = 0.0;
    private Double limite_valor_transacao;
    private Integer tipo_conta;
    private String desc_tipoConta;


    public ContaComum(Cliente cliente, String dta_abertura, Double limite_valor_transacao, Integer tipo_conta) {
        this.contadorDeConta +=1;
        this.numeroConta = ContaComum.contadorDeConta;
        this.cliente = cliente;
        this.updateSaldo();
        this.dta_abertura = dta_abertura;
        this.limite_valor_transacao = limite_valor_transacao;
        this.tipo_conta = tipo_conta;
        this.desc_tipoConta = "CONTA COMUM";
    }

    public ContaComum() {
    }

    public int getContadorDeConta() {
        return contadorDeConta;
    }

    public void setContadorDeConta(int contadorDeConta) {
        this.contadorDeConta = contadorDeConta;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDta_abertura() {
        return dta_abertura;
    }

    public void setDta_abertura(String dta_abertura) {
        this.dta_abertura = dta_abertura;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getLimite_valor_transacao() {
        return limite_valor_transacao;
    }

    public void setLimite_valor_transacao(Double limite_valor_transacao) {
        this.limite_valor_transacao = limite_valor_transacao;
    }

    public Integer getTipo_conta() {
        return tipo_conta;
    }

    public void setTipo_conta(Integer tipo_conta) {
        this.tipo_conta = tipo_conta;
    }

    public String getDesc_tipoConta() {
        return desc_tipoConta;
    }

    public void setDesc_tipoConta(String desc_tipoConta) {
        this.desc_tipoConta = desc_tipoConta;
    }

    void updateSaldo() {
        this.saldo = this.getSaldo();
    }

    public String toString() {
        return  "\nNúmero da conta: " + this.getNumeroConta() +
                "\nNome: " + this.cliente.getNome() +
                "\nCpf: " + this.cliente.getCpf() +
                "\nTipo de conta: " + this.getDesc_tipoConta() +
                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
                "\n";
    }

    public void depositar (Double valor){
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Não foi possível realizar o depósito!");
        }
    }

    public void sacar (Double valor) {
        if (valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Não foi possível realizar o saque!");
        }
    }

    public void transferir (ContaComum contaParaDeposito, Double valor){
        if(valor > 0 && this.getSaldo() >= valor && valor <= this.getLimite_valor_transacao()){
            setSaldo(getSaldo() - valor);

            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("Transferência realizada com sucesso!");

        } else {
            System.out.println("Não foi possível realizar a transferência!");
        }
    }

    public void alterarLimiteTransacao(ContaComum contaComum, Double novoLimite) {
        contaComum.setLimite_valor_transacao(novoLimite);
    }
}
