import java.util.Arrays;
import java.util.Scanner;

public class SumOfThreeValues {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long x = sc.nextLong();
        long[][] arr = new long[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextLong();
            arr[i][1] = i + 1;
        }
        sc.close();

        Arrays.sort(arr, (a, b) -> Long.compare(a[0], b[0]));
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            int left = i + 1, right = arr.length - 1;
            long target = x - arr[i][0];
            while (left < right) {
                long sum = arr[left][0] + arr[right][0];
                if (sum == target) {
                    System.out.println(arr[i][1] + " " + arr[left][1] + " " + arr[right][1]);
                    return;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}