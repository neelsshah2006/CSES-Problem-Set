import java.util.Scanner;

public class RemovingDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int[] steps = new int[n + 1];
        steps[0] = 0;
        for (int i = 1; i <= n; i++) {

            if (i < 9) {
                steps[i] = 1;
                continue;
            }

            int num = i;
            int max = 0;
            while (num > 0) {
                max = Math.max(max, num % 10);
                num /= 10;
            }
            steps[i] = steps[i - max] + 1;
        }

        System.out.println(steps[n]);
    }
}
