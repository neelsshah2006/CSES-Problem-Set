import java.util.Scanner;

public class EditDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        sc.close();

        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = i;
        for (int i = 0; i <= m; i++)
            dp[0][i] = i;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j - 1];
                if (a.charAt(i - 1) != b.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i][j], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
