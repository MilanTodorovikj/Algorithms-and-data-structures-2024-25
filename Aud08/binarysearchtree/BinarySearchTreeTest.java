package Aud08.binarysearchtree;

import java.util.Random;

public class BinarySearchTreeTest {
    // Test program
    public static void main(String[] args) {
        int i, j, k;

        Random r = new Random(System.currentTimeMillis());
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        System.out.print("Inserting:");
        for (i = 0; i < 15; i++) {
            int x = r.nextInt(100);
            System.out.print(" " + x);
            bst.insert(x);
        }
        System.out.println();

        bst.printTree();

    }
}
