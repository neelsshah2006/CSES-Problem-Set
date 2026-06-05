import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int xor = n;
        for (int i = 1; i < n; i++) {
            xor ^= i ^ sc.nextInt();
        }
        sc.close();
        System.out.println(xor);
    }
}
