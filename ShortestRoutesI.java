import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ShortestRoutesI {
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
        ArrayList<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = fs.nextInt() - 1;
            int v = fs.nextInt() - 1;
            int w = fs.nextInt();
            graph[u].add(new int[] { v, w });
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.add(new long[] { 0, 0 });

        while (!pq.isEmpty()) {
            long[] top = pq.poll();
            long w = top[0];
            int node = (int) top[1];

            if (dist[node] != w) {
                continue;
            }

            for (int[] neighbor : graph[node]) {
                if (w + neighbor[1] < dist[neighbor[0]]) {
                    dist[neighbor[0]] = w + neighbor[1];
                    pq.add(new long[] { dist[neighbor[0]], neighbor[0] });
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
}