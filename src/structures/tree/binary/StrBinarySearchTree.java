package structures.tree.binary;

public class StrBinarySearchTree extends BinarySearchTree<String> {

    @Override
    public boolean compare(String a, String b) {
        return a.compareTo(b) < 0;
    }
    
}
