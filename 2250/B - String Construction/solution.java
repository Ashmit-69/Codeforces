import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
 
            // If all adjacent pairs are equal,
            // the entire string is identical.
            if (k == n - 1) {
                System.out.println(-1);
                continue;
            }
 
            int runs = n - k;
 
            // Balanced counts
            int zeros = n / 2;
            int ones = n - zeros;
 
            /*
             * Choose starting character.
             * If n and runs are both odd, start with 1,
             * because there is one more 1 than 0.
             */
            char start;
            if (n % 2 == 1 && runs % 2 == 1) {
                start = '1';
            } else {
                start = '0';
            }
 
            int zeroRuns, oneRuns;
 
            if (start == '0') {
                zeroRuns = (runs + 1) / 2;
                oneRuns = runs / 2;
            } else {
                oneRuns = (runs + 1) / 2;
                zeroRuns = runs / 2;
            }
 
            int extraZero = zeros - zeroRuns;
            int extraOne = ones - oneRuns;
 
            StringBuilder ans = new StringBuilder();
 
            for (int i = 0; i < runs; i++) {
 
                char current;
 
                if (start == '0') {
                    current = (i % 2 == 0) ? '0' : '1';
                } else {
                    current = (i % 2 == 0) ? '1' : '0';
                }
 
                ans.append(current);
 
                // Add all remaining characters to the
                // first run of that character.
                if (current == '0' && extraZero > 0) {
                    for (int j = 0; j < extraZero; j++) {
                        ans.append('0');
                    }
                    extraZero = 0;
                }
 
                if (current == '1' && extraOne > 0) {
                    for (int j = 0; j < extraOne; j++) {
                        ans.append('1');
                    }
                    extraOne = 0;
                }
            }
 
            System.out.println(ans);
        }
 
        sc.close();
    }
}