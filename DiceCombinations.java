import java.util.Scanner;

public class DiceCombinations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int x = 1; x <= 6; x++) {
                if (i - x < 0)
                    break;
                dp[i] += dp[i - x]% 1000000007;
            }
        }
        System.out.println(dp[n] % 1000000007);
    }
}
