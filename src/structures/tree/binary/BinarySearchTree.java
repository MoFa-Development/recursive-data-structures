package structures.tree.binary;

/**
 * Abstract binary search tree, implementing all operations, just needs a compare method to be defined.
 * @author Moritz Decker
 */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {
    
    protected boolean nextRemoveInOrder = true;

    public BinarySearchTree() {
        super();
    }

    public BinarySearchTree(E obj) {
        super(obj);
    }

    public BinarySearchTree(BinaryTreeNode<E> root) {
        super(root);
    }

    /**
     * Insert an integer number into the tree so it stays searchable
     * @param obj number to insert
     * @return tree node where the number was inserted
     */
    public BinaryTreeNode<E> insert(E obj) {
        if(root == null) {
            root = new BinaryTreeNode<E>(obj);
            return root;
        }

        return recursiveInsert(obj, root);
    }

    /**
     * recursive function to add an integer number in the tree so it stays searchable
     * @param obj number to insert
     * @param current current root node
     * @return tree node where the number was inserted
     */
    protected BinaryTreeNode<E> recursiveInsert(E obj, BinaryTreeNode<E> current) {
        if(compare(obj, current.getObj())) {
            if(current.getChildLeft() == null) {
                BinaryTreeNode<E> node = new BinaryTreeNode<>(obj);
                current.setChildLeft(node);

                // System.out.print(current.getObj());
                // System.out.print(" --L--> ");
                // System.out.println(node.getObj());

                return node;
            } else {
                return recursiveInsert(obj, current.getChildLeft());
            }
        } else {
            if(current.getChildRight() == null) {
                BinaryTreeNode<E> node = new BinaryTreeNode<>(obj);
                current.setChildRight(node);
                
                // System.out.print(current.getObj());
                // System.out.print(" --R--> ");
                // System.out.println(node.getObj());
                
                return node;
            } else {
                return recursiveInsert(obj, current.getChildRight());
            }
        }
    }

    /**
     * public wrapper for the binary search
     * @param obj number to search
     * @return tree node containing the searched number or null if number not in tree
     */
    public BinaryTreeNode<E> search(E obj) {
        BinaryTreeNode<E> result = recursiveSearch(obj, root);
        
        return result;
    }

    /**
     * recursive implementation of the binary search
     * @param obj number to search
     * @param current current node
     * @return tree node containing the searched number or null if number not in tree
     */
    protected BinaryTreeNode<E> recursiveSearch(E obj, BinaryTreeNode<E> current) {
        if(current == null) {
            return null;
        }
        
        if(current.getObj().equals(obj)) {
            return current;
        }

        if(compare(obj, current.getObj())) {
            return recursiveSearch(obj, current.getChildLeft());
        } else {
            return recursiveSearch(obj, current.getChildRight());
        }
    }

    /**
     * Remove node with provided number 
     * @param obj
     * @return removed node
     */
    public BinaryTreeNode<E> remove(E obj) {
        BinaryTreeNode<E> node = search(obj);
        
        // System.out.print("remove: ");
        // System.out.println(obj);

        return remove(node);
    }

    /**
     * remove node from tree and keep children in the tree so it keeps searchable
     * @param node
     * @return
     */
    public BinaryTreeNode<E> remove(BinaryTreeNode<E> node) {
        if(node != null) {
            BinaryTreeNode<E> parent = node.getParent();
            BinaryTreeNode<E> childLeft = node.getChildLeft();
            BinaryTreeNode<E> childRight = node.getChildRight();

            BinaryTreeNode<E> successor = null;

            boolean isLeftChild = parent == null || compare(node.getObj(), parent.getObj());

            if(childLeft == null && childRight != null) {
                successor = childRight;
            } else if(childRight == null) {
                successor = childLeft;
            } else {
                if(nextRemoveInOrder) {
                    successor = childRight;
                    childRight.setChildLeft(childLeft);
                } else {
                    successor = childLeft;
                    childLeft.setChildRight(childRight);
                }
                nextRemoveInOrder = !nextRemoveInOrder;
            }

            if(successor != null) {
                successor.setParent(parent);
            }

            if(parent == null) {
                 root = successor;
            } else if(isLeftChild) {
                parent.setChildLeft(successor);
            } else {
                parent.setChildRight(successor);
            }
        }

        return node;
    }

    /**
     * compare order of two elements
     * @param a
     * @param b
     * @return {boolean} is a predecessor of b?
     */
    public boolean compare(E a, E b) {
        return a.compareTo(b) < 0;
    }
}