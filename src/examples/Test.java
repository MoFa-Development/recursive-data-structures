package examples;

import java.util.Random;

import structures.tree.binary.BinarySearchTree;
import structures.tree.binary.BinaryTreeNode;

/**
 * Test class
 * 
 * @author Moritz Decker, Fabian Kessler
 * @version v1.0.0-2021-09-22
 */
public class Test
{
    public BinarySearchTree<Integer> tree; 

    public static void main(String[] args) {
        new Test();
    }
    
    public Test()
    {
        Random rand = new Random();
        
        tree = new BinarySearchTree<>();

        tree.insert(500);

        int numToSearch = 500;
        int numToRemove = 0;

        for(int i = 0; i < 100; i++) {
            int num = rand.nextInt(1000);
            
            if(i == 50) {
                numToRemove = num;
            }

            if(i == 99) {
                numToSearch = num;
            }

            tree.insert(num);
        }

        tree.remove(numToRemove);

        //TODO ඞ - sometimes node is null, I just can't figure out why.
        BinaryTreeNode<Integer> node = tree.search(numToSearch);

        if(node == null) {
            System.out.println("ඞ");
        }

        tree.printInOrder();
    }
}
