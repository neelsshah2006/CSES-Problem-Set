import java.util.Arrays;
import java.util.Scanner;

public class MinimizingCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        sc.close();

        int[][] dp = new int[n + 1][k + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            int val = coins[i - 1];
            for (int j = 1; j <= k; j++) {
                if (j - val >= 0 && dp[i][j - val] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j - val] + 1, dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][k] == Integer.MAX_VALUE ? -1 : dp[n][k]);
    }
}
