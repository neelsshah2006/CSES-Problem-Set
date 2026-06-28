import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class RoundTrip {
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

    public static int dfs(ArrayList<Integer>[] graph, boolean[] vis, int src, int par,
            ArrayList<Integer> cycleNodes) {
        vis[src] = true;
        for (int neigh : graph[src]) {
            if (!vis[neigh]) {
                int isCycle = dfs(graph, vis, neigh, src, cycleNodes);
                if (isCycle == 1) {
                    cycleNodes.add(src + 1);
                    if (vis[src])
                        return 1;
                    else {
                        vis[src] = true;
                        return -1;
                    }
                } else if (isCycle == -1)
                    return -1;
            } else if (neigh != par) {
                vis[neigh] = false;
                cycleNodes.add(neigh + 1);
                cycleNodes.add(src + 1);
                return 1;
            }
        }
        return 0;
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

        boolean[] vis = new boolean[n];
        ArrayList<Integer> cycleNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(graph, vis, i, -1, cycleNodes);
                if (cycleNodes.size() > 0)
                    break;
            }
        }

        if (cycleNodes.size() == 0) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(cycleNodes.size());
            for (int i : cycleNodes) {
                System.out.print(i + " ");
            }
        }
    }
}
