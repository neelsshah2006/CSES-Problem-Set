import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class RestaurantCustomers {

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

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();

        int n = sc.nextInt();

        List<int[]> events = new ArrayList<>(2 * n);

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt() + 1;

            events.add(new int[] { a, 1 });
            events.add(new int[] { b, -1 });
        }

        Collections.sort(events, (x, y) -> {
            if (x[0] == y[0])
                return Integer.compare(x[1], y[1]);
            return Integer.compare(x[0], y[0]);
        });

        int count = 0;
        int ans = 0;

        for (int[] e : events) {
            count += e[1];
            ans = Math.max(ans, count);
        }

        System.out.println(ans);
    }
}