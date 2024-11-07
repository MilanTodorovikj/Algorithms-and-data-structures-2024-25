package Aud04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DP3 {

    static int cost[][];
    static int tax[], best[];
    static int n;
    static int INFINITY = 1000000;

    static int min(int x, int y) {
        if (x < y)
            return x;
        return y;
    }

    public static void main(String[] args) throws Exception {
        int i, j;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Insert number of cities:");
        n = Integer.parseInt(br.readLine());

        tax = new int[n];
        best = new int[n];
        cost = new int[n][n];

        for (i = 0; i < n; i++) {
            System.out.println("Insert taxes for city " + (i + 1) + " : ");
            tax[i] = Integer.parseInt(br.readLine());

            for (j = i + 1; j < n; j++) {
                System.out.println("Insert airplane ticket price from " + (i + 1) + " to " + (j + 1) + " : ");
                cost[i][j] = Integer.parseInt(br.readLine());
            }
        }

        best[0] = tax[0]; // For the first city we only pay the tax

        for (i = 1; i < n; i++) {
            best[i] = INFINITY; // initialization

            // we are searching for the optimal city j,
            // from which we will travel to city i
            for (j = 0; j < i; j++)
                best[i] = min(best[i], best[j] + cost[j][i] + tax[i]);
        }

        System.out.println("Minimum price is " + best[n - 1]);
    }
}

