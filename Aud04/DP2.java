package Aud04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DP2 {


    int a[][] = new int[100][100];
    int best[][] = new int[100][100];

    void max_sum(int m, int n) {
        int i, j;


        // initialization of trivial cases
        best[0][0] = a[0][0];

        for (i = 1; i < m; i++) {
            best[i][0] = best[i - 1][0] + a[i][0]; // first column
        }
        for (i = 1; i < n; i++) {
            best[0][i] = best[0][i - 1] + a[0][i]; // first row
        }
        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                best[i][j] = Math.max(best[i - 1][j], best[i][j - 1]) + a[i][j];
            }
        }

    }

    public static void main(String[] args) throws Exception {
        int i, j;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        DP2 dp = new DP2();

        System.out.println("Insert number of rows: ");
        int m = Integer.parseInt(br.readLine());
        System.out.println("Insert number of columns: ");
        int n = Integer.parseInt(br.readLine());

        for (i = 0; i < m; i++) {       // insert number of stones for every field
            System.out.println("Insert " + (i + 1) + " row: ");
            for (j = 0; j < n; j++) {
                dp.a[i][j] = Integer.parseInt(br.readLine());
            }
        }

        dp.max_sum(m, n);

        System.out.println("Maximum sum is " + dp.best[m - 1][n - 1]);

    }
}
