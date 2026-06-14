import java.io.IOException;
import java.io.InputStream;

public class BookShop {

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
        int x = fs.nextInt();
        int[] price = new int[n];
        int[] pages = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = fs.nextInt();
        }

        for (int i = 0; i < n; i++) {
            pages[i] = fs.nextInt();
        }

        int[] dp = new int[x + 1];
        for (int i = 0; i < n; i++) {
            for (int j = x; j >= price[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - price[i]] + pages[i]);
            }
        }

        System.out.println(dp[x]);
    }
}
