package Aud04;

public class DP5 {

    int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    int longestCommonSubsequenceLength(String x, String y) {
        int i, j;
        int N = x.length();
        int M = y.length();

        int NZP[][] = new int[N + 1][M + 1];

        for (i = 0; i < N; i++) {
            NZP[i][0] = 0;
        }

        for (j = 0; j < M; j++) {
            NZP[0][j] = 0;
        }

        for (i = 1; i <= N; i++) {
            for (j = 1; j <= M; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    NZP[i][j] = NZP[i - 1][j - 1] + 1;
                } else {
                    NZP[i][j] = max(NZP[i - 1][j], NZP[i][j - 1]);
                }
            }
        }

        return NZP[N][M];
    }

    String longestCommonSubsequenceString(String x, String y) {
        int i, j;
        int N = x.length();
        int M = y.length();

        int NZP[][] = new int[N + 1][M + 1];

        for (i = 0; i < N; i++) {
            NZP[i][0] = 0;
        }

        for (j = 0; j < M; j++) {
            NZP[0][j] = 0;
        }

        for (i = 1; i <= N; i++) {
            for (j = 1; j <= M; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    NZP[i][j] = NZP[i - 1][j - 1] + 1;
                } else {
                    NZP[i][j] = max(NZP[i - 1][j], NZP[i][j - 1]);
                }
            }
        }

        char rez1[] = new char[max(N, M)];
        int L = 0;
        i = N;
        j = M;

        while ((i != 0) && (j != 0)) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                rez1[L] = x.charAt(i - 1);
                L++;
                i--;
                j--;
            } else {
                if (NZP[i][j] == NZP[i - 1][j]) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        String rez2 = "";
        for (i = 0; i < L; i++) {
            rez2 += rez1[L - 1 - i];
        }

        return rez2;
    }

    public static void main(String[] args) throws Exception {

        DP5 dp = new DP5();

        String x = "ggcaccacg";
        String y = "acggcggatacg";

        System.out.println(dp.longestCommonSubsequenceLength(x, y));
        System.out.println(dp.longestCommonSubsequenceString(x, y));

    }

}

