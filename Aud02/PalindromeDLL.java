package Aud02;

import java.util.LinkedList;
import java.util.Scanner;

public class PalindromeDLL {

    public static int isItPalindrome(LinkedList<Integer> list) {
        for(int i=0;i<list.size()/2;i++) {
            if(!list.get(i).equals(list.get(list.size()-i-1))) {
                return -1;
            }
        }
        return 1;
    }

    public static int isItPalindrome(DLL<Integer> list){
        DLLNode<Integer> poceten = list.getFirst();
        DLLNode<Integer> posleden = list.getLast();
        while((poceten != posleden)&&(poceten.pred != posleden)){
            if(!poceten.element.equals(posleden.element))
                return -1;
            poceten = poceten.succ;
            posleden = posleden.pred;
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        DLL<Integer> list = new DLL<>();
        LinkedList<Integer> list1 = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int tmp = in.nextInt();
            list.insertLast(tmp);
            list1.add(tmp);
        }
        in.close();
        System.out.println(isItPalindrome(list));
        System.out.println(isItPalindrome(list1));
    }

}


