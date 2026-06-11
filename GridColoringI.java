import java.util.Scanner;

public class GridColoringI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        String[] board = new String[n];
        for (int i = 0; i < n; i++) {
            board[i] = sc.next();
        }
        sc.close();

        int[][] cur = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = board[i].charAt(j) - 'A';
                for (int a = 0; a < 4; a++) {
                    if ((j == 0 || cur[i][j - 1] != a) && (i == 0 || cur[i - 1][j] != a) && x != a) {
                        cur[i][j] = a;
                        break;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < m; j++) {
                sb.append((char) (cur[i][j] + 'A'));
            }
            System.out.println(sb.toString());
        }
    }
}
