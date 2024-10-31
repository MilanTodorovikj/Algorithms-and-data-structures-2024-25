package Aud03;

public class BruteForceChess {

    int areTheyAttacking(int i1, int j1, int i2, int j2) {
        if (i1 == i2) // same row
        {
            return 1;
        }
        if (j1 == j2) // same column
        {
            return 1;
        }
        if (Math.abs(i1 - i2) == Math.abs(j1 - j2)) // same diagonal
        {
            return 1;
        }
        return 0;
    }

    int numberOfCombinations() {
        int i1, j1, i2, j2;
        int rezultat = 0;

        for (i1 = 0; i1 < 8; i1++) {
            for (j1 = 0; j1 < 8; j1++) {
                for (i2 = 0; i2 < 8; i2++) {
                    for (j2 = 0; j2 < 8; j2++) {
                        if (areTheyAttacking(i1, j1, i2, j2) == 0) {
                            rezultat++;
                        }
                    }
                }
            }
        }

        return rezultat;
    }

    public static void main(String[] args) {

        BruteForceChess bf = new BruteForceChess();

        System.out.println("Number of combinations for queens to attack each other: " + bf.numberOfCombinations());
    }

}
