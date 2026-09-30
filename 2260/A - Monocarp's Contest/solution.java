import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int n = sc.nextInt();
 
            int[] a = new int[n];
            int easy = 0;
 
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (a[i] == 0) {
                    easy++;
                }
            }
 
            // Need at least two easy problems
            if (easy < 2) {
                System.out.println(-1);
            }
            // Both already easy
            else if (a[0] == 0 && a[n - 1] == 0) {
                System.out.println(0);
            }
            // Exactly one endpoint is hard
            else if (a[0] == 0 || a[n - 1] == 0) {
                System.out.println(1);
            }
            // Both endpoints are hard
            else {
                System.out.println(2);
            }
        }
 
        sc.close();
    }
}