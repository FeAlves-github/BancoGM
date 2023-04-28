package Controller;

import Model.Cliente;

public class ClienteController {

    public void CadastraCliente(String nome, String cpf){

        var cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);

        System.out.println(cliente.getNome());
        System.out.println(cliente.getCpf());
    }

}
