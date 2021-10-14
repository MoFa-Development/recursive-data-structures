package structures.tree.binary;

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

    public BinaryNode<Integer> insert(int num) {
        if(root == null) {
            root = new BinaryNode<>(num);
            return root;
        }

        return recursiveInsert(num, root);
    }

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

    public BinaryNode<Integer> search(int num) {
        return recursiveSearch(num, root);
    }

    protected BinaryNode<Integer> recursiveSearch(int num, BinaryNode<Integer> node) {
        if(node == null) {
            return null;
        }
        
        if(node.getObj() == num) {
            return node;
        }

        if(node.getObj() > num) {
            return recursiveSearch(num, node.getChildLeft());
        } else {
            return recursiveSearch(num, node.getChildRight());
        }
    }
}