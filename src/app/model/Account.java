package app.model;

public class Account {
    private String holder;
    private double balance;

    public Account(String holder) {
        this.holder = holder;
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getHolder(){
        return holder;
    }

}


