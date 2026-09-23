import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
 
        int t = Integer.parseInt(br.readLine());
 
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
 
            if (k < n || k > 2 * n - 1) {
                out.append("-1
");
                continue;
            }
 
            int d = k - n;
            int[][] a = new int[n][n];
            boolean[] used = new boolean[n * n + 1];
 
            int val = 1;
 
            // 1 is the minimum of column 0
            a[n - 1][0] = val;
            used[val] = true;
            val++;
 
            // Put 2...(n-d) as separate row/column minima
            for (int i = 0; i < n - d - 1; i++) {
                a[i][i + 1] = val;
                used[val] = true;
                val++;
            }
 
            // Remaining row minima go into column 0
            for (int i = n - d - 1; i < n - 1; i++) {
                a[i][0] = val;
                used[val] = true;
                val++;
            }
 
            // Additional column minima
            for (int j = n - d; j < n; j++) {
                a[n - 1][j] = val;
                used[val] = true;
                val++;
            }
 
            // Fill remaining cells
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (a[i][j] == 0) {
                        while (used[val]) {
                            val++;
                        }
                        a[i][j] = val;
                        used[val] = true;
                        val++;
                    }
                }
            }
 
            // Print
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j > 0) out.append(' ');
                    out.append(a[i][j]);
                }
                out.append('
');
            }
        }
 
        System.out.print(out);
    }
}