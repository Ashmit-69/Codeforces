import java.io.*;
import java.util.*;
 
public class Main {
 
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
 
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
 
        long nextLong() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');
 
            long res = 0;
 
            while (c > ' ') {
                res = res * 10 + (c - '0');
                c = read();
            }
 
            return res;
        }
 
        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
 
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();
 
        int t = fs.nextInt();
 
        while (t-- > 0) {
            long S = fs.nextLong();
            int q = fs.nextInt();
 
            ArrayList<Long> divisors = new ArrayList<>();
 
            // O(sqrt(S))
            for (long d = 1; d <= S / d; d++) {
                if (S % d == 0) {
                    divisors.add(d);
 
                    if (d != S / d) {
                        divisors.add(S / d);
                    }
                }
            }
 
            Collections.sort(divisors);
 
            int n = divisors.size();
 
            long[] right = new long[n];
            long[] height = new long[n];
 
            /*
             * prefix[i] =
             * total contribution of all COMPLETE intervals before i
             * using their actual height.
             *
             * prefix[i+1] = prefix[i]
             *             + intervalLength * height[i]
             */
            long[] prefix = new long[n + 1];
 
            for (int i = 0; i < n; i++) {
                right[i] = divisors.get(i);
                height[i] = S / right[i];
 
                long previous = (i == 0 ? 0 : right[i - 1]);
                long length = right[i] - previous;
 
                prefix[i + 1] = prefix[i] + length * height[i];
            }
 
            while (q-- > 0) {
                long x = fs.nextLong();
                long y = fs.nextLong();
 
                /*
                 * We need:
                 *
                 * sum min(y, height[row])
                 *
                 * height decreases with increasing divisor.
                 *
                 * Split into:
                 *
                 * height >= y : contribution = y
                 * height < y  : contribution = height
                 */
 
                // Last interval touched by x.
                int interval = lowerBound(right, x);
 
                // First interval where height < y.
                int split = firstHeightLess(height, y);
 
                long answer;
 
                if (interval < split) {
                    /*
                     * Entire queried region lies where height >= y.
                     * Every cell in x*y is valid.
                     */
                    answer = x * y;
                } else {
                    /*
                     * First 'split' intervals contribute y.
                     *
                     * Rows covered by them:
                     * right[split - 1]
                     */
                    long fullRows = (split == 0 ? 0 : right[split - 1]);
 
                    answer = fullRows * y;
 
                    /*
                     * Actual-height contribution from complete
                     * intervals [split, interval).
                     */
                    answer += prefix[interval] - prefix[split];
 
                    /*
                     * Partial final interval.
                     */
                    long previous = (interval == 0 ? 0 : right[interval - 1]);
                    long partialLength = x - previous;
 
                    answer += partialLength * Math.min(y, height[interval]);
                }
 
                out.append(answer).append('
');
            }
        }
 
        System.out.print(out);
    }
 
    /*
     * Returns first index i such that arr[i] >= target.
     *
     * Since x <= S and last divisor is S,
     * such an index always exists.
     */
    static int lowerBound(long[] arr, long target) {
        int left = 0;
        int right = arr.length - 1;
 
        while (left < right) {
            int mid = (left + right) >>> 1;
 
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
 
        return left;
    }
 
    /*
     * height[] is decreasing.
     *
     * Find first index where height[i] < y.
     */
    static int firstHeightLess(long[] height, long y) {
        int left = 0;
        int right = height.length;
 
        while (left < right) {
            int mid = (left + right) >>> 1;
 
            if (height[mid] < y) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
 
        return left;
    }
}