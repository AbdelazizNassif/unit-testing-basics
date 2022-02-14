package services.exceptions;

public class InvalidAmountException extends Exception{
    public InvalidAmountException(String invalidAmountMessage)
    {
        super(invalidAmountMessage);
    }
}
