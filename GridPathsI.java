import java.util.Scanner;

public class GridPathsI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] grid = new String[n];
        for (int i = 0; i < n; i++) {
            grid[i] = sc.next();
        }
        sc.close();

        int[][] paths = new int[n][n];
        int MOD = 1000000007;
        for (int i = 0; i < n; i++) {
            if (grid[0].charAt(i) == '*')
                break;
            paths[0][i] = 1;
        }

        for (int i = 0; i < n; i++) {
            if (grid[i].charAt(0) == '*')
                break;
            paths[i][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i].charAt(j) == '.')
                    paths[i][j] = (paths[i - 1][j] + paths[i][j - 1]) % MOD;
            }
        }

        System.out.println(paths[n - 1][n - 1]);
    }
}
