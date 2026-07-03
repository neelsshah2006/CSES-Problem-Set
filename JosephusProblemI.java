import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JosephusProblemI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(i + 1);
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            q.add(q.poll());
            sb.append(q.poll() + " ");
        }
        System.out.println(sb);
    }
}
