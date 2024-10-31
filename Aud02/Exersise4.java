package Aud02;

import java.util.Scanner;

//In a given DLL with Strings find the elements that are the
// length of L and add "TARGET" after each of the elements
public class Exersise4 {
    public static void main(String[] args) {
        DLL<String> list = new DLL<>();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String line = scanner.next();
            list.insertLast(line);
        }

        int L = scanner.nextInt();

        DLLNode<String> start = list.getFirst();
        while (start != null) {
            if(start.element.length()==L) {
                list.insertAfter("TARGET", start);
                start = start.succ;
            }
            start = start.succ;
        }
        System.out.println(list);
    }
}
