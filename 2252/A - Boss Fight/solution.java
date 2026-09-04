import java.io.*;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();
 
        int t = fs.nextInt();
 
        while (t-- > 0) {
            int n = fs.nextInt();
 
            Map<Integer, Integer> freq = new HashMap<>();
 
            int sum = 0;
            int maxFreq = 0;
            int maxValue = 0;
 
            int[] a = new int[n];
 
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
                sum += a[i];
 
                int count = freq.getOrDefault(a[i], 0) + 1;
                freq.put(a[i], count);
 
                if (count > maxFreq) {
                    maxFreq = count;
                    maxValue = a[i];
                }
            }
 
            int others = n - maxFreq;
 
            if (maxFreq <= others + 1) {
                // We can arrange all cards without equal adjacent cards.
                out.append(sum).append('
');
            } else {
                /*
                 * All "other" cards can be used as separators.
                 * We can safely play others + 1 copies of maxValue,
                 * and then one more copy triggers the shield.
                 */
                int answer = 0;
 
                // Add all cards except excess copies of maxValue.
                for (int x : a) {
                    if (x != maxValue) {
                        answer += x;
                    }
                }
 
                // Maximum useful copies of the most frequent value.
                int usefulMaxCopies = others + 2;
 
                answer += usefulMaxCopies * maxValue;
 
                out.append(answer).append('
');
            }
        }
 
        System.out.print(out);
    }
 
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
 
        FastScanner(InputStream in) {
            this.in = in;
        }
 
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
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
 
            int result = 0;
 
            while (c > ' ') {
                result = result * 10 + (c - '0');
                c = read();
            }
 
            return result * sign;
        }
    }
}