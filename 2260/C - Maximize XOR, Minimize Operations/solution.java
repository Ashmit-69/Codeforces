import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder out = new StringBuilder();
 
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
 
            long sum = x + y;
 
            // Find the largest submask of sum that is <= x
            long finalX = 0;
 
            for (long bit = 1L << 60; bit > 0; bit >>= 1) {
                if ((sum & bit) != 0 && finalX + bit <= x) {
                    finalX += bit;
                }
            }
 
            long operations = x - finalX;
 
            out.append(sum)
               .append(' ')
               .append(operations)
               .append('
');
        }
 
        System.out.print(out);
    }
}