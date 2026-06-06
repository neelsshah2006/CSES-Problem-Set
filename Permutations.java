import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        if (n == 1) {
            System.out.println(n);
        } else if (n > 1 && n <= 3) {
            System.out.println("NO SOLUTION");
        } else {
            StringBuilder ans = new StringBuilder();

            for (int i = 2; i <= n; i += 2) {
                ans.append(i).append(" ");
            }

            for (int i = 1; i <= n; i += 2) {
                ans.append(i).append(" ");
            }

            System.out.println(ans);
        }
    }
}