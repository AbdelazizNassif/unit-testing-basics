package services;

import services.exceptions.InsufficientFundsException;
import services.exceptions.InvalidAmountException;

public abstract class Account {
    protected long accountNumber;
    protected double balance;
    protected Customer owner;

    public Account(long accountNumber, double balance, Customer owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Customer getOwner() {
        return owner;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("invalid amount");
        } else {
            this.balance += amount;
        }
    }
    public abstract void withDraw(double amount) throws InsufficientFundsException;
}
