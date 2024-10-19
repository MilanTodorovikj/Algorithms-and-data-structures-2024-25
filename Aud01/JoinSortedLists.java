package Aud01;

public class JoinSortedLists<E extends Comparable<E>> {

    public SLL<E> join(SLL<E> list1, SLL<E> list2){
        SLL<E> rezultat = new SLL<E>();
        SLLNode<E> e1 = list1.getFirst();
        SLLNode<E> e2 = list2.getFirst();

        while (e1 != null && e2 != null){
            if(e1.element.compareTo(e2.element) < 0){
                rezultat.insertLast(e1.element);
                e1 = e1.succ;
            } else {
                rezultat.insertLast(e2.element);
                e2 = e2.succ;
            }

        }

        while(e1 != null){
            rezultat.insertLast(e1.element);
            e1 = e1.succ;
        }

        while(e2 != null){
            rezultat.insertLast(e2.element);
            e2=e2.succ;
        }

        return rezultat;
    }

    public static void main(String[] args){
        SLL<String> lista1 = new SLL<String>();
        lista1.insertLast("Ana");lista1.insertLast("Bojana");lista1.insertLast("Dejan");
        SLL<String> lista2 = new SLL<String>();
        lista2.insertLast("Andrijana");lista2.insertLast("Biljana");lista2.insertLast("Darko");

        JoinSortedLists<String> js = new JoinSortedLists<String>();
        System.out.println(js.join(lista1, lista2));

    }
}
