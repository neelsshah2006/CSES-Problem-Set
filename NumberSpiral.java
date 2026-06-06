import java.io.IOException;
import java.io.InputStream;

public class NumberSpiral {
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
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            long row = sc.nextInt();
            long col = sc.nextInt();

            long x = Math.max(row, col);
            long ans;

            if ((x & 1) == 0) {
                if (row == x) {
                    ans = x * x - col + 1;
                } else {
                    ans = (x - 1) * (x - 1) + row;
                }
            } else {
                if (col == x) {
                    ans = x * x - row + 1;
                } else {
                    ans = (x - 1) * (x - 1) + col;
                }
            }

            System.out.println(ans);
        }
    }
}
