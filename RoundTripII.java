import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class RoundTripII {
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

    private static boolean dfs(ArrayList<Integer>[] graph, int[] vis, int[] path, int current, ArrayList<Integer> ans) {
        vis[current] = 1;
        path[current] = 1;
        for (int neighbor : graph[current]) {
            if (vis[neighbor] == 0) {
                if (dfs(graph, vis, path, neighbor, ans)) {
                    ans.add(current + 1);
                    if (vis[current] == -1)
                        return false;
                    else
                        return true;
                }
                if (vis[neighbor] == -1) {
                    vis[current] = -1;
                    return false;
                }
            } else if (path[neighbor] == 1) {
                vis[neighbor] = -1;
                ans.add(neighbor + 1);
                ans.add(current + 1);
                return true;
            }
        }
        path[current] = 0;
        return false;
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
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int[] vis = new int[n];
        int[] path = new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(graph, vis, path, i, ans);
                if (ans.size() > 0)
                    break;
            }
        }

        if (ans.size() == 0) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        StringBuilder sb = new StringBuilder();
        System.out.println(ans.size());
        for (int i = ans.size() - 1; i >= 0; i--) {
            sb.append(ans.get(i) + " ");
        }
        System.out.println(sb);
    }
}
