import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int LIMIT = 1000000;
 
        // Sieve of Eratosthenes
        boolean[] isPrime = new boolean[LIMIT + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
 
        for (int i = 2; i * i <= LIMIT; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= LIMIT; j += i) {
                    isPrime[j] = false;
                }
            }
        }
 
        StringBuilder sb = new StringBuilder();
 
        for (int i = 0; i < n; i++) {
            long x = Long.parseLong(st.nextToken());
 
            long root = (long) Math.sqrt(x);
 
            if (root * root == x && isPrime[(int) root]) {
                sb.append("YES
");
            } else {
                sb.append("NO
");
            }
        }
 
        System.out.print(sb.toString());
    }
}