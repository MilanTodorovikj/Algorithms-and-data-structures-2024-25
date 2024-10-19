package Aud01;

import java.util.ArrayList;

public class ChangeArrays<E> {
    public void compareAndChangeArrays(Array<E> niza1, Array<E> niza2) {
        if(niza1.getSize() != niza2.getSize()){
            System.out.println("The arrays do not have the same size!");
            return;
        } else {
            int size = niza1.getSize();
            for(int i = 0; i < size; i++){
                if(niza1.get(i).equals(niza2.get(i))){
                    niza1.delete(i);
                    niza2.delete(i);
                    size = niza1.getSize();
                    i--;
                }
            }
        }
    }

    public void compareAndChangeArrays(ArrayList<E> niza1, ArrayList<E> niza2) {
        if(niza1.size() != niza2.size()) {
            System.out.println("The arrays do not have the same size!");
            return;
        }
        int size = niza1.size();
        int i = 0;
        while(i < size) {
            if(niza1.get(i).equals(niza2.get(i))) {
                niza1.remove(i);
                niza2.remove(i);
                size--;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Array<String> niza1 = new Array<String>(4);
        niza1.insertLast("nb11");
        niza1.insertLast("b1");
        niza1.insertLast("b2");
        niza1.insertLast("nb12");

        Array<String> niza2 = new Array<String>(4);
        niza2.insertLast("nb21");
        niza2.insertLast("b1");
        niza2.insertLast("b2");
        niza2.insertLast("nb22");

        System.out.println("The arrays before compareAndChangeArrays method: ");
        System.out.println(niza1.toString());
        System.out.println(niza2.toString());

        ChangeArrays<String> pom = new ChangeArrays<String>();
        pom.compareAndChangeArrays(niza1, niza2);

        System.out.println("The arrays after compareAndChangeArrays method: ");
        System.out.println(niza1.toString());
        System.out.println(niza2.toString());

        ArrayList<Integer> niza3 = new ArrayList<Integer>(3);
        niza3.add(10);
        niza3.add(13);
        niza3.add(7);

        ArrayList<Integer> niza4 = new ArrayList<Integer>(3);
        niza4.add(5);
        niza4.add(13);
        niza4.add(3);

        System.out.println("The arrays before compareAndChangeArrays method: ");
        System.out.println(niza3.toString());
        System.out.println(niza4.toString());

        ChangeArrays<Integer> pom2 = new ChangeArrays<Integer>();
        pom2.compareAndChangeArrays(niza3, niza4);

        System.out.println("The arrays before compareAndChangeArrays method: ");
        System.out.println(niza3.toString());
        System.out.println(niza4.toString());

    }
}
