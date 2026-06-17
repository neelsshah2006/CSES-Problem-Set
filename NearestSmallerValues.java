import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;

public class NearestSmallerValues {
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
        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek() - 1] >= arr[i])
                stack.pop();
            if (stack.isEmpty())
                System.out.print(0 + " ");
            else
                System.out.print(stack.peek() + " ");

            stack.add(i + 1);
        }
    }
}
