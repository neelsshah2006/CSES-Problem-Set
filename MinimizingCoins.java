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
        for (int i = 1; i <= n; i++) {
            int val = coins[i - 1];
            int[] temp = new int[k + 1];
            temp[0] = 0;
            for (int j = 1; j <= k; j++) {
                if (j - val >= 0 && temp[j - val] != Integer.MAX_VALUE) {
                    temp[j] = Math.min(temp[j - val] + 1, dp[j]);
                } else {
                    temp[j] = dp[j];
                }
            }
            dp = temp;
        }

        System.out.println(dp[k] == Integer.MAX_VALUE ? -1 : dp[k]);
    }
}
