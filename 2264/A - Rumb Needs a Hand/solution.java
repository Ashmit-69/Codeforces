import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int t = Integer.parseInt(br.readLine());
 
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
 
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] p = new int[n + 1];
 
            for (int i = 1; i <= n; i++) {
                p[i] = Integer.parseInt(st.nextToken());
            }
 
            ArrayList<Integer> idx = new ArrayList<>();
 
            // Positions that are not already correct
            for (int i = 1; i <= n; i++) {
                if (p[i] != i) {
                    idx.add(i);
                }
            }
 
            boolean possible = true;
            int m = idx.size();
 
            // The permutation on these positions must be a reversal
            for (int i = 0; i < m; i++) {
                int left = idx.get(i);
                int right = idx.get(m - 1 - i);
 
                if (p[left] != right) {
                    possible = false;
                    break;
                }
            }
 
            System.out.println(possible ? "YES" : "NO");
        }
    }
}