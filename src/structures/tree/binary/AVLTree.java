package structures.tree.binary;

/**
 * Abstract binary search tree, implementing all operations, just needs a compare method to be defined.
 * @author Moritz Decker
 */
public abstract class AVLTree<E extends Comparable<E>> extends BinarySearchTree<E>
{
    protected AVLTree()
    {
        super();
    }

    protected AVLTree(E obj)
    {
        super(obj);
    }

    protected AVLTree(BinaryTreeNode<E> root)
    {
        super(root);
    }

    /**
     * Method to balance the whole tree to conform AVL spec
     */
    protected void balance()
    {
        //TODO implement
    }

    /**
     * recursive method to add an integer number in the tree so it stays searchable
     * @param obj number to insert
     * @param current current root node
     * @return tree node where the number was inserted
     */
    @Override
    public BinaryTreeNode<E> insert(E obj) {
        BinaryTreeNode<E> result = super.insert(obj);
        balance();
        return result;
    }

    /**
     * Remove node with provided number 
     * @param obj
     * @return removed node
     */
    @Override
    public BinaryTreeNode<E> remove(E obj) {
        BinaryTreeNode<E> result = super.remove(obj);
        balance();
        return result;
    }
}