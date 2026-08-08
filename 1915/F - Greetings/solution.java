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
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
 
    static class Person {
        int a, b;
        Person(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
 
    static class Fenwick {
        int n;
        long[] bit;
 
        Fenwick(int n) {
            this.n = n;
            bit = new long[n + 2];
        }
 
        void add(int idx, int val) {
            while (idx <= n) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }
 
        long sum(int idx) {
            long res = 0;
            while (idx > 0) {
                res += bit[idx];
                idx -= idx & -idx;
            }
            return res;
        }
    }
 
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();
 
        int T = fs.nextInt();
 
        while (T-- > 0) {
            int n = fs.nextInt();
 
            Person[] people = new Person[n];
            int[] bs = new int[n];
 
            for (int i = 0; i < n; i++) {
                int a = fs.nextInt();
                int b = fs.nextInt();
                people[i] = new Person(a, b);
                bs[i] = b;
            }
 
            Arrays.sort(people, Comparator.comparingInt(p -> p.a));
 
            Arrays.sort(bs);
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(bs[i], i + 1);
            }
 
            Fenwick fw = new Fenwick(n);
            long ans = 0;
 
            for (int i = n - 1; i >= 0; i--) {
                int idx = map.get(people[i].b);
                ans += fw.sum(idx - 1);
                fw.add(idx, 1);
            }
 
            out.append(ans).append('
');
        }
 
        System.out.print(out);
    }
}