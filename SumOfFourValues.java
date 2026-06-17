import java.util.Arrays;
import java.util.Scanner;

public class SumOfFourValues {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long target = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = i + 1;
        }
        sc.close();

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && arr[j][0] == arr[j - 1][0])
                    continue;

                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    long sum = (long) arr[i][0] + (long) arr[j][0] + (long) arr[left][0] + (long) arr[right][0];
                    if (sum == target) {
                        System.out.println(arr[i][1] + " " + arr[j][1] + " " + arr[left][1] + " " + arr[right][1]);
                        return;
                    } else if (sum < target)
                        left++;
                    else
                        right--;
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
