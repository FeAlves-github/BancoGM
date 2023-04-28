package Model;

import java.sql.Date;

public class ContaComum {

    private Cliente cliente;
    private Date dta_abertura;
    private Double saldo;
    private Double limite_valor_transacao;

    public Date getDta_abertura() {
        return dta_abertura;
    }
    public void setDta_abertura(Date dta_abertura) {
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
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
