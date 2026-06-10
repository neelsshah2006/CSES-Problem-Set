import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class FerrisWheel {
    static class FastScanner {
        private final InputStream in = System.in;
        private byte[] buffer = new byte[1 << 16];
        private int len = 0, ptr = 0;

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
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = fs.nextInt();
        }

        Arrays.sort(weights);
        int i = 0;
        int j = n - 1;
        int ferris = 0;
        while (i <= j) {
            long sum = (long) weights[i] + weights[j];
            if (sum <= x) {
                i++;
                j--;
            } else {
                j--;
            }
            ferris++;
        }
        System.out.println(ferris);
    }
}