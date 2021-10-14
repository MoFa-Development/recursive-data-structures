package structures.tree.binary;

/**
 * Binary tree 
 * @author Moritz Decker
 */
public class BinaryTree<E> {
    protected BinaryTreeNode<E> root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(E obj) {
        this.root = new BinaryTreeNode<E>(obj);
    }

    public BinaryTree(BinaryTreeNode<E> root) {
        this.root = root;
    }
}
