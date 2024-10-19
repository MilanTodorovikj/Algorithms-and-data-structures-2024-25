package Aud01;

import java.util.Scanner;

public class EvenNumbersSLL {
    public static int evenNumbers(SLL<Integer> list) {
        int even = 0;

        SLLNode<Integer> tmp = list.getFirst();
        while (tmp != null) {
            if(tmp.element % 2 == 0){
                even++;
            }

            tmp = tmp.succ;
        }

        return even;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Insert the number of elements in the list:");
        int n = sc.nextInt();

        SLL<Integer> list = new SLL<>();
        System.out.println("Insert the elements in the list (integers):");
        for(int i=0;i<n;i++) {
            list.insertLast(sc.nextInt());
        }

        System.out.println("Number of even numbers in the list: " + evenNumbers(list));
    }
}


