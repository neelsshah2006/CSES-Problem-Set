import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BuildingTeams {
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0)
                    return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + c - '0';
                c = read();
            }
            return val * sign;
        }
    }

    public static boolean bipartite(ArrayList<Integer>[] graph, int n, int[] col, int start) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            int color = ((col[node] & 1) + 1);
            for (int neighbor : graph[node]) {
                if (col[neighbor] == 0) {
                    col[neighbor] = color;
                    q.offer(neighbor);
                } else if (col[node] == col[neighbor]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int m = fs.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = fs.nextInt() - 1;
            int v = fs.nextInt() - 1;
            graph[u].add(v);
            graph[v].add(u);
        }

        int col[] = new int[n];
        boolean ans = true;
        for (int i = 0; i < n; i++) {
            if (col[i] == 0) {
                col[i] = 1;
                ans = bipartite(graph, n, col, i) && ans;
            }

            if (!ans)
                break;
        }
        if (!ans)
            System.out.println("IMPOSSIBLE");
        else {
            for (int i = 0; i < n; i++) {
                System.out.print(col[i] + " ");
            }
        }
    }
}