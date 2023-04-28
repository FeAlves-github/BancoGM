import Controller.ClienteController;

import java.text.ParseException;
import java.util.Scanner;

public class BancoGM {
    public static void main(String[] args) throws ParseException {

        Scanner ler = new Scanner(System.in);

        System.out.println("Olá, gerente! Escolha uma das opções abaixo");
        System.out.println("1. Cadastrar Cliente");
        System.out.println("2. Cadastrar Conta");
        System.out.println("3. Visualizar Clientes");
        System.out.println("4. Visualizar Contas");
        System.out.println("5. Realizar depósito");
        System.out.println("6. Realizar saque");
        System.out.println("7. Realizar transferência");

        int op = ler.nextInt();

        switch (op) {
            case 1 -> {
                System.out.println("Digite os Dados do Cliente:");
                System.out.println("Nome:");
                String nome = ler.next();
                System.out.println("CPF:");
                String cpf = ler.next();
                //System.out.println("Data de Nascimento:");
                //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                //Date data_nasc = sdf.parse(ler.nextLine());

                var cliente = new ClienteController();
                cliente.CadastraCliente(nome, cpf);
            }
            case 2 -> {
                System.out.println("1. Conta Comum");
                System.out.println("2. Conta Especial");
                System.out.println("3. Conta Poupança");
                Integer conta = ler.nextInt();
                System.out.println(conta);
            }
            case 3 -> {

            }
        }

    }
}
