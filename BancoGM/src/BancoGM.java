import Model.Cliente;
import Model.ContaComum;
import Model.ContaEspecial;
import Model.ContaPoupanca;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class BancoGM {
    static Scanner ler = new Scanner(System.in);
    static ArrayList<ContaComum> contasComum;
    static ArrayList<ContaEspecial> contasEspeciais;
    static ArrayList<ContaPoupanca> contasPoupancas;

    public static void main(String[] args) throws ParseException {

        contasComum = new ArrayList<ContaComum>();
        contasEspeciais = new ArrayList<ContaEspecial>();
        contasPoupancas = new ArrayList<ContaPoupanca>();
        operacoes();
    }

    public static void operacoes(){

        System.out.println("------------------------------------------------");
        System.out.println("------ Olá, gerente! ---------------------------");
        System.out.println("------ Escolha uma das opções abaixo: ----------");
        System.out.println("|       1. Criar Conta                         |");
        System.out.println("|       2. Listar Contas                       |");
        System.out.println("|       3. Realizar depósito                   |");
        System.out.println("|       4. Realizar saque                      |");
        System.out.println("|       5. Realizar transferência              |");
        System.out.println("|       6. Sair                                |");

        int op = ler.nextInt();

        switch (op) {
            case 1 -> {
                criarConta();
                break;
                //System.out.println("Digite os Dados do Cliente:");
                //System.out.println("Nome:");
                //String nome = ler.next();
                //System.out.println("CPF:");
                //String cpf = ler.next();
                //System.out.println("Data de Nascimento:");
                //String data_nasc = ler.next();
                //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                //Date data_nasc = sdf.parse(ler.nextLine());

                //var cliente = new ClienteController();
                //cliente.CadastraCliente(nome, cpf, data_nasc);
            }
            case 2 -> {
                listar();
                break;
                //System.out.println("Qual tipo de conta deseja cadastrar?");
                //System.out.println("1. Conta Comum");
                //System.out.println("2. Conta Especial");
                //System.out.println("3. Conta Poupança");
                //Integer opConta = ler.nextInt();
                //System.out.println(opConta);

                //if (opConta==1){

                    //System.out.println("--CONTA COMUM--");
                    //System.out.println("Preencha os dados abaixo:");
                    //System.out.println("Data de abertura da conta:");
                    //String dta_abertura = ler.next();
                    //System.out.println("Saldo inicial:");
                    //Double saldo = ler.nextDouble();
                    //System.out.println("Limite por transação:");
                    //Double limite = ler.nextDouble();

                    //var conta = new ContaController();
                    //conta.CadastraContaComum(dta_abertura, saldo, limite);

                //} if (opConta==2){

                    //System.out.println("--CONTA ESPECIAL--");
                    //System.out.println("Preencha os dados abaixo:");
                    //System.out.println("Data de abertura da conta:");
                    //String dta_abertura = ler.next();
                    //System.out.println("Saldo inicial:");
                    //Double saldo = ler.nextDouble();
                    //System.out.println("Limite por transação:");
                    //Double limite = ler.nextDouble();

                    //var conta = new ContaController();
                    //conta.CadastraContaComum(dta_abertura, saldo, limite);

               // } if (opConta==3){

                    //System.out.println("--CONTA POUPANÇA--");
                    //System.out.println("Preencha os dados abaixo:");
                    //System.out.println("Data de abertura da conta:");
                   //String dta_abertura = ler.next();
                    //System.out.println("Saldo inicial:");
                    //Double saldo = ler.nextDouble();
                   // System.out.println("Limite por transação:");
                    //Double limite = ler.nextDouble();

                    //var conta = new ContaController();
                   //conta.CadastraContaPoupanca(dta_abertura, saldo, limite);

                }
            case 3 -> {
                depositar();
                break;
            }
            case 4 -> {
                sacar();
                break;
            }
            case 5 -> {
                transferir();
                break;
            }
            case 6 -> {
                System.out.println("Saindo...");
                System.exit(0);
            }
            default -> {
                System.out.println("Opção inválida");
                operacoes();
                break;
            }
        }
    }

    public static void criarConta(){

        System.out.println("----- Digite os dados do cliente: -----");
        System.out.println("Nome:");
        String nome = ler.next();
        System.out.println("CPF:");
        String cpf = ler.next();
        System.out.println("Data de Nascimento:");
        String data_nasc = ler.next();

        System.out.println("----- Qual tipo de conta deseja cadastrar? -----");
        System.out.println("1. Conta Comum");
        System.out.println("2. Conta Especial");
        System.out.println("3. Conta Poupança");
        Integer opConta = ler.nextInt();

        System.out.println("Data de abertura da conta:");
        String dta_abertura = ler.next();

        System.out.println("Limite por transação:");
        Double limite = ler.nextDouble();

        Cliente cliente = new Cliente(nome, cpf, data_nasc);

        if (opConta == 1){
            ContaComum contaComum = new ContaComum(cliente, dta_abertura, limite);
            contasComum.add(contaComum);
            System.out.println("Conta criada com sucesso!");

        } if (opConta == 2){
            ContaEspecial contaEspecial = new ContaEspecial(cliente, dta_abertura, limite);
            contasEspeciais.add(contaEspecial);
            System.out.println("Conta criada com sucesso!");

        } if (opConta == 3){
            ContaPoupanca contaPoupanca = new ContaPoupanca(cliente, dta_abertura, limite);
            contasPoupancas.add(contaPoupanca);
            System.out.println("Conta criada com sucesso!");

        } else {
            System.out.println("Você selecionou uma opção de conta inválida!");
            System.out.println("Preencha os dados novamente...");
            operacoes();
        }

    }
}
