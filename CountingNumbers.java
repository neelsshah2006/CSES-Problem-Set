import java.util.Arrays;
import java.util.Scanner;

public class CountingNumbers {
    static long[][][] dp;

    private static long dfs(String a, int pos, int prevInt, int tight) {
        if (pos == a.length()) {
            return 1;
        }

        if (prevInt != 10 && dp[pos][prevInt][tight] != -1)
            return dp[pos][prevInt][tight];

        int limit = tight == 1 ? a.charAt(pos) - '0' : 9;
        long res = 0;
        for (int i = 0; i <= limit; i++) {
            int nextTight = (tight == 1 && i == limit) ? 1 : 0;
            if (prevInt == 10 && i == 0) {
                res += dfs(a, pos + 1, 10, nextTight);
                continue;
            }

            if (i == prevInt)
                continue;
            res += dfs(a, pos + 1, i, nextTight);
        }
        dp[pos][prevInt][tight] = res;
        return res;
    }

    private static long count(long n) {
        if (n < 0)
            return 0;

        String s = Long.toString(n);
        dp = new long[s.length()][11][2];

        for (long[][] arr : dp)
            for (long[] row : arr)
                Arrays.fill(row, -1);

        return dfs(s, 0, 10, 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        sc.close();

        System.out.println(count(b) - count(a - 1));
    }
}