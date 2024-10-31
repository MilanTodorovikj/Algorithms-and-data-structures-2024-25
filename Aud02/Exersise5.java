package Aud02;

import java.util.Scanner;
//Get every element with length L to be at the end of the list
//remembering its order
public class Exersise5 {
    public static void main(String[] args) {
        DLL<String> list = new DLL<>();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String line = scanner.next();
            list.insertLast(line);
        }

        int L = scanner.nextInt();
        DLL<String> list1 = new DLL<>();
        DLL<String> list2 = new DLL<>();
        DLLNode<String> node = list.getFirst();
        while (node != null) {
            if(node.element.length()!=L) {
                list1.insertLast(node.element);
            } else {
                list2.insertLast(node.element);
            }
            node = node.succ;
        }

        System.out.println(list1);
        System.out.println(list2);

        DLLNode<String> nodeLast1 = list1.getLast();
        DLLNode<String> nodeFirst2 = list2.getFirst();

        nodeLast1.succ = nodeFirst2;
        nodeFirst2.pred = nodeLast1;
        list2.deleteList();
//        node = list2.getFirst();
//        while (node != null) {
//            list1.insertLast(node.element);
//            node = node.succ;
//        }
        System.out.println(list1);
    }
}
