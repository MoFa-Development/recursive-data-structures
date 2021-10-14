package structures.tree.binary;

/**
 * Node of a binary tree, containing any object of generic type E
 * @author Moritz Decker
 */
public class BinaryTreeNode<E> {
    protected BinaryTreeNode<E> parent;
    protected BinaryTreeNode<E> childLeft;
    protected BinaryTreeNode<E> childRight;
    
    protected E obj;

    public BinaryTreeNode(E obj) {
        this.obj = obj;
    }

    public BinaryTreeNode<E> getParent() {
        return parent;
    }

    public BinaryTreeNode<E> getChildLeft() {
        return childLeft;
    }

    public BinaryTreeNode<E> getChildRight() {
        return childRight;
    }

    public E getObj() {
        return obj;
    }

    public void setObj(E obj) {
        this.obj = obj;
    }

    public void setChildLeft(BinaryTreeNode<E> childLeft) {
        this.childLeft = childLeft;
        this.childLeft.setParent(this);
    }

    public void setChildRight(BinaryTreeNode<E> childRight) {
        this.childRight = childRight;
        this.childRight.setParent(this);
    }

    public void setParent(BinaryTreeNode<E> parent) {
        this.parent = parent;
    }
}