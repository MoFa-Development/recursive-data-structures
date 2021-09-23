package exceptions;

public class ChainException extends Exception
{ 
    public ChainException(String errorMessage)
    {
        super(errorMessage);
    }
}