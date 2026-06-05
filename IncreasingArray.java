import java.util.Scanner;

public class IncreasingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int prev = sc.nextInt();
        long ops = 0;
        for (int i = 1; i < n; i++) {
            int curr = sc.nextInt();
            ops += Math.max(0, prev - curr);
            prev = Math.max(prev, curr);
        }
        sc.close();
        System.out.println(ops);
    }
}
