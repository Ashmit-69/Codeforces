import java.io.*;
import java.util.*;
 
public class Main {
 
    static final long MOD = 998244353L;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int t = Integer.parseInt(br.readLine());
 
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
 
            long oddWays = countWays(s, 0);
            long evenWays = countWays(s, 1);
 
            System.out.println((oddWays * evenWays) % MOD);
        }
    }
 
    // Checks one parity:
    // start = 0 means this parity is 0,1,0,1,...
    // start = 1 means this parity is 1,0,1,0,...
    static long countWays(String s, int parity) {
        int ways = 0;
 
        for (int start = 0; start <= 1; start++) {
            boolean possible = true;
 
            for (int i = parity; i < s.length(); i += 2) {
                int expected = start ^ ((i - parity) / 2 & 1);
 
                if (s.charAt(i) != '?' &&
                    s.charAt(i) - '0' != expected) {
                    possible = false;
                    break;
                }
            }
 
            if (possible) {
                ways++;
            }
        }
 
        return ways;
    }
}