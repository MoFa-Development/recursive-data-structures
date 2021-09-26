import exceptions.ChainIndexOutOfBoundsException;
import structures.chain.updown.packaged.PackagedChainUpDown;

/**
 * Test class
 * 
 * @author Moritz Decker, Fabian Kessler
 * @version v1.0.0-2021-09-22
 */
public class Test
{
    PackagedChainUpDown<String> chain;

    public static void main(String[] args) throws ChainIndexOutOfBoundsException {
        new Test();
    }
    
    public Test() throws ChainIndexOutOfBoundsException
    {
        chain = new PackagedChainUpDown<>(2);

        chain.add("Bremen");
        chain.add("Hamburg");
        chain.add(2, "Berlin");
        chain.add("Köln");
        chain.add("München");

        System.out.println(chain.get(4));

        System.out.print(chain);
        System.out.print(" - (");
        System.out.print(chain.size());
        System.out.println(")");
    }
}
