package services;

import services.exceptions.InsufficientFundsException;
import services.exceptions.InvalidAmountException;

public class SavingAccount extends Account{

    public SavingAccount(long accountNumber, double balance, Customer owner) {
        super(accountNumber, balance, owner);
    }

    @Override
    public void withDraw(double amount) throws InsufficientFundsException {
        if(amount > this.balance)
        {
            throw new InsufficientFundsException("Invalid amount bigger than the available balance");
        }
        else {
            this.balance -= amount;
        }
    }
}
