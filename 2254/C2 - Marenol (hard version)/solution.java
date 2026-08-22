import java.io.*;
import java.util.*;
 
public class Main {
 
    static class FastScanner {
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;
 
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
 
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
 
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
 
        int t = fs.nextInt();
        StringBuilder out = new StringBuilder();
 
        while (t-- > 0) {
            int n = fs.nextInt();
            String a = fs.next();
            String b = fs.next();
 
            ArrayList<Integer> aEven = new ArrayList<>();
            ArrayList<Integer> aOdd = new ArrayList<>();
            ArrayList<Integer> bEven = new ArrayList<>();
            ArrayList<Integer> bOdd = new ArrayList<>();
 
            // Use 0-based positions.
            // Position parity is equivalent to 1-based parity here,
            // just with the labels swapped.
            for (int i = 0; i < n; i++) {
                if (a.charAt(i) == '1') {
                    if (i % 2 == 0)
                        aEven.add(i);
                    else
                        aOdd.add(i);
                }
 
                if (b.charAt(i) == '1') {
                    if (i % 2 == 0)
                        bEven.add(i);
                    else
                        bOdd.add(i);
                }
            }
 
            // Different number of 1s in either parity class => impossible
            if (aEven.size() != bEven.size() ||
                aOdd.size() != bOdd.size()) {
                out.append(-1).append('
');
                continue;
            }
 
            long ans = 0;
 
            // Match 1s having even positions
            for (int i = 0; i < aEven.size(); i++) {
                ans += Math.abs(aEven.get(i) - bEven.get(i)) / 2;
            }
 
            // Match 1s having odd positions
            for (int i = 0; i < aOdd.size(); i++) {
                ans += Math.abs(aOdd.get(i) - bOdd.get(i)) / 2;
            }
 
            out.append(ans).append('
');
        }
 
        System.out.print(out);
    }
}