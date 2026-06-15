import java.util.Scanner;
import java.util.Stack;

public class CountingRooms {
    static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    private static void dfs(String[] map, int i, int j, boolean[][] visited) {
        int n = map.length;
        int m = map[0].length();

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] { i, j });
        visited[i][j] = true;

        while (!stack.isEmpty()) {
            int[] curr = stack.pop();

            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];

                if (x >= 0 && y >= 0 && x < n && y < m && map[x].charAt(y) == '.' && !visited[x][y]) {

                    visited[x][y] = true;
                    stack.push(new int[] { x, y });
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] map = new String[n];
        for (int i = 0; i < n; i++) {
            map[i] = sc.next();
        }
        sc.close();

        boolean[][] visited = new boolean[n][m];
        int count = 0;
        int MOD = 1000000007;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i].charAt(j) == '.' && !visited[i][j]) {
                    dfs(map, i, j, visited);
                    count++;
                    if (count > MOD)
                        count -= MOD;
                }
            }
        }
        System.out.println(count);
    }
}
