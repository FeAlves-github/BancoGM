package Model;

import java.util.Date;

public class Cliente {
    
    private String nome;
    private String cpf;
    private Date dta_nasc;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Date getDta_nasc() {
        return dta_nasc;
    }
    public void setDta_nasc(Date dta_nasc) {
        this.dta_nasc = dta_nasc;
    }

    

}
