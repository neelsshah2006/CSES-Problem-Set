import java.io.*;

public class MinimalGridPath {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] grid = new char[n][];
        for (int i = 0; i < n; i++)
            grid[i] = br.readLine().toCharArray();

        StringBuilder ans = new StringBuilder(2 * n);
        ans.append(grid[0][0]);

        int[] curr = new int[n + 5];
        int[] next = new int[n + 5];
        int currSize = 1;
        curr[0] = 0;
        int[][] seen = new int[n][n];

        for (int step = 1; step <= 2 * n - 2; step++) {
            char best = 'Z';
            for (int i = 0; i < currSize; i++) {
                int id = curr[i];
                int r = id / n;
                int c = id % n;

                if (r + 1 < n && grid[r + 1][c] < best)
                    best = grid[r + 1][c];

                if (c + 1 < n && grid[r][c + 1] < best)
                    best = grid[r][c + 1];
            }

            int nextSize = 0;
            for (int i = 0; i < currSize; i++) {
                int id = curr[i];
                int r = id / n;
                int c = id % n;

                if (r + 1 < n && grid[r + 1][c] == best && seen[r + 1][c] != step) {
                    seen[r + 1][c] = step;
                    next[nextSize++] = (r + 1) * n + c;
                }

                if (c + 1 < n && grid[r][c + 1] == best && seen[r][c + 1] != step) {
                    seen[r][c + 1] = step;
                    next[nextSize++] = r * n + c + 1;
                }
            }

            ans.append(best);
            int[] temp = curr;
            curr = next;
            next = temp;
            currSize = nextSize;
        }

        System.out.print(ans);
    }
}