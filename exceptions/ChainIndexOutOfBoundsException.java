package exceptions;

/**
 * Index out of bounds exception
 * 
 * @author Fabian Kessler 
 * @version v1.0.1-2021-09-23
 */
public class ChainIndexOutOfBoundsException extends ChainException
{ 
    public ChainIndexOutOfBoundsException(String errorMessage)
    {
        super(errorMessage);
    }
}