package services;

import services.exceptions.InsufficientFundsException;

public class CheckingAccount extends Account{


    public CheckingAccount(long accountNumber, double balance, Customer owner) {
        super(accountNumber, balance, owner);
    }

    @Override
    public void withDraw(double amount) throws InsufficientFundsException {

    }
}
