package app;

import app.service.AccountService;
import app.model.Account;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountService service = new AccountService();
        Account myAccount = null;

        while (true) {
            if(myAccount == null) {
            System.out.println("== Bem-vindo ao Consolbank! ==");
            System.out.println("(1) Criar uma conta.");
            System.out.println("(0) Sair.");
            System.out.print("Opção: ");

            int option = sc.nextInt();
            sc.nextLine();

            if(option == 0) {
                System.out.println("Saindo... ");
                break;
            } else if(option==1) {
                System.out.print("Digite seu nome: ");
                String holder = sc.nextLine();

                myAccount = new Account(holder);

                System.out.print("Gostaria de fazer um deposito inicial? (S/N)");
                String resp = sc.nextLine();
                if (resp.equalsIgnoreCase("S")) {
                    System.out.print("Valor inicial: R$ ");
                    double initialDeposit = sc.nextDouble();
                    service.deposit(myAccount, initialDeposit);
                }
                System.out.println("\nConta criada com sucesso!! ");
            }
            } else {
                System.out.println("\n== Menu Conta: " + myAccount.getHolder() + " ==");
                System.out.println("(1) - Depositar");
                System.out.println("(2) - Sacar");
                System.out.println("(3) - Ver saldo");
                System.out.println("(4) - Sair da Conta (Logout)");
                System.out.println("(0) - Sair");
                System.out.print("Opção: ");

                int option2 = sc.nextInt();

                if(option2 == 0) break;
                if(option2 == 4) {
                    myAccount = null;
                    System.out.println("Logout realizado");
                    continue;
                }

                switch(option2) {
                    case 1:
                        System.out.print("Valor para deposito: R$ ");
                        double valDep = sc.nextDouble();
                        service.deposit(myAccount, valDep);
                        break;

                    case 2:
                        System.out.print("Valor para saque: R$ ");
                        double valWith = sc.nextDouble();
                        service.withdraw(myAccount,valWith);
                        break;

                    case 3:
                        System.out.println("Saldo atual: R$ " + myAccount.getBalance());
                        break;

                    default:
                        System.out.print("Opção inválida");
                }
            }
        }
        sc.close();
    }
}