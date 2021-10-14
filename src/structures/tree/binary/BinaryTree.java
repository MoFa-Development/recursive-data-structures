package structures.tree.binary;

/**
 * Binary tree
 * @author Moritz Decker
 */
public abstract class BinaryTree<E> {

    protected BinaryTreeNode<E> root;

    protected BinaryTree() {
        this.root = null;
    }

    protected BinaryTree(E obj) {
        this.root = new BinaryTreeNode<E>(obj);
    }

    protected BinaryTree(BinaryTreeNode<E> root) {
        this.root = root;
    }
}
