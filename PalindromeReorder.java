import java.util.Scanner;

public class PalindromeReorder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        int n = s.length();

        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            freq[c - 'A']++;
            if (freq[c - 'A'] % 2 == 0) {
                sb.append(c);
            }
        }

        String secondString = sb.toString();
        sb.append(new StringBuffer(secondString).reverse());

        if (n % 2 == 0) {
            if (s.length() == sb.length())
                System.out.println(sb.toString());
            else
                System.out.println("NO SOLUTION");
        } else {
            if (n - sb.length() > 1) {
                System.out.println("NO SOLUTION");
                return;
            }
            int mid = n / 2;
            for (int i = 0; i < 26; i++) {
                if (freq[i] % 2 != 0) {
                    if (mid != -1) {
                        sb.insert(mid, (char) ('A' + i));
                        mid = -1;
                        break;
                    }
                }
            }

            System.out.println(sb.toString());
        }
    }
}