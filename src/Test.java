import exceptions.ChainIndexOutOfBoundsException;
import structures.chain.updown.ChainUpDown;
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
    ChainUpDown<String> chainB;

    public static void main(String[] args) throws ChainIndexOutOfBoundsException {
        new Test();
    }
    
    public Test() throws ChainIndexOutOfBoundsException
    {
        chainA = new PackagedChainUpDown<>(2);

        chainA.add("Bremen");
        chainA.add("Hamburg");
        chainA.add(2, "Berlin");
        chainA.add("Köln");
        chainA.add("München");

        System.out.println(chainA.get(4));

        System.out.print(chainA);
        System.out.print(" - (");
        System.out.print(chainA.size());
        System.out.println(")");


        chainB = new ChainUpDown<>();

        chainB.add("B");
        chainB.add("C");
        chainB.add(0, "A");
        chainB.add("D");
        chainB.add(4, "E");

        System.out.print(chainB);
        System.out.print(" - (");
        System.out.print(chainB.size());
        System.out.println(")");

        System.out.println(">>> chainA.addAll(chainB); <<<");

        chainA.addAll(chainB);

        System.out.println(chainA);
    }
}
