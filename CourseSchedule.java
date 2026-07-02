import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
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
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = fs.nextInt() - 1;
            int v = fs.nextInt() - 1;
            graph[u].add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        int p = n - 1;
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int top = q.poll();
            for (int i : graph[top]) {
                if (--indegree[i] == 0)
                    q.add(i);
            }
            sb.append(top + 1 + " ");
            p--;
        }

        if (p != -1)
            System.out.println("IMPOSSIBLE");
        else
            System.out.println(sb);
    }
}