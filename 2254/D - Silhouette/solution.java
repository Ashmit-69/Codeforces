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
 
            long sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
 
            long res = 0;
            while (c > ' ') {
                res = res * 10 + (c - '0');
                c = read();
            }
            return res * sign;
        }
 
        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
 
    static class Pair {
        long b;
        int idx;
 
        Pair(long b, int idx) {
            this.b = b;
            this.idx = idx;
        }
    }
 
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();
 
        int t = fs.nextInt();
 
        while (t-- > 0) {
            int n = fs.nextInt();
 
            Pair[] arr = new Pair[n];
 
            for (int i = 0; i < n; i++) {
                arr[i] = new Pair(fs.nextLong(), i);
            }
 
            Arrays.sort(arr, (p1, p2) -> {
                if (p1.b != p2.b)
                    return Long.compare(p1.b, p2.b);
                return Integer.compare(p1.idx, p2.idx);
            });
 
            long[] ans = new long[n];
 
            // Store distinct shadow values and their frequencies.
            ArrayList<Long> shadow = new ArrayList<>();
            ArrayList<Integer> cnt = new ArrayList<>();
 
            for (int i = 0; i < n; ) {
                int j = i;
                while (j < n && arr[j].b == arr[i].b) {
                    j++;
                }
 
                shadow.add(arr[i].b);
                cnt.add(j - i);
 
                i = j;
            }
 
            boolean ok = true;
 
            /*
             * The smallest shadow must always be 0.
             * There cannot be a positive value whose shadow is negative,
             * and every array has at least one minimum element with shadow 0.
             */
            if (shadow.get(0) != 0) {
                ok = false;
            }
 
            /*
             * For each group except the last:
             *
             * nextShadow - currentShadow
             *     = count * currentValue
             *
             * Thus the difference must be divisible by count.
             */
            long[] value = new long[shadow.size()];
 
            if (ok) {
                for (int g = 0; g + 1 < shadow.size(); g++) {
                    long diff = shadow.get(g + 1) - shadow.get(g);
                    int c = cnt.get(g);
 
                    if (diff <= 0 || diff % c != 0) {
                        ok = false;
                        break;
                    }
 
                    value[g] = diff / c;
 
                    if (value[g] <= 0) {
                        ok = false;
                        break;
                    }
 
                    if (g > 0 && value[g] <= value[g - 1]) {
                        ok = false;
                        break;
                    }
                }
            }
 
            /*
             * The last group's value is not determined by a later shadow.
             * To obtain the lexicographically smallest array, choose the
             * smallest positive integer strictly larger than the previous
             * group's value.
             */
            if (ok) {
                int last = shadow.size() - 1;
 
                if (last == 0) {
                    value[last] = 1;
                } else {
                    value[last] = value[last - 1] + 1;
                }
 
                if (value[last] <= 0 || value[last] > 1_000_000_000_000_000_000L) {
                    ok = false;
                }
            }
 
            /*
             * Assign the reconstructed value to every position having
             * that shadow.
             */
            if (ok) {
                int pos = 0;
 
                for (int g = 0; g < shadow.size(); g++) {
                    long v = value[g];
 
                    while (pos < n && arr[pos].b == shadow.get(g)) {
                        ans[arr[pos].idx] = v;
                        pos++;
                    }
                }
 
                /*
                 * Final verification. This is also useful for catching
                 * cases where the mathematical reconstruction cannot
                 * actually produce the supplied shadows.
                 */
                long sum = 0;
 
                for (int g = 0; g < shadow.size(); g++) {
                    if (shadow.get(g) != sum) {
                        ok = false;
                        break;
                    }
 
                    sum += (long) cnt.get(g) * value[g];
 
                    if (sum > 2_000_000_000_000_000_000L) {
                        ok = false;
                        break;
                    }
                }
            }
 
            if (!ok) {
                out.append("-1
");
            } else {
                for (int i = 0; i < n; i++) {
                    if (i > 0) out.append(' ');
                    out.append(ans[i]);
                }
                out.append('
');
            }
        }
 
        System.out.print(out);
    }
}