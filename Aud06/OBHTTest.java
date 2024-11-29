package Aud06;

public class OBHTTest {

    public static void main(String[] args) {
        OBHT<ChemicalElement, Integer> table1 = new OBHT<ChemicalElement, Integer>(26);
        table1.insert(new ChemicalElement("H"), 1);
        table1.insert(new ChemicalElement("He"), 2);
        table1.insert(new ChemicalElement("Li"), 3);
        table1.insert(new ChemicalElement("Be"), 4);
        table1.insert(new ChemicalElement("Na"), 11);
        table1.insert(new ChemicalElement("Mg"), 12);
        table1.insert(new ChemicalElement("K"), 19);
        table1.insert(new ChemicalElement("Ca"), 20);
        table1.insert(new ChemicalElement("Rb"), 37);
        table1.insert(new ChemicalElement("Sr"), 38);
        table1.insert(new ChemicalElement("Cs"), 55);
        table1.insert(new ChemicalElement("Ba"), 56);

        System.out.println("Initial table.");
        System.out.println(table1);

        // Clone table1 into table2
        OBHT<ChemicalElement, Integer> table2 = (OBHT<ChemicalElement, Integer>) table1.clone();

        table1.insert(new ChemicalElement("Fr"), 87);
        table1.insert(new ChemicalElement("Ra"), 88);
        table1.insert(new ChemicalElement("B"), 5);

        System.out.println("Table after inserting Fr, Ra and B.");
        System.out.println(table1);

        table2.delete(new ChemicalElement("Mg"));
        table2.delete(new ChemicalElement("Ca"));
        //table2.delete(new ChemicalElement("Ba"));

        System.out.println("Initial table after deleting Mg, Ca and Ba.");
        System.out.println(table2);

        //table2.delete(new ChemicalElement("Ba"));
        table2.delete(new ChemicalElement("Be"));
        //table2.delete(new ChemicalElement("Ba"));

        // This line will throw an error since there is only an element with key B in table1 and not in the clone table2
        table2.delete(new ChemicalElement("B"));

        System.out.println(table2);

        table2.insert(new ChemicalElement("Ba"), 56);
        table2.insert(new ChemicalElement("Be"), 4);

        System.out.println(table2);

        table2.delete(new ChemicalElement("Ba"));
        table2.delete(new ChemicalElement("Ba"));
        table2.delete(new ChemicalElement("Ba"));
        System.out.println(table2);


    }
}        