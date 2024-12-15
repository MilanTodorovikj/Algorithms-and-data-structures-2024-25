package Aud08.balancedbinarysearchtree;

public class AVLNode<E extends Comparable<E>> {

    public E info;      
    public AVLNode<E> left;
    public AVLNode<E> right;
    public int height;
    
    // Constructors
    AVLNode(E theElement) {
        this(theElement, null, null);
    }

    AVLNode(E info, AVLNode<E> left, AVLNode<E> right) {
        this.info = info;
        this.left = left;
        this.right = right;
        height = 0;
    }
    
}