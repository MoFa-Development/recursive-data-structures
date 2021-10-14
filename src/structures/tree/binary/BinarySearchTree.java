package structures.tree.binary;

/**
 * Binary search tree containing integer numbers
 * @author Moritz Decker
 */
public class BinarySearchTree extends BinaryTree<Integer> {
    
    protected boolean removeInOrder = true;

    public BinarySearchTree() {
        super();
    }

    public BinarySearchTree(int obj) {
        super(obj);
    }

    public BinarySearchTree(BinaryTreeNode<Integer> root) {
        super(root);
    }

    /**
     * Insert an integer number into the tree so it stays searchable
     * @param num number to insert
     * @return tree node where the number was inserted
     */
    public BinaryTreeNode<Integer> insert(int num) {
        if(root == null) {
            root = new BinaryTreeNode<>(num);
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
    protected BinaryTreeNode<Integer> recursiveInsert(int num, BinaryTreeNode<Integer> current) {
        if(current.getObj() > num) {
            if(current.getChildLeft() == null) {
                BinaryTreeNode<Integer> node = new BinaryTreeNode<>(num);
                current.setChildLeft(node);
                return node;
            } else {
                return recursiveInsert(num, current.getChildLeft());
            }
        } else {
            if(current.getChildRight() == null) {
                BinaryTreeNode<Integer> node = new BinaryTreeNode<>(num);
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
    public BinaryTreeNode<Integer> search(int num) {
        return recursiveSearch(num, root);
    }

    /**
     * recursive implementation of the binary search
     * @param num number to search
     * @param current current node
     * @return tree node containing the searched number or null if number not in tree
     */
    protected BinaryTreeNode<Integer> recursiveSearch(int num, BinaryTreeNode<Integer> current) {
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

    /**
     * Remove node with provided number 
     * @param num
     * @return removed node
     */
    public BinaryTreeNode<Integer> remove(int num) {
        BinaryTreeNode<Integer> node = search(num);

        if(node != null) {
            BinaryTreeNode<Integer> parent = node.getParent();
            BinaryTreeNode<Integer> childLeft = node.getChildLeft();
            BinaryTreeNode<Integer> childRight = node.getChildRight();

            BinaryTreeNode<Integer> successor = null;

            boolean isLeftChild = parent == null || node.getObj() < parent.getObj();

            if(childLeft == null && childRight != null) {
                successor = childRight;
            } else if(childRight == null) {
                successor = childLeft;
            } else {
                if(removeInOrder) {
                    successor = childRight;
                    childRight.setChildLeft(childLeft);
                } else {
                    successor = childLeft;
                    childLeft.setChildRight(childRight);
                }
                removeInOrder = !removeInOrder;
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
}