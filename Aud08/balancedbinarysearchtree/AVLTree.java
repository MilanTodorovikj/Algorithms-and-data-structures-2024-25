package Aud08.balancedbinarysearchtree;

import java.util.Random;

public class AVLTree<E extends Comparable<E>> {
    
    /** The tree root. */
    private AVLNode<E> root;
    
    /**
     * Construct the tree.
     */
    public AVLTree() {
        root = null;
    }

    /**
     * Insert into the tree; duplicates are ignored.
     * @param x the item to insert.
     */
    public void insert(E x) {
        root = insert(x, root);
    }

    /**
     * Remove from the tree. Nothing is done if x is not found.
     * @param x the item to remove.
     */
    public void remove(E x) {
        root = remove(x, root);
    }
    
    // key - x
    // root - t
    
    private AVLNode<E> remove(E x, AVLNode<E> t) {
    
        // STEP 1: PERFORM STANDARD BST DELETE
        if (t == null)
            return t;
 
        // If the key to be deleted is smaller than the root's key,
        // then it lies in left subtree
        if (x.compareTo(t.info) < 0)
            t.left = remove(x, t.left);
        else if (x.compareTo(t.info) > 0)
            t.right = remove(x, t.right);
        else {
            // if key is same as root's key, then This is the node
            // to be deleted
            AVLNode<E> tmp;
            
            // node with only one child or no child
            if ((t.left == null)||(t.right == null)) {
                
                if (t.left != null)
                    tmp = t.left;
                else
                    tmp = t.right;
                
                // no child case
                if (tmp == null) {
                    tmp = t;
                    t = null;
                } else {
                    // one child case
                    t = tmp;
                }
            } else {
                // node with two children: Get the inorder successor (smallest
                // in the right subtree)
                tmp = findMin(t.right);
                // Copy the inorder successor's data to this node
                t.info = tmp.info;
                // Delete the inorder successor
                t.right = remove(tmp.info, t.right);
            }
                
        }
        
        // If the tree had only one node then return
        if (t == null)
          return t;
 
        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        t.height = max(height(t.left), height(t.right)) + 1;
        
        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        //  this node became unbalanced)
        int balance = getBalance(t);
        
        // If this node becomes unbalanced, then there are 4 cases
 
        // Left Left Case
        if ((balance > 1) && (getBalance(t.left) >= 0))
            return rotateWithLeftChild(t);
        
        // Left Right Case
        if ((balance > 1) && (getBalance(t.left) < 0))
            return doubleWithLeftChild(t);
        
        // Right Right Case
        if ((balance < -1) && (getBalance(t.right) <= 0))
            return rotateWithRightChild(t);
 
        // Right Left Case
        if ((balance < -1) && (getBalance(t.right) > 0))
            return doubleWithRightChild(t);
        
        return t;
    }
    
    // Get Balance factor of node N
    int getBalance(AVLNode<E> n) {
        if (n == null)
            return 0;
        return height(n.left) - height(n.right);
    }
    
     /**
     * Find the smallest item in the tree.
     * @return smallest item or null if empty.
     */
    public E findMin() {
        return elementAt(findMin(root));
    }

