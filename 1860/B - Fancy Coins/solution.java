import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
 
        StringBuilder out = new StringBuilder();
 
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            long m = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            long a1 = Long.parseLong(st.nextToken());
            long ak = Long.parseLong(st.nextToken());
 
            long ans = 0;
 
            long rem = m % k;
 
            // Pay the remainder using regular/fancy 1-value coins
            if (a1 >= rem) {
                a1 -= rem;
            } else {
                ans += rem - a1;
                a1 = 0;
            }
 
            m -= rem;
 
            // Use remaining regular 1-value coins in groups of k
            m -= (a1 / k) * k;
 
            // Use regular k-value coins
            m -= ak * k;
 
            // Remaining amount must be paid using fancy k-value coins
            if (m > 0) {
                ans += m / k;
            }
 
            out.append(ans).append('
');
        }
 
        System.out.print(out);
    }
}