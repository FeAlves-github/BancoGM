package Model;

public class ContaPoupanca extends ContaComum{
    
    private Integer dta_aniversario_conta;

    public ContaPoupanca(Integer dta_aniversario_conta) {
        super();
        this.dta_aniversario_conta = dta_aniversario_conta;
    }

    public Integer getDta_aniversario_conta() {
        return dta_aniversario_conta;
    }

    public void setDta_aniversario_conta(Integer dta_aniversario_conta) {
        this.dta_aniversario_conta = dta_aniversario_conta;
    }

}
