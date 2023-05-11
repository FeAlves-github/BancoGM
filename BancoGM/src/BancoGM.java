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
        System.out.println("|       6. Alterar limite de transação         |");
        System.out.println("|       7. Alterar limite de crédito           |");
        System.out.println("|       8. Sair                                |");

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
                System.out.println("----- Qual o tipo da conta do REMETENTE para a transferência? -----");
                System.out.println("1. Conta Comum");
                System.out.println("2. Conta Especial");
                System.out.println("3. Conta Poupança");
                Integer opContaRemetente = ler.nextInt();

                System.out.println("Número da conta do REMETENTE: ");
                int numeroContaRemetente = ler.nextInt();

                if (opContaRemetente == 1) {
                    ContaComum contaRemetente = encontrarContaComum(numeroContaRemetente);
                    transferirContaComum(contaRemetente);

                }
                if (opContaRemetente == 2){
                    ContaEspecial contaRemetente = encontrarContaEspecial(numeroContaRemetente);
                    transferirContaEspecial(contaRemetente);
                }
                if (opContaRemetente == 3){
                    ContaPoupanca contaRemetente = encontrarContaPoupanca(numeroContaRemetente);
                    transferirContaPoupanca(contaRemetente);
                }
                break;
            }
            case 6 -> {
                alterarLimiteTransacao();
                break;
            }
            case 7 -> {
                alterarLimiteCredito();
                break;
            }
            case 8 -> {
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
            ContaComum contaComum = new ContaComum(cliente, dta_abertura, limite, opConta);
            contasComum.add(contaComum);
            System.out.println("Conta criada com sucesso!");
            operacoes();

        } else if (opConta == 2){
            System.out.println("Limite de crédito:");
            Double limiteCredito = ler.nextDouble();
            ContaEspecial contaEspecial = new ContaEspecial(cliente, dta_abertura, limite, limiteCredito, opConta);
            contasEspeciais.add(contaEspecial);
            System.out.println("Conta criada com sucesso!");
            operacoes();

        } else if (opConta == 3){
            System.out.println("Digite o dia de hoje (0-31):");
            Integer diaHoje = ler.nextInt();
            ContaPoupanca contaPoupanca = new ContaPoupanca(cliente, dta_abertura, limite, diaHoje, opConta);
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

        if (opConta == 1) {
            ContaComum contaComum = encontrarContaComum(numeroConta);

            if (contaComum != null) {
                System.out.println("Qual valor deseja depositar? ");
                Double valorDeposito = ler.nextDouble();

                contaComum.depositar(valorDeposito);
            } else {
                System.out.println("--- Conta não encontrada ---");
            }
        }else if (opConta == 2) {
            ContaEspecial contaEspecial = encontrarContaEspecial(numeroConta);

            if (contaEspecial != null) {
                System.out.println("Qual valor deseja depositar? ");
                Double valorDeposito = ler.nextDouble();

                contaEspecial.depositar(valorDeposito);
            } else {
                System.out.println("--- Conta não encontrada ---");
            }
        } else if (opConta == 3) {
            ContaPoupanca contaPoupanca = encontrarContaPoupanca(numeroConta);

            if (contaPoupanca != null) {
                System.out.println("Qual valor deseja depositar? ");
                Double valorDeposito = ler.nextDouble();

                contaPoupanca.depositar(valorDeposito);
            } else {
                System.out.println("--- Conta não encontrada ---");
            }
        } else {
            System.out.println("--- Tipo de conta inválida ---");
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
            ContaEspecial contaEspecial = encontrarContaEspecial(numeroConta);

            if(contaEspecial != null) {
                System.out.println("Qual valor deseja sacar? ");
                Double valorSaque = ler.nextDouble();

                contaEspecial.sacarContaEspecial(valorSaque);
            }else {
                System.out.println("--- Conta não encontrada ---");
            }

        }if (opConta == 3){
            ContaPoupanca contaPoupanca = encontrarContaPoupanca(numeroConta);

            if(contaPoupanca != null) {
                System.out.println("Qual valor deseja sacar? ");
                Double valorSaque = ler.nextDouble();

                contaPoupanca.sacar(valorSaque);
            }else {
                System.out.println("--- Conta não encontrada ---");
            }
        }
        operacoes();
    }

    public static void transferirContaComum(ContaComum contaRemetente){

        System.out.println("----- Qual o tipo da conta do DESTINATÁRIO para a transferência? -----");
        System.out.println("1. Conta Comum");
        System.out.println("2. Conta Especial");
        System.out.println("3. Conta Poupança");
        Integer opContaDestinatario = ler.nextInt();

        System.out.println("Número da conta do DESTINATÁRIO: ");
        int numeroContaDestinatario = ler.nextInt();

        System.out.println("Valor da transferência: ");
        Double valor = ler.nextDouble();

        if (opContaDestinatario == 1) {
            ContaComum contaDestinatario = encontrarContaComum(numeroContaDestinatario);
            contaRemetente.transferir(contaDestinatario, valor);

        }
        else if (opContaDestinatario == 2){
            ContaEspecial contaDestinatario = encontrarContaEspecial(numeroContaDestinatario);
            contaRemetente.transferir(contaDestinatario, valor);
        }
        else if (opContaDestinatario == 3){
            ContaPoupanca contaDestinatario = encontrarContaPoupanca(numeroContaDestinatario);
            contaRemetente.transferir(contaDestinatario, valor);
        }
        else {
        System.out.println("--- Conta não encontrada ---");
        }
        operacoes();
    }

    public static void transferirContaEspecial(ContaEspecial contaRemetente){

        System.out.println("----- Qual o tipo da conta do DESTINATÁRIO para a transferência? -----");
        System.out.println("1. Conta Comum");
        System.out.println("2. Conta Especial");
        System.out.println("3. Conta Poupança");
        Integer opContaDestinatario = ler.nextInt();

        System.out.println("Número da conta do DESTINATÁRIO: ");
        int numeroContaDestinatario = ler.nextInt();

        System.out.println("Valor da transferência: ");
        Double valor = ler.nextDouble();

        if (opContaDestinatario == 1) {
            ContaComum contaDestinatario = encontrarContaComum(numeroContaDestinatario);
            contaRemetente.transferirContaEspecial(contaDestinatario, valor);

        }
        else if (opContaDestinatario == 2){
            ContaEspecial contaDestinatario = encontrarContaEspecial(numeroContaDestinatario);
            contaRemetente.transferir(contaDestinatario, valor);
        }
        else if (opContaDestinatario == 3){
            ContaPoupanca contaDestinatario = encontrarContaPoupanca(numeroContaDestinatario);
            contaRemetente.transferir(contaDestinatario, valor);
        }
        else {
        System.out.println("--- Conta não encontrada ---");
        }
        operacoes();
    }

    public static void transferirContaPoupanca(ContaPoupanca contaRemetente){

        System.out.println("----- Qual o tipo da conta do DESTINATÁRIO para a transferência? -----");
        System.out.println("1. Conta Comum");
        System.out.println("2. Conta Especial");
        System.out.println("3. Conta Poupança");
        Integer opContaDestinatario = ler.nextInt();

        System.out.println("Número da conta do DESTINATÁRIO: ");
        int numeroContaDestinatario = ler.nextInt();

        System.out.println("Valor da transferência: ");
        Double valor = ler.nextDouble();

        if (opContaDestinatario == 1) {
            ContaComum contaDestinatario = encontrarContaComum(numeroContaDestinatario);
            contaRemetente.transferir(contaDestinatario, valor);

        }
        else if (opContaDestinatario == 2){
            ContaEspecial contaDestinatario = encontrarContaEspecial(numeroContaDestinatario);
            contaRemetente.transferir(contaDestinatario, valor);
        }
        else if (opContaDestinatario == 3){
            ContaPoupanca contaDestinatario = encontrarContaPoupanca(numeroContaDestinatario);
            contaRemetente.transferir(contaDestinatario, valor);
        }
        else {
            System.out.println("--- Conta não encontrada ---");
        }
        operacoes();
    }

    private static void alterarLimiteCredito() {
        System.out.println("Número da conta ESPECIAL: ");
        int numeroConta = ler.nextInt();

        ContaEspecial contaEspecial = encontrarContaEspecial(numeroConta);

        if (contaEspecial != null) {
            System.out.println("Limite de crédito atual:" + contaEspecial.getLimite_credito());
            System.out.println("Qual o novo limite de crédito deseja definir? ");
            Double novoLimite = ler.nextDouble();

            contaEspecial.alterarLimiteCredito(contaEspecial, novoLimite);
        } else {
            System.out.println("--- Conta não encontrada ---");
        }
        operacoes();
    }

    private static void alterarLimiteTransacao() {
        System.out.println("----- Qual o tipo da conta deseja alterar limite de transação? -----");
        System.out.println("1. Conta Comum");
        System.out.println("2. Conta Especial");
        System.out.println("3. Conta Poupança");
        Integer opConta = ler.nextInt();

        System.out.println("Número da conta: ");
        int numeroConta = ler.nextInt();

        if (opConta == 1) {
            ContaComum contaComum = encontrarContaComum(numeroConta);

            if (contaComum != null) {
                System.out.println("Limite de crédito atual:" + contaComum.getLimite_valor_transacao());
                System.out.println("Qual o novo limite de transação deseja definir? ");
                Double novoLimite = ler.nextDouble();

                contaComum.alterarLimiteTransacao(contaComum, novoLimite);
            } else {
                System.out.println("--- Conta não encontrada ---");
            }
        }else if (opConta == 2) {
            ContaEspecial contaEspecial = encontrarContaEspecial(numeroConta);

            if (contaEspecial != null) {
                System.out.println("Limite de crédito atual:" + contaEspecial.getLimite_valor_transacao());
                System.out.println("Qual o novo limite de transação deseja definir? ");
                Double novoLimite = ler.nextDouble();

                contaEspecial.alterarLimiteTransacao(contaEspecial, novoLimite);
            } else {
                System.out.println("--- Conta não encontrada ---");
            }
        } else if (opConta == 3) {
            ContaPoupanca contaPoupanca = encontrarContaPoupanca(numeroConta);

            if (contaPoupanca != null) {
                System.out.println("Limite de crédito atual:" + contaPoupanca.getLimite_valor_transacao());
                System.out.println("Qual o novo limite de transação deseja definir? ");
                Double novoLimite = ler.nextDouble();

                contaPoupanca.alterarLimiteTransacao(contaPoupanca, novoLimite);
            } else {
                System.out.println("--- Conta não encontrada ---");
            }
        } else {
            System.out.println("--- Tipo de conta inválida ---");
        }
        operacoes();
    }

    public static void listarContas() {
        if(contasComum.size() > 0) {
            for(ContaComum contaComum: contasComum) {
                System.out.println(contaComum);
            }
        }
        if(contasEspeciais.size() > 0) {
            for(ContaEspecial contaEspecial: contasEspeciais) {
                System.out.println(contaEspecial);
            }
        }
        if(contasPoupancas.size() > 0) {
            for(ContaPoupanca contaPoupanca: contasPoupancas) {
                System.out.println(contaPoupanca);
            }
        }
        if (contasComum.size() == 0 && contasEspeciais.size() == 0 && contasPoupancas.size() == 0){
            System.out.println("--- Não há contas cadastradas ---");
        }

        operacoes();
    }


}
