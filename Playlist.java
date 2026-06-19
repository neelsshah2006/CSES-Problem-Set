import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class Playlist {
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
        int[] arr = new int[n];
        HashMap<Integer, Integer> freq = new HashMap<>();
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt();
            int x = freq.getOrDefault(arr[i], 0);
            if (x == 0) {
                freq.put(arr[i], 1);
            } else {
                maxLen = Math.max(i - start, maxLen);
                while (arr[start] != arr[i]) {
                    int f = freq.get(arr[start]);
                    if (f == 1)
                        freq.remove(arr[start]);
                    else
                        freq.put(arr[start], f - 1);

                    start++;
                }
                freq.remove(arr[start]);
                start++;
                freq.put(arr[i], 1);
            }
        }
        maxLen = Math.max(n - start, maxLen);

        System.out.println(maxLen);
    }
}