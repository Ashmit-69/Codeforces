import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int t = Integer.parseInt(br.readLine().trim());
 
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
 
            // Read Bea's mountains
            st = new StringTokenizer(br.readLine());
            long a1 = Long.parseLong(st.nextToken());
 
            for (int i = 1; i < n; i++) {
                st.nextToken();
            }
 
            // Read Ver's mountains
            st = new StringTokenizer(br.readLine());
            long b1 = Long.parseLong(st.nextToken());
 
            for (int i = 1; i < m; i++) {
                st.nextToken();
            }
 
            // Attacks required to completely defeat each side
            long verNeeds = a1 + n - 1;   // attacks by Ver to defeat Bea
            long beaNeeds = b1 + m - 1;   // attacks by Bea to defeat Ver
 
            // Bea attacks first
            if (beaNeeds <= verNeeds) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
    }
}