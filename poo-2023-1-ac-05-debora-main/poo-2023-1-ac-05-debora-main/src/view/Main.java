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
public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Cliente cliente1 = new PessoaFisica(1000,
                new Endereco("Rua A", 30, "Cajazeiras"),
                "111.111.111-01", "João",
                LocalDate.of(1990,1,1));

        ContaCorrente contaCorrente1 = new ContaCorrente(1, 11111, 0, LocalDate.now(), cliente1, 20);


        Cliente cliente2 = new PessoaFisica(1000, new Endereco("Rua B", 40, "Cajazeiras"),
                "222.222.222-02", "Maria", LocalDate.of(1999,5,12));

        ContaCorrente contaCorrente2 = new ContaCorrente(2,2,0,
                LocalDate.now(), cliente2,20);

        Cliente cliente3 = new PessoaJuridica(0, new Endereco("Rua c", 50,"Souza"),
                "33333333/03", "FastLanches");

        ContaPoupanca contaPoupanca1 = new ContaPoupanca(3,3,300, LocalDate.now(), cliente3,15);


//        //Para ajudar com as datas
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd/MM/yyyy");
        String string = "29/02/2000";
//        //Ler
        LocalDate localDate = LocalDate.parse(string, formatter);
//        //Escrever
        System.out.println(localDate.format(formatter));

        //public static void operacoes() {

            System.out.println("------------------------------------------------------");
            System.out.println("-------------Welcome to Agência Java---------------");
            System.out.println("------------------------------------------------------");
            System.out.println("***** Selecione o deseja realizar *****");
            System.out.println("------------------------------------------------------");
            System.out.println("|   Opção 1 - criar conta   |");
            System.out.println("|   Opção 2 - sacar     |");
            System.out.println("|   Opção 3 - depositar        |");
            System.out.println("|   Opção 4 - transferir        |");
            System.out.println("|   Opção 5 - Sair          |");

            int operacao = input.nextInt();

            switch (operacao) {
                case 1:

                    break;

                case 2:
                    System.out.println("INFORME O NUMERO DA CONTA:");
                    int numeroConta = input.nextInt();
                    
                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:
                    System.out.println("Até a próxima!");
                    System.exit(0); // para o sistema

                default:
                    System.out.println("Opção inválida!");
                   // operacoes();
                    break;


            }
        }

    }

