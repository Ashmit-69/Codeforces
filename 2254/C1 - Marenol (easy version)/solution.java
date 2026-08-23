import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int n = sc.nextInt();
            String a = sc.next();
            String b = sc.next();
 
            int oddA = 0, evenA = 0;
            int oddB = 0, evenB = 0;
 
            for (int i = 0; i < n; i++) {
                if (a.charAt(i) == '1') {
                    if (i % 2 == 0)
                        oddA++;
                    else
                        evenA++;
                }
 
                if (b.charAt(i) == '1') {
                    if (i % 2 == 0)
                        oddB++;
                    else
                        evenB++;
                }
            }
 
            if (oddA == oddB && evenA == evenB)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
 
        sc.close();
    }
}