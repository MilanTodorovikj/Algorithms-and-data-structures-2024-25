package Aud06;

import java.util.Scanner;

public class Birthdays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // Key: month in string format
        // Hash function: default hash function for class String from Java
        // Value: number of appearances of the key month
        CBHT<String, Integer> birthdays = new CBHT<>(23);
        for (int i = 0; i < N; i++) {
            String p[] = sc.nextLine().split("\\.");
            // if element with key p[1] does not exist in the hash table
            if (birthdays.search(p[1]) == null) birthdays.insert(p[1], 1);
            else {
                // if element with key p[1] exists in the hash table
                SLLNode<MapEntry<String, Integer>> br = birthdays.search(p[1]);
                birthdays.insert(p[1], br.element.value + 1);
            }
        }
        String month = sc.nextLine();
        SLLNode<MapEntry<String, Integer>> result = birthdays.search(month);

        //if element with key month does not exist
        if (result == null) System.out.println("Empty");
        else System.out.println(result.element.value);
    }
}


