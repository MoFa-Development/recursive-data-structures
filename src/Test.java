import exceptions.ChainIndexOutOfBoundsException;
import structures.chain.updown.ChainUpDown;

/**
 * Test class
 * 
 * @author Moritz Decker, Fabian Kessler
 * @version v1.0.0-2021-09-22
 */
public class Test
{
    ChainUpDown<String> chainA;
    ChainUpDown<String> chainB;

    public static void main(String[] args) throws ChainIndexOutOfBoundsException {
        new Test();
    }
    
    public Test() throws ChainIndexOutOfBoundsException
    {
        chainA = new ChainUpDown<>();

        chainA.add("Bremen");
        chainA.add("Hamburg");
        chainA.add("Berlin");
        chainA.add("Köln");
        chainA.add("München");


        System.out.print(chainA);
        System.out.print(" - (");
        System.out.print(chainA.size());
        System.out.println(")");


        chainB = new ChainUpDown<>();

        chainB.add("London");
        chainB.add("Manchester");
        chainB.add("Plymouth");


        chainA.addAll(chainB);


        System.out.print(chainA);
        System.out.print(" - (");
        System.out.print(chainA.size());
        System.out.println(")");
    }
}
