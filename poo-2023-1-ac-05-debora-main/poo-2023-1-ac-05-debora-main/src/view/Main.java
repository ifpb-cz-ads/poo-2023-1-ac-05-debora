package view;
import model.*;
import model.Cliente;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.ContaCorrente;
import model.ContaPoupanca;
import model.PessoaFisica;
import model.PessoaJuridica;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ContaCorrente> contasCorrente = new ArrayList<ContaCorrente>();
        ArrayList<ContaPoupanca> contasPoupanca = new ArrayList<ContaPoupanca>();
        int opcaoConta;
        do {
            System.out.println("1- CRIAR CONTA-CORRENTE\n" +
                    "2- CRIAR CONTA-POUPANÇA\n" +
                    "0 - SAIR\n");
            opcaoConta = Integer.parseInt(scanner.nextLine());
            if (opcaoConta == 1) {
                Cliente cliente1 = new PessoaFisica(1000,
                        new Endereco("Rua A", 30, "Cajazeiras"),
                        "111.111.111-01", "João",
                        LocalDate.of(1990, 1, 1));
                ContaCorrente contaCorrente = new ContaCorrente(1, 11111, 0, LocalDate.now(), cliente1, 20);
                System.out.println("INFORME A AGÊNCIA:" + contaCorrente.getAgencia());
                System.out.println("\n INFORME O NUMERO DA CONTA:\n");
                contaCorrente.setNumero(Integer.parseInt(scanner.nextLine()));
                contasCorrente.add(contaCorrente);
            } else if (opcaoConta == 2) {
                Cliente cliente = new PessoaJuridica(0, new Endereco("Rua c", 50, "Souza"),
                        "33333333/03", "FastLanches");
                ContaPoupanca contaPoupanca = new ContaPoupanca(3, 3, 300, LocalDate.now(), cliente, 15);
                System.out.println("INFORME A AGÊNCIA: \n" + contaPoupanca.getAgencia());
                System.out.println("INFORME O NUMERO DA CONTA:\n");
                contaPoupanca.setNumero(Integer.parseInt(scanner.nextLine()));
                contasPoupanca.add(contaPoupanca);
            }
        } while (opcaoConta != 0);
        int opcao;
        do {
            int numeroConta;
            System.out.println("------------------------------------------------------");
            System.out.println("-------------Welcome to Agência Java---------------");
            System.out.println("------------------------------------------------------");
            System.out.println("***** Selecione o deseja realizar *****");
            System.out.println("------------------------------------------------------");
            System.out.println("|   Opção 1 - DEPOSITAR NA CORRENTE   |");
            System.out.println("|   Opção 2 - DEPOSITAR NA POUPANÇA     |");
            System.out.println("|   Opção 3 - SACAR NA CORRENTE        |");
            System.out.println("|   Opção 4 - SACAR NA POUPANÇA       |");
            System.out.println("|   Opção 5 - TRANSFERIR NA POUPANÇA       |");
            System.out.println("|   Opção 6 - TRANSFERIR NA CORRENTE       |");
            System.out.println("|   Opção 7 - Sair          |");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("EM QUAL CONTA DESEJA EFETUAR DEPÓSITO?\n");
                    numeroConta = Integer.parseInt(scanner.nextLine());
                    for (ContaCorrente contaCorrente : contasCorrente) {
                        if (numeroConta == contaCorrente.getNumero()) {
                            System.out.println("INFORME O VALOR QUE DESEJA DEPOSITAR:\n");
                            double valor = Double.parseDouble(scanner.nextLine());
                            contaCorrente.depositar(valor);
                            System.out.println("SUCESSO! Seu Saldo agora é:" + contaCorrente.getSaldo());
                        } else {
                            System.out.println("Ops! A conta não existe.\n");
                        }
                    }
                    break;

                case 2:
                    System.out.println("EM QUAL CONTA DESEJA EFETUAR DEPÓSITO?\n");
                    numeroConta = Integer.parseInt(scanner.nextLine());
                    for (ContaPoupanca contaPoupanca : contasPoupanca) {
                        if (numeroConta == contaPoupanca.getNumero()) {
                            System.out.println("INFORME O VALOR QUE DESEJA DEPOSITAR:\n");
                            double valor = Double.parseDouble(scanner.nextLine());
                            contaPoupanca.depositar(valor);
                            System.out.println("SUCESSO! Seu Saldo agora é:" + contaPoupanca.getSaldo());
                        } else {
                            System.out.println("Ops! A conta não existe.");
                        }
                    }
                    break;

                case 3:
                    System.out.println("QUAL CONTA IRÁ SACAR?\n");
                    numeroConta = Integer.parseInt(scanner.nextLine());
                    for (ContaCorrente contaCorrente : contasCorrente) {
                        if (numeroConta == contaCorrente.getNumero()) {
                            System.out.println("INFORME O VALOR DO SAQUE:\n");
                            double valor = Double.parseDouble(scanner.nextLine());
                            boolean sacado = contaCorrente.sacar(valor);
                            if (sacado) {
                                System.out.println("SUCESSO! Seu Saldo agora é:" + contaCorrente.getSaldo());
                            } else {
                                System.out.println("VOCÊ NÃO POSSUI SALDO SUFICIENTE!");
                            }
                        } else {
                            System.out.println("Ops! A conta não existe.");
                        }
                    }
                    break;

                case 4:
                    System.out.println("QUAL CONTA IRÁ SACAR?\n");
                    numeroConta = Integer.parseInt(scanner.nextLine());
                    for (ContaPoupanca contaPoupanca : contasPoupanca) {
                        if (numeroConta == contaPoupanca.getNumero()) {
                            System.out.println("QUAL O VALOR DO SAQUE:\n");
                            double valor = Double.parseDouble(scanner.nextLine());
                            boolean sacado = contaPoupanca.sacar(valor);
                            if (sacado) {
                                System.out.println("SUCESSO! SEU SALDO AGORA É:" + contaPoupanca.getSaldo());
                            } else {
                                System.out.println("VOCÊ NÃO POSSUI SALDO SUFICIENTE!");
                            }
                        } else {
                            System.out.println("OPS! A CONTA NÃO EXISTE.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("INFORME A CONTA QUE VAI TRANSFERIR:\n");
                    numeroConta = Integer.parseInt(scanner.nextLine());
                    for (ContaPoupanca contaPoupanca : contasPoupanca) {
                        if (numeroConta == contaPoupanca.getNumero()) {
                            System.out.println("INFORME PARA QUAL CONTA VAI TRANSFERIR:");
                            int numeroContaCorrente = Integer.parseInt(scanner.nextLine());
                            for (ContaCorrente contaCorrente : contasCorrente) {
                                if (numeroContaCorrente == contaCorrente.getNumero()) {
                                    System.out.println("VALOR:\n");
                                    double valor = Double.parseDouble(scanner.nextLine());
                                    boolean transferir = contaPoupanca.transferir(contaCorrente, valor);
                                    if (transferir) {
                                        System.out.println("SUCESSO! O SALDO DA CONTA É:" + contaPoupanca.getSaldo());
                                    } else {
                                        System.out.println("SUA CONTA ESTA COM SALDO INSUFICIENTE!");
                                    }
                                }
                            }
                        }
                    }
                    break;

                case 6:
                    System.out.println("INFORME A CONTA QUE VAI TRANSFERIR:\n");
                    numeroConta = Integer.parseInt(scanner.nextLine());
                    for (ContaCorrente contaCorrente : contasCorrente) {
                        if (numeroConta == contaCorrente.getNumero()) {
                            System.out.println("INFORME PARA QUAL CONTA VAI TRANSFERIR:");
                            int numeroContaPoupanca = Integer.parseInt(scanner.nextLine());
                            for (ContaPoupanca contaPoupanca : contasPoupanca) {
                                if (numeroContaPoupanca == contaPoupanca.getNumero()) {
                                    System.out.println("VALOR:\n");
                                    double valor = Double.parseDouble(scanner.nextLine());
                                    boolean transferido = contaCorrente.transferir(contaPoupanca, valor);
                                    if (transferido) {
                                        System.out.println("SUCESSO! O SALDO DA CONTA É:" + contaCorrente.getSaldo());
                                    } else {
                                        System.out.println("SUA CONTA ESTA COM SALDO INSUFICIENTE!");
                                    }
                                }
                            }
                        }
                    }
                    break;

                case 7:
                    System.out.println("Até a próxima!");
                    System.exit(0); // para o sistema

                default:
                    System.out.println("Opção inválida!");
                    // opçoes();
                    break;
                  }
            } while (opcao != 0);

        //        //Para ajudar com as datas
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd/MM/yyyy");
        String string = "29/02/2000";
//        //Ler
        LocalDate localDate = LocalDate.parse(string, formatter);
//        //Escrever
        System.out.println(localDate.format(formatter));


    }

}
