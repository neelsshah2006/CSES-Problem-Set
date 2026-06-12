import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class StickLengths {
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

    public static void main(String args[]) throws IOException {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] sticks = new int[n];
        for (int i = 0; i < n; i++) {
            sticks[i] = fs.nextInt();
        }

        Arrays.sort(sticks);
        long median = sticks[n / 2];
        long cost = 0;

        for (int i = 0; i < n; i++) {
            cost += Math.abs(sticks[i] - median);
        }
        System.out.println(cost);
    }
}