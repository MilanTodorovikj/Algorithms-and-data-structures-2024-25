package Aud03;

public class GreedyCoins {

    void sortCoins(int coins[], int n) {
        int i, j, tmp;

        for (i = 0; i < n; i++) {
            for (j = i + 1; j < n; j++) {
                if (coins[i] < coins[j]) {
                    tmp = coins[i];
                    coins[i] = coins[j];
                    coins[j] = tmp;
                }
            }
        }
    }

    // coins is array of coin values
    // n is number of coins
    // sum is given sum
    // coinsNum is array of how much of each coin should be returned
    int greedyCoins(int coins[], int n, int sum, int coinsNum[]) {

        sortCoins(coins, n);

        int i = 0;
        int br = 0; // total number of coins to return the sum

        while (sum > 0) {
            coinsNum[i] = sum / coins[i];
            sum -= coinsNum[i] * coins[i];
            br += coinsNum[i];
            i++;
        }

        while (i < n) {
            coinsNum[i] = 0;
            i++;
        }

        return br;
    }

    public static void main(String[] args) {

        GreedyCoins g = new GreedyCoins();

        int coins[] = new int[5];
        int n = 5;
        int sum = 123;
        int coinsNum[] = new int[5];

        coins[0] = 1;
        coins[1] = 2;
        coins[2] = 5;
        coins[3] = 10;
        coins[4] = 50;

        System.out.println("Greedy coins: " + g.greedyCoins(coins, n, sum, coinsNum));
        for (int i = 0; i < 5; i++) {
            System.out.println(coins[i] + "-" + coinsNum[i]);
        }
    }
}
