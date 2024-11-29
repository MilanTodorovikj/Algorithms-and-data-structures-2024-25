package Aud06;

class ChemicalElementDH implements DoublyHashable<ChemicalElementDH> {

    // A ChemicalElement object represents a chemical element.

    // Each element contains the two characters of the chemical symbol.
    // The first character must be an uppercase letter. Where present,
    // the second character must be a lowercase letter. If absent, the
    // second character is a space.

    private char sym1, sym2; // The two letters of the chemical symbol.


    public ChemicalElementDH(String symbol) {
        if (symbol.length() >= 1)
            sym1 = Character.toUpperCase(symbol.charAt(0));
        else
            sym1 = ' '; // Should really fail.
        if (symbol.length() >= 2)
            sym2 = Character.toLowerCase(symbol.charAt(1));
        else
            sym2 = ' ';
    }

    public int hashCode() {
        return sym1 - 'A';
    }

    public int stepCode() {
        return (sym2 == ' ') ? 1 : sym2 - 'a' + 2;
    }

    public String toString() {
        return "" + sym1 + sym2;
    }

    public int compareTo(ChemicalElementDH that) {
        if (this.sym1 != that.sym1)
            return Character.compare(this.sym1, that.sym1);
        else
            return Character.compare(this.sym2, that.sym2);
    }

    public boolean equals(Object that) {
        if (that == null || !(that instanceof ChemicalElementDH))
            return false;
        else {
            ChemicalElementDH other = (ChemicalElementDH) that;
            return this.compareTo(other) == 0;
        }
    }
}
            