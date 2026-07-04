import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Queue;

public class Subordinates {
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
        int[] parent = new int[n];
        int[] indegree = new int[n];
        for (int i = 1; i < n; i++) {
            parent[i] = fs.nextInt() - 1;
            indegree[parent[i]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        int[] dist = new int[n];
        while (!q.isEmpty()) {
            int top = q.poll();

            if (top == 0)
                continue;

            dist[parent[top]] += dist[top] + 1;
            indegree[parent[top]]--;
            if (indegree[parent[top]] == 0)
                q.add(parent[top]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(dist[i] + " ");
        }
        System.out.println(sb);
    }
}