    /**
     * Find the largest item in the tree.
     * @return the largest item of null if empty.
     */
    public E findMax() {
        return elementAt(findMax(root));
    }

    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return the matching item or null if not found.
     */
    public E find(E x) {
        return elementAt(find(x, root));
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty() {
        root = null;
    }

    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Print the tree contents in sorted order.
     */
    public void printTree() {
        if (isEmpty()) {
            System.out.println("Empty tree");
        } else {
            printTree(root);
        }
    }

    /**
     * Internal method to get element field.
     * @param t the node.
     * @return the element field or null if t is null.
     */
    private E elementAt(AVLNode<E> t) {
        if (t == null)
            return null;
        else
            return t.info;
    }

    /**
     * Internal method to insert into a subtree.
     * @param x the item to insert.
     * @param t the node that roots the tree.
     * @return the new root.
     */
    private AVLNode<E> insert(E x, AVLNode<E> t) {
        if (t == null) {
            t = new AVLNode<E>(x, null, null);
        } else if (x.compareTo(t.info) < 0) {
            t.left = insert(x, t.left);
            if (height(t.left) - height(t.right) == 2) {
                if (x.compareTo(t.left.info) < 0) {
                    t = rotateWithLeftChild(t);
                } else {
                    t = doubleWithLeftChild(t);
                }
            }
        } else if (x.compareTo(t.info) > 0) {
            t.right = insert(x, t.right);
            if (height(t.right) - height(t.left) == 2) {
                if (x.compareTo(t.right.info) > 0) {
                    t = rotateWithRightChild(t);
                } else {
                    t = doubleWithRightChild(t);
                }
            }
        } else
                ;  // Duplicate; do nothing
        t.height = max(height(t.left), height(t.right)) + 1;
        return t;
    }

    /**
     * Internal method to find the smallest item in a subtree.
     * @param t the node that roots the tree.
     * @return node containing the smallest item.
     */
    private AVLNode<E> findMin(AVLNode<E> t) {
        if (t == null) {
            return t;
        }

        while (t.left != null) {
            t = t.left;
        }
        return t;
    }

    /**
     * Internal method to find the largest item in a subtree.
     * @param t the node that roots the tree.
     * @return node containing the largest item.
     */
    private AVLNode<E> findMax(AVLNode<E> t) {
        if (t == null) {
            return t;
        }

        while (t.right != null) {
            t = t.right;
        }
        return t;
    }

    /**
     * Internal method to find an item in a subtree.
     * @param x is item to search for.
     * @param t the node that roots the tree.
     * @return node containing the matched item.
     */
    private AVLNode<E> find(E x, AVLNode<E> t) {
        while (t != null) {
            if (x.compareTo(t.info) < 0) {
                t = t.left;
            } else if (x.compareTo(t.info) > 0) {
                t = t.right;
            } else {
                return t;    // Match
            }
        }
        return null;   // No match
    }

    /**
     * Internal method to print a subtree in sorted order.
     * @param t the node that roots the tree.
     */
    private void printTree(AVLNode<E> t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.info);
            printTree(t.right);
        }
    }

    /**
     * Return the height of node t, or -1, if null.
     */
    private int height(AVLNode<E> t) {
        if (t == null)
            return -1;
        else
            return t.height;
    }

    /**
     * Return maximum of lhs and rhs.
     */
    private int max(int lhs, int rhs) {
        if (lhs > rhs)
            return lhs;
        else
            return rhs;
    }

    /**
     * Rotate binary tree node with left child.
     * For AVL trees, this is a single rotation for case 1.
     * Update heights, then return new root.
     */
    private AVLNode<E> rotateWithLeftChild(AVLNode<E> k2) {
        AVLNode<E> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max(height(k2.left), height(k2.right)) + 1;
        k1.height = max(height(k1.left), k2.height) + 1;
        return k1;
    }

    /**
     * Rotate binary tree node with right child.
     * For AVL trees, this is a single rotation for case 4.
     * Update heights, then return new root.
     */
    private AVLNode<E> rotateWithRightChild(AVLNode<E> k1) {
        AVLNode<E> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max(height(k1.left), height(k1.right)) + 1;
        k2.height = max(height(k2.right), k1.height) + 1;
        return k2;
    }

    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child.
     * For AVL trees, this is a double rotation for case 2.
     * Update heights, then return new root.
     */
    private AVLNode<E> doubleWithLeftChild(AVLNode<E> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k1 with new right child.
     * For AVL trees, this is a double rotation for case 3.
     * Update heights, then return new root.
     */
    private AVLNode<E> doubleWithRightChild(AVLNode<E> k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }
    

    ////////////Tree print ////////////
    public void print() {
        // Print a textual representation of this AVL-tree.
        printSubtree(root, "", null);
    }

    private void printSubtree(AVLNode<E> tmp, String indent, AVLNode<E> parent) {
        // Print a textual representation of the subtree of this AVL-tree whose
        // topmost AVLNode is top, indented by the string of spaces indent.
        if (tmp != null) {
            //System.out.println(indent + "o-->");
            String childIndent = indent + "    ";
            printSubtree(tmp.right, childIndent, tmp);
            System.out.println(childIndent + tmp.info + " (" + tmp.height + ")"
                    + (parent == null ? "" : " parent " + parent.info.toString()));
            printSubtree(tmp.left, childIndent, tmp);
        }
    }

    // Test program
    public static void main(String[] args) {
        int i,j,k;
        
        AVLTree<Integer> t = new AVLTree<Integer>();
        
        int b[] = new int[15];
        
        Random r = new Random(System.currentTimeMillis());
        for (i = 0; i < 15; i++) {
            b[i] = r.nextInt(40);
            t.insert(new Integer(b[i]));
        }
        t.print();
        
        
        int a[] = new int[1000000];
        
        for (i=0;i<1000000;i++)
            t.insert(new Integer(a[i]));
        
        for (i=0;i<1000000;i++)
            t.remove(new Integer(a[i]));
        
        for (i=0;i<15;i++)
            t.remove(new Integer(b[i]));
        
        t.printTree();

    }
}
