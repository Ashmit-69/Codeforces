import java.io.*;
import java.util.*;
 
public class Main {
    static int[] p;
    static long ans;
    static boolean ok;
 
    static class Node {
        int min, max;
        Node(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
 
    static Node dfs(int l, int r) {
        if (!ok) return null;
 
        if (r - l == 1) {
            return new Node(p[l], p[l]);
        }
 
        int mid = (l + r) / 2;
 
        Node left = dfs(l, mid);
        Node right = dfs(mid, r);
 
        if (!ok) return null;
 
        // Left interval comes before right interval
        if (left.max + 1 == right.min) {
            return new Node(left.min, right.max);
        }
        // Need to swap the two children
        else if (right.max + 1 == left.min) {
            ans++;
            return new Node(right.min, left.max);
        }
        // Impossible
        else {
            ok = false;
            return null;
        }
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
 
        int t = Integer.parseInt(br.readLine());
 
        while (t-- > 0) {
            int m = Integer.parseInt(br.readLine());
            p = new int[m];
 
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                p[i] = Integer.parseInt(st.nextToken());
            }
 
            ans = 0;
            ok = true;
 
            dfs(0, m);
 
            if (ok) out.append(ans).append('
');
            else out.append(-1).append('
');
        }
 
        System.out.print(out);
    }
}