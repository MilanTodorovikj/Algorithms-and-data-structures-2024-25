package Aud06;

public class DoublyHashedOBHTTest {

    public static void main(String[] args) {
        DoublyHashedOBHT<ChemicalElementDH, Integer> table1 = new DoublyHashedOBHT<ChemicalElementDH, Integer>(23);
        table1.insert(new ChemicalElementDH("H"), 1);
        table1.insert(new ChemicalElementDH("He"), 2);
        table1.insert(new ChemicalElementDH("Li"), 3);
        table1.insert(new ChemicalElementDH("Be"), 4);
        table1.insert(new ChemicalElementDH("Na"), 11);
        table1.insert(new ChemicalElementDH("Mg"), 12);
        table1.insert(new ChemicalElementDH("K"), 19);
        table1.insert(new ChemicalElementDH("Ca"), 20);
        table1.insert(new ChemicalElementDH("Rb"), 37);
        table1.insert(new ChemicalElementDH("Sr"), 38);
        table1.insert(new ChemicalElementDH("Cs"), 55);
        table1.insert(new ChemicalElementDH("Ba"), 56);

        System.out.println("Initial table.");
        System.out.println(table1);

        table1.insert(new ChemicalElementDH("Fr"), 87);
        table1.insert(new ChemicalElementDH("Ra"), 88);
        table1.insert(new ChemicalElementDH("B"), 5);

        System.out.println("Table after inserting Fr, Ra and B.");
        System.out.println(table1);

    }
}        