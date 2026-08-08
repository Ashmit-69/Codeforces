import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int n = sc.nextInt();
 
            long maxEven = Long.MIN_VALUE;
            long minOdd = Long.MAX_VALUE;
 
            for (int i = 1; i <= n; i++) {
                long w = sc.nextLong();
 
                if (i % 2 == 1) {
                    // Odd position -> must move right
                    minOdd = Math.min(minOdd, w);
                } else {
                    // Even position -> must move left
                    maxEven = Math.max(maxEven, w);
                }
            }
 
            // n must be even, and we need:
            // maxEven < k < minOdd
            if (n % 2 == 0 && maxEven + 1 < minOdd) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
 
        sc.close();
    }
}