package Controller;

import Model.ContaComum;
import Model.ContaEspecial;
import Model.ContaPoupanca;

public class ContaController {

    public void CadastraContaComum(String dta_abertura, Double saldo, Double limite_valor_transacao) {

        var contaComum = new ContaComum();
        //contaComum.setCliente(cpf);
        contaComum.setDta_abertura(dta_abertura);
        contaComum.setSaldo(saldo);
        contaComum.setLimite_valor_transacao(limite_valor_transacao);

        //System.out.println(contaComum.getCliente());
        System.out.println(contaComum.getDta_abertura());
        System.out.println(contaComum.getSaldo());
        System.out.println(contaComum.getLimite_valor_transacao());

    }

    public void CadastraContaEspecial(String dta_abertura, Double saldo, Double limite_valor_transacao) {

        var contaEspecial = new ContaEspecial();
        //contaComum.setCliente(cpf);
        contaEspecial.setDta_abertura(dta_abertura);
        contaEspecial.setSaldo(saldo);
        contaEspecial.setLimite_valor_transacao(limite_valor_transacao);
        contaEspecial.setLimite_credito(saldo); //limite de crédito será diretamente proporcional ao saldo da conta


        //System.out.println(contaComum.getCliente());
        System.out.println(contaEspecial.getDta_abertura());
        System.out.println(contaEspecial.getSaldo());
        System.out.println(contaEspecial.getLimite_valor_transacao());
        System.out.println(contaEspecial.getLimite_credito());

    }

    public void CadastraContaPoupanca(String dta_abertura, Double saldo, Double limite_valor_transacao) {

        var contaPoupanca = new ContaPoupanca();
        //contaComum.setCliente(cpf);
        contaPoupanca.setDta_abertura(dta_abertura);
        contaPoupanca.setSaldo(saldo);
        contaPoupanca.setLimite_valor_transacao(limite_valor_transacao);
        //contaPoupanca.setDta_aniversario_conta(); - preciso pegar os dois primeiros caracteres da dta_abertura, separar do restante da string e transformar em int pra ser o dia do aniversario

        //System.out.println(contaComum.getCliente());
        System.out.println(contaPoupanca.getDta_abertura());
        System.out.println(contaPoupanca.getSaldo());
        System.out.println(contaPoupanca.getLimite_valor_transacao());
        System.out.println(contaPoupanca.getDta_aniversario_conta());

    }
}
