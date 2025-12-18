package app.service;
import app.model.Account;

public class AccountService {

    public void deposit(Account account, double value){
        if (value>0) {
            double newBalance = account.getBalance() + value;
            account.setBalance(newBalance);
            System.out.println("Deposito de R$: " + value + " realizado com sucesso");
        } else {
            System.out.println("Erro: Valor inválido");
        }
    }

    public void withdraw(Account account, double value){
        if(value>0 && account.getBalance()>=value) {
            double newBalance = account.getBalance() - value;
            account.setBalance(newBalance);
            System.out.println("Saque de R$: " + value + " realizado com sucesso");
        } else if(value<0){
            System.out.println("Erro: Valor inválido");
        } else {
            System.out.println("Saldo insuficente");
        }
    }

}
