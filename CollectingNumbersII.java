import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class CollectingNumbersII {
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
        HashMap<Integer, Integer> map = new HashMap<>();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt();
            map.put(arr[i], i);
        }

        int prev = -1;
        int[] rounds = new int[n];
        int round = 1;
        for (int i = 1; i <= n; i++) {
            int curr = map.get(i);
            if (curr < prev) {
                round++;
            }
            rounds[curr] = round;
            prev = curr;
        }

        for(int i = 0; i < m; i++) {
            int a = fs.nextInt() - 1;
            int b = fs.nextInt() - 1;
            
        }
    }
}