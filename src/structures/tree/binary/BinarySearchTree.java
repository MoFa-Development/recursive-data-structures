package structures.tree.binary;

/**
 * Binary search tree containing integer numbers
 * @author Moritz Decker
 */
public class BinarySearchTree extends BinaryTree<Integer> {
    
    public BinarySearchTree() {
        super();
    }

    public BinarySearchTree(int obj) {
        super(obj);
    }

    public BinarySearchTree(BinaryNode<Integer> root) {
        super(root);
    }

    /**
     * Insert an integer number into the tree so it stays searchable
     * @param num number to insert
     * @return tree node where the number was inserted
     */
    public BinaryNode<Integer> insert(int num) {
        if(root == null) {
            root = new BinaryNode<>(num);
            return root;
        }

        return recursiveInsert(num, root);
    }

    /**
     * recursive function to add an integer number in the tree so it stays searchable
     * @param num number to insert
     * @param current current root node
     * @return tree node where the number was inserted
     */
    protected BinaryNode<Integer> recursiveInsert(int num, BinaryNode<Integer> current) {
        if(current.getObj() > num) {
            if(current.getChildLeft() == null) {
                BinaryNode<Integer> node = new BinaryNode<>(num);
                current.setChildLeft(node);
                return node;
            } else {
                return recursiveInsert(num, current.getChildLeft());
            }
        } else {
            if(current.getChildRight() == null) {
                BinaryNode<Integer> node = new BinaryNode<>(num);
                current.setChildRight(node);
                return node;
            } else {
                return recursiveInsert(num, current.getChildRight());
            }
        }
    }

    /**
     * public wrapper for the binary search
     * @param num number to search
     * @return tree node containing the searched number or null if number not in tree
     */
    public BinaryNode<Integer> search(int num) {
        return recursiveSearch(num, root);
    }

    /**
     * recursive implementation of the binary search
     * @param num number to search
     * @param current current node
     * @return tree node containing the searched number or null if number not in tree
     */
    protected BinaryNode<Integer> recursiveSearch(int num, BinaryNode<Integer> current) {
        if(current == null) {
            return null;
        }
        
        if(current.getObj() == num) {
            return current;
        }

        if(current.getObj() > num) {
            return recursiveSearch(num, current.getChildLeft());
        } else {
            return recursiveSearch(num, current.getChildRight());
        }
    }
}