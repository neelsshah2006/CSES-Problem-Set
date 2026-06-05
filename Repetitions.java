import java.util.Scanner;

public class Repetitions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        char prev = s.charAt(0);
        int freq = 1;
        int maxFreq = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == prev)
                freq++;
            else {
                maxFreq = Math.max(freq, maxFreq);
                freq = 1;
                prev = s.charAt(i);
            }
        }
        maxFreq = Math.max(maxFreq, freq);
        System.out.println(maxFreq);
    }
}
