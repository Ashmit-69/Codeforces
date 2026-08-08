import java.io.*;
import java.util.*;
 
public class Main {
    static String s;
 
    static int solve(int l, int r, char c) {
        if (l == r) {
            return s.charAt(l) == c ? 0 : 1;
        }
 
        int mid = (l + r) / 2;
 
        int leftMismatch = 0;
        for (int i = l; i <= mid; i++) {
            if (s.charAt(i) != c) leftMismatch++;
        }
 
        int rightMismatch = 0;
        for (int i = mid + 1; i <= r; i++) {
            if (s.charAt(i) != c) rightMismatch++;
        }
 
        int option1 = leftMismatch + solve(mid + 1, r, (char) (c + 1));
        int option2 = rightMismatch + solve(l, mid, (char) (c + 1));
 
        return Math.min(option1, option2);
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int t = Integer.parseInt(br.readLine());
 
        StringBuilder ans = new StringBuilder();
 
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            s = br.readLine();
 
            ans.append(solve(0, n - 1, 'a')).append('
');
        }
 
        System.out.print(ans);
    }
}