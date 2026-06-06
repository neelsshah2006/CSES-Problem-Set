import java.util.Scanner;

public class AppleDivision {
    static long ans = Integer.MAX_VALUE;

    private static void divide(int[] arr, int idx, long sum1, long sum2) {
        if (idx == arr.length) {
            ans = Math.min(ans, Math.abs(sum1 - sum2));
            return;
        }

        divide(arr, idx + 1, sum1 + arr[idx], sum2);
        divide(arr, idx + 1, sum1, sum2 + arr[idx]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        divide(arr, 0, 0, 0);
        System.out.println(ans);
    }
}