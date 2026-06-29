import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ShortestRoutesII {
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
        int q = fs.nextInt();
        long[][] dist = new long[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int u = fs.nextInt() - 1;
            int v = fs.nextInt() - 1;
            long w = Math.min(fs.nextInt(), dist[u][v]);
            dist[u][v] = w;
            dist[v][u] = w;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Long.MAX_VALUE && dist[k][j] != Long.MAX_VALUE)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            sb.append((dist[u - 1][v - 1] == Long.MAX_VALUE ? -1 : dist[u - 1][v - 1]) + " ");
        }
        System.out.println(sb);
    }
}