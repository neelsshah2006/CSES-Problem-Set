import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class FlightRoutes {
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
        int k = fs.nextInt();
        ArrayList<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = fs.nextInt() - 1;
            int v = fs.nextInt() - 1;
            int cost = fs.nextInt();
            graph[u].add(new int[] { v, cost });
        }

        StringBuilder ans = new StringBuilder();
        int count = 0;

        int[] dist = new int[n];

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[] { 0, 0 });

        while (!pq.isEmpty()) {
            long[] top = pq.poll();
            long cost = top[0];
            int node = (int) top[1];

            if (dist[node] >= k)
                continue;

            dist[node]++;

            if (node == n - 1) {
                ans.append(cost + " ");
                count++;
                if (count == k)
                    break;
            }

            for (int[] neighbor : graph[node]) {
                if (dist[neighbor[0]] < k) {
                    pq.offer(new long[] { cost + neighbor[1], neighbor[0] });
                }
            }
        }

        System.out.println(ans);
    }
}