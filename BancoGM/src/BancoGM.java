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
            }
            case 2 -> {
                listarContas();
                break;
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
            operacoes();

        } if (opConta == 2){
            ContaEspecial contaEspecial = new ContaEspecial(cliente, dta_abertura, limite);
            contasEspeciais.add(contaEspecial);
            System.out.println("Conta criada com sucesso!");
            operacoes();

        } if (opConta == 3){
            ContaPoupanca contaPoupanca = new ContaPoupanca(cliente, dta_abertura, limite);
            contasPoupancas.add(contaPoupanca);
            System.out.println("Conta criada com sucesso!");
            operacoes();

        } else {
            System.out.println("Você selecionou uma opção de conta inválida!");
            System.out.println("Preencha os dados novamente...");
            operacoes();
        }

    }
    private static ContaComum encontrarContaComum(int numeroConta) {
        ContaComum contaComum = null;
        if(contasComum.size() > 0) {
            for(ContaComum contaComumm : contasComum) { //contaComumm- contador do for
                if(contaComumm.getNumeroConta() == numeroConta) {
                    contaComum = contaComumm;
                }
            }
        }
        return contaComum;
    }

    private static ContaEspecial encontrarContaEspecial(int numeroConta) {
        ContaEspecial contaEspecial = null;
        if(contasEspeciais.size() > 0) {
            for(ContaEspecial contaEspeciall : contasEspeciais) { //contaEspeciall- contador do for
                if(contaEspeciall.getNumeroConta() == numeroConta) {
                    contaEspecial = contaEspeciall;
                }
            }
        }
        return contaEspecial;
    }

    private static ContaPoupanca encontrarContaPoupanca(int numeroConta) {
        ContaPoupanca contaPoupanca = null;
        if(contasPoupancas.size() > 0) {
            for(ContaPoupanca contaPoupancaa : contasPoupancas) { //contaPoupancaa- contador do for
                if(contaPoupancaa.getNumeroConta() == numeroConta) {
                    contaPoupanca = contaPoupancaa;
                }
            }
        }
        return contaPoupanca;
    }

    public static void depositar() {
        System.out.println("----- Qual o tipo da conta para depósito? -----");
        System.out.println("1. Conta Comum");
        System.out.println("2. Conta Especial");
        System.out.println("3. Conta Poupança");
        Integer opConta = ler.nextInt();

        System.out.println("Número da conta: ");
        int numeroConta = ler.nextInt();

        if (opConta == 1){
            ContaComum contaComum = encontrarContaComum(numeroConta);

            if(contaComum != null) {
                System.out.println("Qual valor deseja depositar? ");
                Double valorDeposito = ler.nextDouble();

                contaComum.depositar(valorDeposito);
            }else {
                System.out.println("--- Conta não encontrada ---");
            }

        }if (opConta == 2){
            ContaPoupanca contaPoupanca = encontrarContaPoupanca(numeroConta);

            if(contaPoupanca != null) {
                System.out.println("Qual valor deseja depositar? ");
                Double valorDeposito = ler.nextDouble();

                contaPoupanca.depositar(valorDeposito);
            }else {
                System.out.println("--- Conta não encontrada ---");
            }

        }if (opConta == 3){
            ContaEspecial contaEspecial = encontrarContaEspecial(numeroConta);

            if(contaEspecial != null) {
                System.out.println("Qual valor deseja depositar? ");
                Double valorDeposito = ler.nextDouble();

                contaEspecial.depositar(valorDeposito);
            }else {
                System.out.println("--- Conta não encontrada ---");
            }
        }
        operacoes();
    }

    public static void sacar() {
        System.out.println("----- Qual o tipo da conta para saque? -----");
        System.out.println("1. Conta Comum");
        System.out.println("2. Conta Especial");
        System.out.println("3. Conta Poupança");
        Integer opConta = ler.nextInt();

        System.out.println("Número da conta: ");
        int numeroConta = ler.nextInt();

        if (opConta == 1){
            ContaComum contaComum = encontrarContaComum(numeroConta);

            if(contaComum != null) {
                System.out.println("Qual valor deseja sacar? ");
                Double valorSaque = ler.nextDouble();

                contaComum.sacar(valorSaque);
            }else {
                System.out.println("--- Conta não encontrada ---");
            }

        }if (opConta == 2){
            ContaPoupanca contaPoupanca = encontrarContaPoupanca(numeroConta);

            if(contaPoupanca != null) {
                System.out.println("Qual valor deseja sacar? ");
                Double valorSaque = ler.nextDouble();

                contaPoupanca.sacar(valorSaque);
            }else {
                System.out.println("--- Conta não encontrada ---");
            }

        }if (opConta == 3){
            ContaEspecial contaEspecial = encontrarContaEspecial(numeroConta);

            if(contaEspecial != null) {
                System.out.println("Qual valor deseja sacar? ");
                Double valorSaque = ler.nextDouble();

                contaEspecial.sacar(valorSaque);
            }else {
                System.out.println("--- Conta não encontrada ---");
            }
        }
        operacoes();
    }

    public static void transferir() {
        System.out.println("----- Qual o tipo da conta do REMETENTE para a transferência? -----");
        System.out.println("1. Conta Comum");
        System.out.println("2. Conta Especial");
        System.out.println("3. Conta Poupança");
        Integer opContaRemetente = ler.nextInt();

        System.out.println("Número da conta do REMETENTE: ");
        int numeroContaRemetente = ler.nextInt();

        if (opContaRemetente == 1) {
            ContaComum contaRemetente = encontrarContaComum(numeroContaRemetente);

            // oq eu colocaria:
            // if(contaComum == null){
            //System.out.println("--- Conta não encontrada ---");
            //}
            //if(contaComum != null) {

            //}else {
                //System.out.println("--- Conta não encontrada ---");
            //}
        }
        if (opContaRemetente == 2){
            ContaPoupanca contaRemetente = encontrarContaPoupanca(numeroContaRemetente);

            //if(contaPoupanca != null) {

           // }else {
               // System.out.println("--- Conta não encontrada ---");
            //}
        }
        if (opContaRemetente == 3){
            ContaEspecial contaRemetente = encontrarContaEspecial(numeroContaRemetente);

           // if(contaEspecial != null) {

            //}else {
                //System.out.println("--- Conta não encontrada ---");
            //}
       }

        if(contaRemetente != null) {
            System.out.println("----- Qual o tipo da conta do DESTINATÁRIO para a transferência? -----");
            System.out.println("1. Conta Comum");
            System.out.println("2. Conta Especial");
            System.out.println("3. Conta Poupança");
            Integer opContaDestinatario = ler.nextInt();

            System.out.println("Número da conta do DESTINATÁRIO: ");
            int numeroContaDestinatario = ler.nextInt();

            //Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if (opContaRemetente == 1) {
                ContaComum contaDestinatario = encontrarContaComum(numeroContaDestinatario);

            } if (opContaRemetente == 2) {
                ContaEspecial contaDestinatario = encontrarContaEspecial(numeroContaDestinatario);

            } if (opContaRemetente == 3) {
                ContaPoupanca contaDestinatario = encontrarContaPoupanca(numeroContaDestinatario);

            }

            if(contaDestinatario != null) {
                System.out.println("Valor da transferência: ");
                Double valor = ler.nextDouble();

                contaRemetente.transferencia(contaDestinatario, valor);

            }else {
                System.out.println("--- A conta para depósito não foi encontrada ---");
            }

        }else {
            System.out.println("--- Conta para transferência não encontrada ---");
        }
        operacoes();
    }

    public static void listarContas() {
        if(contasComum.size() > 0) {
            for(ContaComum contaComum: contasComum) {
                System.out.println(contaComum);
            }
        }if(contasEspeciais.size() > 0) {
            for(ContaEspecial contaEspecial: contasEspeciais) {
                System.out.println(contaEspecial);
            }
        }if(contasPoupancas.size() > 0) {
            for(ContaPoupanca contaPoupanca: contasPoupancas) {
                System.out.println(contaPoupanca);
            }
        }else {
            System.out.println("--- Não há contas cadastradas ---");
        }

        operacoes();
    }


}
