package Aud06;

import java.util.Scanner;

public class RedCross {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OBHT<String, Integer> hashtable = new OBHT<String, Integer>(11);
        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            String name = sc.next();
            String input = sc.next();
            Character c1 = input.charAt(0);
            Character c2 = input.charAt(input.length() - 1);
            String key = c1.toString() + c2.toString();
            int bucket = hashtable.search(key);
            if (bucket == -1) hashtable.insert(key, 1);
            else hashtable.insert(key, hashtable.getBucket(bucket).value + 1);
        }
        System.out.println(hashtable);
    }
}