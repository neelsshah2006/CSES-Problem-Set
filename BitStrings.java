import java.util.Scanner;

public class BitStrings {
    static int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        sc.close();

        long base = 2;
        long ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans = (ans * base) % MOD;
            }

            base = (base * base) % MOD;
            n >>= 1;
        }
        System.out.println(ans);
    }
}