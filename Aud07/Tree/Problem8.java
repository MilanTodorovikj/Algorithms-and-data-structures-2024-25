package Aud07.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(example_input_2); // (System.in);
        SLLTree<String> tree = new SLLTree<String>();
        Map<String, Tree.Node<String>> nodes = new HashMap<>();

        int n = sc.nextInt();

        String valueRoot = sc.next();
        tree.makeRoot(valueRoot);
        Tree.Node<String> nodeRoot = tree.root;
        nodes.put(valueRoot, nodeRoot);

        for(int i = 1 ; i < n ; i++) {
            String valueParent = sc.next(), valueChild = sc.next();
            Tree.Node<String> nodeParent = nodes.get(valueParent);
            Tree.Node<String> nodeChild = tree.addChild(nodeParent, valueChild);
            nodes.put(valueChild, nodeChild);
        }

        tree.printTree();
    }
    static final String example_input = "7\nKoren\nKoren A\nKoren B\nA C\nB D\nA E\nC F";
    static final String example_input_2 = "7\nKoren\nKoren Jazol1\nKoren Jazol2\nJazol1 Jazol3\nJazol3 Jazol4\nJazol2 Jazol5\nKoren Jazol6";
}
