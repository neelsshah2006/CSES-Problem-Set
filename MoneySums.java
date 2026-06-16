import java.util.Scanner;

public class MoneySums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        sc.close();

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        int count = 0;
        for (int coin : arr) {
            for (int i = sum; i >= coin; i--) {
                if (!dp[i] && dp[i - coin]) {
                    dp[i] = true;
                    count++;
                }
            }
        }

        System.out.println(count);
        for (int i = 1; i <= sum; i++)
            if (dp[i])
                System.out.print(i + " ");
        System.out.println();
    }
}
