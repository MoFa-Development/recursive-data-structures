package structures.tree.binary;

/**
 * Binary search tree containing integer numbers
 * @author Moritz Decker
 */
public class IntBinarySearchTree extends BinarySearchTree<Integer> {

    @Override
    public boolean compare(Integer a, Integer b) {
        return a < b;
    }
}
