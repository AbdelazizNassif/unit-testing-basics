package services.exceptions;

public class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String insufficientFundsMessage)
    {
        super(insufficientFundsMessage);
    }
}
