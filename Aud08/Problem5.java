package Aud08;

import Aud08.binarysearchtree.BinarySearchTree;
import Aud08.binarysearchtree.BNode;

import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner("9 1\n8 2 11 1 5 19 3 6 13");
//        Scanner sc = new Scanner("9 2\n8 2 11 1 5 19 3 6 13");
//        Scanner sc = new Scanner("9 4\n8 2 11 1 5 19 3 6 13");
//        Scanner sc = new Scanner("9 6\n8 2 11 1 5 19 3 6 13");
//        Scanner sc = new Scanner("9 9\n8 2 11 1 5 19 3 6 13");
//        Scanner sc = new Scanner("10 4\n8 2 11 1 5 10 19 3 6 13");
//        Scanner sc = new Scanner("10 9\n8 2 11 1 5 10 19 3 6 13");
        int n = sc.nextInt();

        int t = sc.nextInt();

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < n; i++)
            bst.insert(sc.nextInt());


        System.out.println("Before " + smaller(bst, t));
        System.out.println("After " + greater(bst, t));
    }

    // Find the successor element in inorder print in Tree
    private static int greater(BinarySearchTree<Integer> bst, int t) {
        return greaterRecursive(bst.getRoot(), t);
    }

    // Find the predecessor element in inorder print in Tree
    private static int smaller(BinarySearchTree<Integer> bst, int t) {
        return smallerRecursive(bst.getRoot(), t);
    }

    private static int greaterRecursive(BNode<Integer> node, int t) {
        if (node.info < t)
            return greaterRecursive(node.right, t);

        if (node.info == t)
            return subtreeMin(node.right);

        if (subtreeMax(node.left) == t)
            return node.info;

        return greaterRecursive(node.left, t);
    }

    private static int smallerRecursive(BNode<Integer> node, int t) {
        if (node.info > t)
            return smallerRecursive(node.left, t);

        if (node.info == t)
            return subtreeMax(node.left);

        if (subtreeMin(node.right) == t)
            return node.info;

        return smallerRecursive(node.right, t);
    }

    private static int subtreeMin(BNode<Integer> node) {
        while (node.left != null)
            node = node.left;
        return node.info;
    }

    private static int subtreeMax(BNode<Integer> node) {
        while (node.right != null)
            node = node.right;
        return node.info;
    }
}