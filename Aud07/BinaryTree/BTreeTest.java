package Aud07.BinaryTree;

public class BTreeTest {

    public static void main(String[] args) {
        BNode<Character> a, b, c;
        BTree<Character> tree = new BTree<Character>('F');
        a = tree.addChild(tree.root, BNode.LEFT, 'D');
        b = tree.addChild(a, BNode.LEFT, 'B');
        c = tree.addChild(b, BNode.LEFT, 'A');
        c = tree.addChild(b, BNode.RIGHT, 'C');
        c = tree.addChild(a, BNode.RIGHT, 'E');
        a = tree.addChild(tree.root, BNode.RIGHT, 'G');
        b = tree.addChild(a, BNode.RIGHT, 'I');
        c = tree.addChild(b, BNode.LEFT, 'H');
        c = tree.addChild(b, BNode.RIGHT, 'J');
        
        tree.inorder();
        tree.preorder();
        tree.postorder();
        tree.inorderNonRecursive();
        
        System.out.println("Number of inner nodes is " + tree.insideNodes());
        System.out.println("Number of leaves is " + tree.leaves());
        System.out.println("Max depth is " + tree.depth());

        tree.mirror();
        tree.inorder();
    }

}
