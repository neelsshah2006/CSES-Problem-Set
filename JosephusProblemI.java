import java.util.Scanner;

public class JosephusProblemI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        if (n == 1) {
            System.out.println(1);
            return;
        }

        boolean skip = true;
        int num = 2;
        boolean[] vis = new boolean[n];
        int count = 0;
        StringBuilder ans = new StringBuilder();
        while (count < n) {
            if (skip && !vis[num - 1]) {
                vis[num - 1] = true;
                ans.append(num + " ");
                count++;
                skip = false;
            } else if (!vis[num - 1])
                skip = true;

            num++;
            if (num > n)
                num = 1;
        }

        System.out.println(ans);
    }
}
