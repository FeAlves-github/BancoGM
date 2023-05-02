package Controller;

import Model.ContaComum;

public class ContaController {

    public void CadastraConta(String dta_abertura, Double saldo, Double limite_valor_transacao) {

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
}
