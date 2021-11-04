package structures.tree.binary;

/**
 * Binary tree
 * @author Moritz Decker
 */
public class BinaryTree<E>
{

    protected BinaryTreeNode<E> root;

    public void printInOrder()
    {
        printInOrder(root);
    }

    public void printInOrder(BinaryTreeNode<E> node)
    {
        if(node.getChildLeft() != null) {
            printInOrder(node.getChildLeft());
        }

        System.out.println(node.getObj());

        if(node.getChildRight() != null) {
            printInOrder(node.getChildRight());
        }
    }

    public void printPreOrder() 
    {
        printPreOrder(root);
    }

    public void printPreOrder(BinaryTreeNode<E> node)
    {
        System.out.println(node.getObj());
        
        if(node.getChildLeft() != null) {
            printPreOrder(node.getChildLeft());
        }
        
        if(node.getChildRight() != null) {
            printPreOrder(node.getChildRight());
        }
    }

    public void printPostOrder() {
        printPostOrder(root);
    }

    public void printPostOrder(BinaryTreeNode<E> node) {
        if(node.getChildLeft() != null) {
            printPostOrder(node.getChildLeft());
        }
        
        if(node.getChildRight() != null) {
            printPostOrder(node.getChildRight());
        }

        System.out.println(node.getObj());
    }

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
