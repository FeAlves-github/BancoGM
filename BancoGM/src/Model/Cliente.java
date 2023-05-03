package Model;

public class Cliente {

    private static int counter = 1;

    private String nome;
    private String cpf;
    private String dta_nasc;

    public Cliente(String nome, String cpf, String dta_nasc) {
        this.nome = nome;
        this.cpf = cpf;
        this.dta_nasc = dta_nasc;
        counter += 1;
    }

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
    public String getDta_nasc() {
        return dta_nasc;
    }
    public void setDta_nasc(String dta_nasc) {
        this.dta_nasc = dta_nasc;
    }

    public String toString() {
        return "\nNome: " + this.getNome() +
                "\nCpf: " + this.getCpf() +
                "\nData de nascimento: " + this.getDta_nasc();
    }

}
