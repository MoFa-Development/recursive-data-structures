import exceptions.ChainIndexOutOfBoundsException;
import structures.chain.down.ChainDown;
import structures.chain.updown.ChainUpDown;
import structures.chain.updown.packaged.PackagedChainUpDown;
import structures.chain.util.ChainDownIterator;

/**
 * Test class
 * 
 * @author Moritz Decker, Fabian Kessler
 * @version v1.0.0-2021-09-22
 */
public class Test
{
    PackagedChainUpDown<String> chainA;
    ChainDown<String> chainB;

    public static void main(String[] args) throws ChainIndexOutOfBoundsException {
        new Test();
    }
    
    public Test() throws ChainIndexOutOfBoundsException
    {
        chainA = new PackagedChainUpDown<>(2);

        String[] arr = {"A", "B", "C", "D", "E"};
        chainA.addAll(arr);

        System.out.print(chainA);
        System.out.print(" - (");
        System.out.print(chainA.size());
        System.out.println(")");
    }
}
