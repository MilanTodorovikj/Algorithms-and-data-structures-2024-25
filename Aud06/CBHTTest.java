package Aud06;

public class CBHTTest {

    public static void main(String[] args) {
        CBHT<ChemicalElement, Integer> table1 = new CBHT<ChemicalElement, Integer>(26);
        table1.insert(new ChemicalElement("F"), 9);
        table1.insert(new ChemicalElement("Ne"), 10);
        table1.insert(new ChemicalElement("Cl"), 17);
        table1.insert(new ChemicalElement("Ar"), 18);
        table1.insert(new ChemicalElement("Br"), 35);
        table1.insert(new ChemicalElement("Kr"), 36);
        table1.insert(new ChemicalElement("I"), 53);
        table1.insert(new ChemicalElement("Xe"), 54);

        System.out.println("Table from presentation slide 5");
        System.out.println(table1);

        CBHT<ChemicalElement, Integer> table2 = new CBHT<ChemicalElement, Integer>(26);
        table2.insert(new ChemicalElement("H"), 1);
        table2.insert(new ChemicalElement("He"), 2);
        table2.insert(new ChemicalElement("Li"), 3);
        table2.insert(new ChemicalElement("Be"), 4);
        table2.insert(new ChemicalElement("Na"), 11);
        table2.insert(new ChemicalElement("Mg"), 12);
        table2.insert(new ChemicalElement("K"), 19);
        table2.insert(new ChemicalElement("Ca"), 20);
        table2.insert(new ChemicalElement("Rb"), 37);
        table2.insert(new ChemicalElement("Sr"), 38);
        table2.insert(new ChemicalElement("Cs"), 55);
        table2.insert(new ChemicalElement("Ba"), 56);

        System.out.println("Table from presentation slide 6");
        System.out.println(table2);
    }
}        