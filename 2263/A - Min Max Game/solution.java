import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int n = sc.nextInt();
            int ones = 0;
 
            for (int i = 0; i < n; i++) {
                if (sc.nextInt() == 1) {
                    ones++;
                }
            }
 
            if (ones >= n - ones) {
                System.out.println("Bessie");
            } else {
                System.out.println("Elsie");
            }
        }
 
        sc.close();
    }
}