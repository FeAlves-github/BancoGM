package Model;

public class ContaEspecial extends ContaComum{

    private Double limite_credito;

    public ContaEspecial(Double limite_credito) {
        super();
        this.limite_credito = limite_credito;
    }

    public Double getLimite_credito() {
        return limite_credito;
    }

    public void setLimite_credito(Double limite_credito) {
        this.limite_credito = limite_credito;
    }
    
}
