import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MessageRoute {

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

        Queue<Integer> q = new LinkedList<>();
        int[] par = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
        q.offer(0);
        par[0] = -1;

        while (!q.isEmpty()) {
            int top = q.poll();

            if (top == n - 1) {
                break;
            }

            for (int neighbor : graph[top]) {
                if (par[neighbor] == neighbor) {
                    par[neighbor] = top;
                    q.add(neighbor);
                }
            }
        }

        if (par[n - 1] == n - 1) {
            System.out.println("IMPOSSIBLE");
        } else {
            ArrayList<Integer> path = new ArrayList<>();

            int node = n - 1;
            while (node != -1) {
                path.add(node + 1);
                node = par[node];
            }

            System.out.println(path.size());

            for (int i = path.size() - 1; i >= 0; i--) {
                System.out.print(path.get(i) + " ");
            }
        }
    }
}
