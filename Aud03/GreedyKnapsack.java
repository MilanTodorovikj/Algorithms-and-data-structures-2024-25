package Aud03;

public class GreedyKnapsack {


    void sort(int p[], int t[], int n) {
        int i, j, tmpP, tmpT;

        for (i = 0; i < n; i++) {
            for (j = i + 1; j < n; j++) {
                if (((float) p[i] / (float) t[i]) < ((float) p[j] / (float) t[j])) {
                    tmpP = p[i];
                    tmpT = t[i];
                    p[i] = p[j];
                    t[i] = t[j];
                    p[j] = tmpP;
                    t[j] = tmpT;
                }
            }
        }

    }

    // p and t contain the profit and weight of the objects
    // C is the capacity of the knapsack, x is the array for the solution
    float greedyFractionalKnapsack(int p[], int t[], float C, int n, float x[]) {

        sort(p, t, n);
        // objects are sorted such that p[i]/t[i] >= p[i+1]/t[i+1]

        int i;
        float profit = 0;

        for (i = 0; i < n; i++) {
            x[i] = 0;
        }

        for (i = 0; i < n; i++) {
            if (C > t[i]) {         // object is stored fully
                C -= t[i];
                profit += p[i];
            } else {                // object is stored partially
                profit += (C / (float) t[i]) * (float) p[i];
                C = 0;
                break;
            }
        }

        return profit;
    }

    public static void main(String[] args) {

        GreedyKnapsack g = new GreedyKnapsack();


        float C = 20;
        int n = 3;
        int p[] = new int[3];
        int t[] = new int[3];
        float x[] = new float[3];

        p[0] = 25;
        p[1] = 24;
        p[2] = 15;

        t[0] = 18;
        t[1] = 15;
        t[2] = 10;

        System.out.println("Greedy fractional knapsack: " + g.greedyFractionalKnapsack(p, t, C, n, x));
        for (int i = 0; i < n; i++) {
            System.out.println(p[i] + "-" + t[i]);

        }
    }
}
