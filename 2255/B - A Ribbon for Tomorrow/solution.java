import java.io.*;
import java.util.*;
 
public class Main {
 
    static final long MOD = 998244353L;
    static final int MAX = 1_000_000;
 
    static long[] fact = new long[MAX + 1];
    static long[] invFact = new long[MAX + 1];
 
    static long modPow(long a, long b) {
        long res = 1;
 
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }
 
            a = a * a % MOD;
            b >>= 1;
        }
 
        return res;
    }
 
    static void init() {
        fact[0] = 1;
 
        for (int i = 1; i <= MAX; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }
 
        invFact[MAX] = modPow(fact[MAX], MOD - 2);
 
        for (int i = MAX; i >= 1; i--) {
            invFact[i - 1] = invFact[i] * i % MOD;
        }
    }
 
    static long comb(int n, int r) {
        if (r < 0 || r > n) return 0;
 
        return fact[n] * invFact[r] % MOD
                * invFact[n - r] % MOD;
    }
 
    static long solve(String s) {
        int zeroCount = 0;
        int oneCount = 0;
 
        int zeroRuns = 0;
        int oneRuns = 0;
 
        char prev = 0;
 
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
 
            if (c == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }
 
            // Start of a new run
            if (i == 0 || c != prev) {
                if (c == '0') {
                    zeroRuns++;
                } else {
                    oneRuns++;
                }
            }
 
            prev = c;
        }
 
        long zeroWays = 1;
        long oneWays = 1;
 
        if (zeroRuns > 0) {
            zeroWays = comb(zeroCount - 1, zeroRuns - 1);
        }
 
        if (oneRuns > 0) {
            oneWays = comb(oneCount - 1, oneRuns - 1);
        }
 
        return zeroWays * oneWays % MOD;
    }
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        init();
 
        int t = Integer.parseInt(br.readLine().trim());
 
        StringBuilder out = new StringBuilder();
 
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
 
            out.append(solve(s)).append('
');
        }
 
        System.out.print(out);
    }
}