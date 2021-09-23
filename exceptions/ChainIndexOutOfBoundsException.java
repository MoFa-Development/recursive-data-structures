package exceptions;

public class ChainIndexOutOfBoundsException extends ChainException
{ 
    public ChainIndexOutOfBoundsException(String errorMessage)
    {
        super(errorMessage);
    }
}