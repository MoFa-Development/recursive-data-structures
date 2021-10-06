package examples;
import java.util.Arrays;
import java.util.List;

import exceptions.ChainIndexOutOfBoundsException;
import structures.chain.down.ChainDown;
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
    ChainDown<String> chainB;

    public static void main(String[] args) throws ChainIndexOutOfBoundsException {
        new Test();
    }
    
    public Test() throws ChainIndexOutOfBoundsException
    {
        chainA = new PackagedChainUpDown<String>(2);

        String[] arr = new String[9999];

        for(int i=0;i<arr.length;i++)
        {
            arr[i] = Integer.toString(i);
        }

        chainA.addAll(arr);Arrays.asList(arr);

        List<String> arrayListA = (List<String>) Arrays.asList(arr);

        long startTime = System.nanoTime();
        System.out.println(arrayListA.get(5000));
        System.out.println("Time List: " + String.valueOf(System.nanoTime() - startTime));

        startTime = System.nanoTime();
        System.out.println(chainA.get(5000));
        System.out.println("Time ChainedList: " + String.valueOf(System.nanoTime() - startTime));

    }
}
