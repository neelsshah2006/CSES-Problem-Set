import java.util.*;

public class Labyrinth {

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] grid = new char[n][m];
        int sx = 0, sy = 0;
        int ex = 0, ey = 0;
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                grid[i][j] = s.charAt(j);
                if (grid[i][j] == 'A') {
                    sx = i;
                    sy = j;
                }
                if (grid[i][j] == 'B') {
                    ex = i;
                    ey = j;
                }
            }
        }
        sc.close();

        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        char[][] parent = new char[n][m];

        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };
        char[] move = { 'D', 'U', 'R', 'L' };

        q.add(new Pair(sx, sy));
        vis[sx][sy] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = curr.x + dx[k];
                int ny = curr.y + dy[k];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m
                        && !vis[nx][ny]
                        && grid[nx][ny] != '#') {

                    vis[nx][ny] = true;

                    parent[nx][ny] = move[k];

                    q.add(new Pair(nx, ny));
                }
            }
        }

        if (!vis[ex][ey]) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
        StringBuilder ans = new StringBuilder();
        int x = ex;
        int y = ey;
        while (x != sx || y != sy) {
            char c = parent[x][y];
            ans.append(c);
            if (c == 'D') {
                x--;
            } else if (c == 'U') {
                x++;
            } else if (c == 'R') {
                y--;
            } else {
                y++;
            }
        }

        ans.reverse();
        System.out.println(ans.length());
        System.out.println(ans);
    }
}