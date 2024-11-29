package Aud06;

import java.util.HashMap;

public class TestHashMap {
    public static void main(String[] args) {
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();
        String s = "АБВГДЃЕЖЗЅИЈКЛЊМНЊОПРСТЌУФХЦЧЏШ";
        for (int i = 0; i < s.length(); i++) {
            m.put(s.charAt(i), i);// The hash map is being filled
        }

        System.out.println(m);
        // We take the value for the letter Ш
        System.out.println("Bucket in which the letter Ш is " + m.get('Ш'));
    }

}