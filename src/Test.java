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
    PackagedChainUpDown<String> chainA;
    PackagedChainUpDown<String> chainB;

    public static void main(String[] args) throws ChainIndexOutOfBoundsException {
        new Test();
    }
    
    public Test() throws ChainIndexOutOfBoundsException
    {
        chainA = new PackagedChainUpDown<>(2);

        chainA.add("Bremen");
        chainA.add("Hamburg");
        chainA.add("Berlin");
        chainA.add("Köln");
        chainA.add("München");

        System.out.print(chainA);
        System.out.print(" - (");
        System.out.print(chainA.size());
        System.out.println(")");


        chainB = new PackagedChainUpDown<>(2);

        chainB.add("Bremen");
        chainB.add("Hamburg");
        chainB.add("Berlin");
        chainB.add("Köln");
        chainB.add("München");

        System.out.print(chainB);
        System.out.print(" - (");
        System.out.print(chainB.size());
        System.out.println(")");

        System.out.println(chainA.equals(chainB));

        System.out.println(chainA.subList(1, 3));
    }
}
