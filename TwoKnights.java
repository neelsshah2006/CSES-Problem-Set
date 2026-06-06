import java.util.Scanner;

public class TwoKnights {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                System.out.println(0);
                continue;
            }
            long p = (long) i * i;
            long combs = p * (p - 1) / 2;
            long attacks = ((long) i - 1) * (i - 2) * 4;
            System.out.println(combs - attacks);
        }
    }
}
