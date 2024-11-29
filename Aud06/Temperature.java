package Aud06;

import java.util.HashMap;
import java.util.Scanner;

public class Temperature {
    static class Measurement {
        String name, from, to;
        double temp;
        public Measurement(String name, String from, String to, double temp) {
            this.name = name;   this.from = from;   this.to = to;   this.temp = temp;
        }
    }

    static class MyKeyForOBHT implements Comparable<MyKeyForOBHT>{
        String name;

        public MyKeyForOBHT(String name) { this.name = name; }

        @Override // одлучуваме да ја користиме само државата за хеш-кодирање
        public int hashCode() { return name.split(",")[1].hashCode(); }

        @Override
        public int compareTo(MyKeyForOBHT o) { return name.compareTo(o.name); }

        @Override // мора да биде имплементирано за да работи правилно CBHT/OBHT
        public boolean equals(Object obj) { return obj instanceof MyKeyForOBHT && this.name.equals(((MyKeyForOBHT)obj).name); }
    }

    static class MyKey implements DoublyHashable<MyKey> {
        String name;

        public MyKey(String name) { this.name = name; }

        @Override
        public int hashCode() { return name.hashCode(); }

        @Override // посакувано е да биде различна вредност од hashCode()
        public int stepCode() { return new StringBuilder(name).reverse().toString().hashCode(); }

        @Override
        public int compareTo(MyKey o) { return name.compareTo(o.name); }

        @Override // мора да биде имплементирано за да работи правилно DoublyHashedOBHT
        public boolean equals(Object obj) { return obj instanceof MyKey && this.name.equals(((MyKey)obj).name); }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        CBHT<String, Measurement> cbht = new CBHT<>(2 * N);
        OBHT<MyKeyForOBHT, Measurement> obht = new OBHT<>(2 * N);
        DoublyHashedOBHT<MyKey, Measurement> dobht = new DoublyHashedOBHT<>(2 * N);
        HashMap<String, Measurement> hm = new HashMap<>(2 * N);
        for (int i = 0; i < N; i++) {
            Measurement m = new Measurement(sc.next(), sc.next(), sc.next(), sc.nextDouble());
            Measurement prev;

            prev = null;
            if (cbht.search(m.name) != null) prev = cbht.search(m.name).element.value;
            if (prev == null || m.temp > prev.temp) cbht.insert(m.name, m);

            prev = null;
            MyKeyForOBHT key1 = new MyKeyForOBHT(m.name);
            if (obht.search(key1) != -1) prev = obht.getBucket(obht.search(key1)).value;
            if (prev == null || m.temp > prev.temp) obht.insert(key1, m);

            prev = null;
            MyKey key = new MyKey(m.name);
            if (dobht.search(key) != -1)
                prev = dobht.getBucket(dobht.search(key)).value;
            if (prev == null || m.temp > prev.temp) dobht.insert(key, m);

            prev = hm.get(m.name);
            if (prev == null || m.temp > prev.temp) hm.put(m.name, m);
        }

        String target = sc.next();
        Measurement m;

        m = null;
        if (cbht.search(target) != null) m = cbht.search(target).element.value;
        System.out.println(m == null ? "Not found" : m.name + ": " + m.from + " - " + m.to + " " + m.temp);

        m = null;
        MyKeyForOBHT key1 = new MyKeyForOBHT(target);
        if (obht.search(key1) != -1) m = obht.getBucket(obht.search(key1)).value;
        System.out.println(m == null ? "Not found" : m.name + ": " + m.from + " - " + m.to + " " + m.temp);

        m = null;
        MyKey key = new MyKey(target);
        if (dobht.search(key) != -1) m = dobht.getBucket(dobht.search(key)).value;
        System.out.println(m == null ? "Not found" : m.name + ": " + m.from + " - " + m.to + " " + m.temp);

        m = hm.get(target);
        System.out.println(m == null ? "Not found" : m.name + ": " + m.from + " - " + m.to + " " + m.temp);
    }
}
