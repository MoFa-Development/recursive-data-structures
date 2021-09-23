import DataStructures.ChainDown.ChainDown;
import DataStructures.ChainUpDown.ChainUpDown;
import Exceptions.ChainIndexOutOfBoundsException;

/**
 * Test class
 * 
 * @author Moritz Decker 
 * @version v1.0.0-2021-09-22
 */
public class Test
{
    ChainUpDown<String> chain;
    
    public static void main(String[] args) throws ChainIndexOutOfBoundsException {
        new Test();
    }
    
    public Test() throws ChainIndexOutOfBoundsException
    {
        chain = new ChainUpDown<String>();

        chain.add("Bremen");
        chain.add("Hamburg");
        chain.add("Berlin");
        chain.add("Köln");
        chain.add("München");

        System.out.print("Length: ");
        System.out.println(chain.getLength());

        System.out.println(chain.toString());
        
        for(int i = 0; i < chain.getLength(); i++) {
            System.out.println(Integer.toString(i) + ": " + chain.get(i));
        }
    }
}
