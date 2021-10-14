package examples;

import java.util.Random;

import exceptions.ChainIndexOutOfBoundsException;
import structures.tree.binary.BinaryNode;
import structures.tree.binary.BinarySearchTree;

/**
 * Test class
 * 
 * @author Moritz Decker, Fabian Kessler
 * @version v1.0.0-2021-09-22
 */
public class Test
{
    public BinarySearchTree tree; 

    public static void main(String[] args) {
        new Test();
    }
    
    public Test()
    {
        Random rand = new Random();
        
        tree = new BinarySearchTree();

        tree.insert(500);

        int numToSearch = 500;

        for(int i = 0; i < 100; i++) {
            int num = rand.nextInt(1000);
            tree.insert(num);
            
            if(i == 99) {
                numToSearch = num;
            }
        }

        BinaryNode<Integer> node = tree.search(numToSearch);
        
        while(node != null) {
            System.out.println(node.getObj());
            node = node.getParent();
        }
    }
}
