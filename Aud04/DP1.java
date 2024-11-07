package Aud04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DP1 {

    int binomial_coefficient(int n, int m) {
        int i, j;

        int bc[][] = new int[n + 1][n + 1]; // Table with binomial coefficients

        for (i = 0; i <= n; i++) {
            bc[i][0] = 1;
        }

        for (j = 0; j <= n; j++) {
            bc[j][j] = 1;
        }

        for (i = 1; i <= n; i++) {
            for (j = 1; j < i; j++) {
                bc[i][j] = bc[i - 1][j - 1] + bc[i - 1][j];
            }
        }

        return bc[n][m];
    }

    public static void main(String[] args) throws Exception {
        int i, j;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        DP1 dp = new DP1();

        System.out.println(dp.binomial_coefficient(5, 2));


    }
}
