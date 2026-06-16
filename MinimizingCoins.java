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

        int[] dp = new int[k + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int val = coins[i - 1];
            for (int j = 1; j <= k; j++) {
                if (j - val >= 0 && dp[j - val] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j - val] + 1, dp[j]);
                } else {
                    dp[j] = dp[j];
                }
            }
        }

        System.out.println(dp[k] == Integer.MAX_VALUE ? -1 : dp[k]);
    }
}
