import java.io.*;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int t = Integer.parseInt(br.readLine());
 
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
 
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            int odd = 0;
            int even0 = 0; // a % 4 == 0
            int even2 = 0; // a % 4 == 2
 
            for (int i = 0; i < n; i++) {
                long x = Long.parseLong(st.nextToken());
 
                if (x % 2 == 1) {
                    odd++;
                } else if (x % 4 == 0) {
                    even0++;
                } else {
                    even2++;
                }
            }
 
            System.out.println(Math.max(odd, Math.max(even0, even2)));
        }
    }
}