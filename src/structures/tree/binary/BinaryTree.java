package structures.tree.binary;

public class BinaryTree<E> {
    protected BinaryNode<E> root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(E obj) {
        this.root = new BinaryNode<E>(obj);
    }

    public BinaryTree(BinaryNode<E> root) {
        this.root = root;
    }
}
