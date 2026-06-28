import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class BuildingRoads {

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

    public static void dfs(ArrayList<Integer>[] graph, boolean[] visited, int node) {
        visited[node] = true;
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] visited = new boolean[n];
        ArrayList<Integer> starts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                starts.add(i + 1);
                dfs(graph, visited, i);
            }
        }

        System.out.println(starts.size() - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < starts.size(); i++) {
            sb.append(starts.get(i - 1) + " " + starts.get(i) + "\n");
        }
        System.out.println(sb.toString());
    }
}