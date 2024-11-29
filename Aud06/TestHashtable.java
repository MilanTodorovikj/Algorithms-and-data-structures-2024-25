package Aud06;

import java.util.Hashtable;

public class TestHashtable {
    public static void main(String[] args) {
        Hashtable<Character, Integer> m = new Hashtable<Character, Integer>();
        String s = "АБВГДЃЕЖЗЅИЈКЛЊМНЊОПРСТЌУФХЦЧЏШ";
        for (int i = 0; i < s.length(); i++) {
            m.put(s.charAt(i), i);// The hash table is being filled
        }

        System.out.println(m);
        // We take the value for the letter Ш
        System.out.println("Bucket in which the letter Ш is " + m.get('Ш'));
    }
}
