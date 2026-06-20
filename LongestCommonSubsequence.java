import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for (int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();
        for (int i = 0; i < m; i++)
            arr2[i] = sc.nextInt();
        sc.close();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        int i = n;
        int j = m;
        while (i != 0 && j != 0) {
            if (arr1[i - 1] == arr2[j - 1]) {
                stack.add(arr1[i - 1]);
                i--;
                j--;
            } else {
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    j--;
                } else
                    i--;
            }
        }

        System.out.println(dp[n][m]);
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }
}