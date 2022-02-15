package services;

import services.exceptions.InsufficientFundsException;

public class CheckingAccount extends Account{

    private double minBalance;
    private double overdraftLimit;
    private double overdraftFee;
    private double serviceFee;
    private boolean isOverDrawn;
    private boolean droppedBelowMinBalance;
    private boolean notificationsEnabled;
    private Notification notificationService;

    public CheckingAccount( Customer owner, double balance, long accountNumber ) {
        super(accountNumber, balance, owner);this.minBalance=1500.0;
        this.overdraftLimit=0.0;
        this.overdraftFee=30.0;
        this.serviceFee=12.0;
        this.isOverDrawn=false;
        this.droppedBelowMinBalance =false;
        this.notificationsEnabled=true;
        notificationService = new EmailService();
    }

    @Override
    public void withDraw(double amount) throws InsufficientFundsException {
        if(amount <= this.balance+overdraftLimit) {
            this.balance = this.balance - amount;
            updateAccountStatus();
            if (isOverDrawn) {
                this.balance = this.balance - overdraftFee;
            }
        }
        else throw new InsufficientFundsException("insufficint amount to withdraw");
    }

    public void processCheck(Check checkToProcess)
    {
        try {
            withDraw(checkToProcess.getAmount());
            if (notificationsEnabled) {
//                notificationService.notify("Processed Check #" + checkToProcess.getCheckNumber()
//                        + " in the amount of $" + checkToProcess.getAmount() + ".", owner.getEmail());
                notificationService.notify("Processed Check #" ,"abdz@email.com");

            }
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
        }
    }
    private void updateAccountStatus()
    {
        this.isOverDrawn = this.balance < 0;
        if (this.balance < minBalance) { droppedBelowMinBalance = true; }
    }

}
