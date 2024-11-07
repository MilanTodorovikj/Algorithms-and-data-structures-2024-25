package Aud04;

public class DP4 {

    int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    int DPKnapsack(int t[], int p[], int C) {
        int i, j;
        int n = t.length;
        int D[][] = new int[n + 1][C + 1];

        for (j = 0; j <= C; j++) {
            D[0][j] = 0;
        }

        for (i = 1; i <= n; i++) {
            D[i][0] = 0;
        }

        for (i = 1; i <= n; i++) {
            for (j = 1; j <= C; j++) {
                if (t[i - 1] <= j) {
                    D[i][j] = max(p[i - 1] + D[i - 1][j - t[i - 1]], D[i - 1][j]);
                } else {
                    D[i][j] = D[i - 1][j];
                }
            }
        }

        return D[n][C];
    }

    public static void main(String[] args) throws Exception {
        DP4 dp = new DP4();

        int n = 3;
        int C = 50;
        int p[] = new int[]{60, 100, 120};
        int t[] = new int[]{10, 20, 30};

        System.out.println(dp.DPKnapsack(t, p, C));
    }
}

