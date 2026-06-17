import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class SubarraySumsII {
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
        int target = fs.nextInt();
        HashMap<Long, Long> map = new HashMap<>();
        long sum = 0;
        long count = 0;
        map.put(0l, 1l);
        for (int i = 0; i < n; i++) {
            sum += fs.nextInt();
            if (map.containsKey(sum - target)) {
                count += map.get(sum - target);
            }
            map.put(sum, map.getOrDefault(sum, 0l) + 1);
        }

        System.out.println(count);
    }
}
