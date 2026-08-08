import java.util.*;
 
public class Main {
    static int[] a;
    static int[] depth;
 
    static void build(int l, int r, int d) {
        if (l > r) return;
 
        int maxIdx = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] > a[maxIdx]) {
                maxIdx = i;
            }
        }
 
        depth[maxIdx] = d;
 
        build(l, maxIdx - 1, d + 1);
        build(maxIdx + 1, r, d + 1);
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int n = sc.nextInt();
 
            a = new int[n];
            depth = new int[n];
 
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
 
            build(0, n - 1, 0);
 
            for (int i = 0; i < n; i++) {
                System.out.print(depth[i] + " ");
            }
            System.out.println();
        }
 
        sc.close();
    }
}