import java.io.IOException;
import java.io.InputStream;
import java.util.TreeMap;

public class Towers {
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
        TreeMap<Integer, Integer> towers = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int x = fs.nextInt();
            Integer higher = towers.higherKey(x);
            if (higher != null) {
                int count = towers.get(higher);
                if (count == 1)
                    towers.remove(higher);
                else
                    towers.put(higher, count - 1);
            }
            towers.put(x, towers.getOrDefault(x, 0) + 1);
        }

        int ans = 0;
        for (int freq : towers.values())
            ans += freq;
        System.out.println(ans);
    }
}
