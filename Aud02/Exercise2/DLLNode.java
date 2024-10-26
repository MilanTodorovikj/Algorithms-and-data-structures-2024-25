package Aud02.Exercise2;

public class DLLNode<E> {
    protected E element;
    protected DLLNode<E> pred, succ;
    protected Integer numberOfAppearances;

    public DLLNode(E elem, DLLNode<E> pred, DLLNode<E> succ) {
        this.element = elem;
        this.pred = pred;
        this.succ = succ;
        this.numberOfAppearances = 1;
    }

    @Override
    public String toString() {
        return "("+element.toString() +", " + numberOfAppearances+")";
    }
}


