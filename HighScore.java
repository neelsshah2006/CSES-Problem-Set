import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class HighScore {
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

        int[][] edges = new int[m][3];
        ArrayList<Integer>[] reverseGraph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            reverseGraph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            edges[i][0] = fs.nextInt() - 1;
            edges[i][1] = fs.nextInt() - 1;
            edges[i][2] = fs.nextInt();
            reverseGraph[edges[i][1]].add(edges[i][0]);
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MIN_VALUE);
        dist[0] = 0;

        for (int k = 0; k < n - 1; k++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int gain = edge[2];
                if (dist[u] != Long.MIN_VALUE && dist[u] + gain > dist[v]) {
                    dist[v] = dist[u] + gain;
                }
            }
        }

        boolean[] canReachEnd = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(n - 1);
        canReachEnd[n - 1] = true;
        while (!q.isEmpty()) {
            int top = q.poll();
            for (int neighbor : reverseGraph[top]) {
                if(!canReachEnd[neighbor]) {
                    canReachEnd[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }

        boolean negCycleExists = false;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int gain = edge[2];
            if (dist[u] != Long.MIN_VALUE && dist[u] + gain > dist[v] && canReachEnd[v]) {
                negCycleExists = true;
                break;
            }
        }

        if (negCycleExists)
            System.out.println(-1);
        else
            System.out.println(dist[n - 1]);
    }
}
