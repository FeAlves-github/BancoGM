package Controller;

import Model.Cliente;

public class ClienteController {

    public void CadastraCliente(String nome, String cpf, String data_nasc){

        var cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setDta_nasc(data_nasc);

        System.out.println(cliente.getNome());
        System.out.println(cliente.getCpf());
        System.out.println(cliente.getDta_nasc());
    }

}
