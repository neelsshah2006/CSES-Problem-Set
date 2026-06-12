import java.io.IOException;
import java.io.InputStream;

public class StaticRangeSumQueries {

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
        long[] prefix = new long[n + 1];
        prefix[0] = 0;
        for (int i = 1; i <= n; i++)
            prefix[i] = prefix[i - 1] + fs.nextInt();

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int start = fs.nextInt();
            int stop = fs.nextInt();
            ans.append((prefix[stop] - prefix[start - 1]) + "\n");
        }
        System.out.println(ans.toString());
    }
}
