package Aud05;
import java.util.NoSuchElementException;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    // Redicata e pretstavena na sledniot nacin:
    // length go sodrzi brojot na elementi.
    // Elementite se zachuvuvaat vo jazli dod SLL
    // front i rear se linkovi do prviot i posledniot jazel soodvetno.
    SLLNode<E> front, rear;
    int length;

    // Konstruktor ...

    public PriorityQueue() {
        clear();
    }

    public boolean isEmpty() {
        // Vrakja true ako i samo ako redicata e prazena.
        return (length == 0);
    }

    public int size() {
        // Ja vrakja dolzinata na redicata.
        return length;
    }

    public E peek() {
        // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
        if (front == null)
            throw new NoSuchElementException();
        return front.element;
    }

    public void clear() {
        // Ja prazni redicata.
        front = rear = null;
        length = 0;
    }
// 1 2 3 (front->1, rear->3)
// latest.info<-4
// rear.succ->latest
// 1 2 3 4 (front->1, rear->3)
// rear = latest;
// 1 2 3 4 (front->1, rear->4)

    public void enqueue(E x) {
        // Go dodava x na kraj od redicata.
        SLLNode<E> latest = new SLLNode<E>(x, null);
        SLLNode<E> previous = front;
        if (isEmpty()) {
            front = rear = latest;
        } else if (latest.element.compareTo(front.element) < 0) {
            latest.succ = front;
            front = latest;
        } else {
            boolean is_latest_max=true;
            while(previous.succ !=null){
                if (latest.element.compareTo(previous.succ.element) < 0) {
                    latest.succ = previous.succ;
                    previous.succ = latest;
                    is_latest_max = false;
                    break;
                }
                else{
                    previous = previous.succ;
                }
            }
            if (is_latest_max){
                rear.succ = latest;
                latest.succ = null;
            }
        }
        length++;
    }

    public E dequeue() {
        // Go otstranuva i vrakja pochetniot element na redicata.
        if (front != null) {
            E frontmost = front.element;
            front = front.succ;
            if (front == null) rear = null;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }

    public String toString() {
        SLLNode<E> current = front;
        StringBuilder s = new StringBuilder();
        while (current != null) {
            s.append(current.element);
            s.append(" ");
            current = current.succ;
        }
        return s.toString();
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> q=new PriorityQueue<>();
        q.enqueue(6);
        System.out.println("tekovna sostojba:"+q+" prv za vadenje:"+q.peek());
        q.enqueue(9);
        System.out.println("tekovna sostojba:"+q+" prv za vadenje:"+q.peek());
        q.enqueue(4);
        System.out.println("tekovna sostojba:"+q+" prv za vadenje:"+q.peek());
        q.enqueue(7);
        System.out.println("tekovna sostojba:"+q+" prv za vadenje:"+q.peek());
    }
}
