import java.io.*;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int t = Integer.parseInt(br.readLine());
 
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
 
            // Number of groups in the original string
            int groups = 1;
 
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) != s.charAt(i - 1)) {
                    groups++;
                }
            }
 
            int ans = groups;
 
            // Delete s[i], where i is neither first nor last
            for (int i = 1; i < n - 1; i++) {
 
                char left = s.charAt(i - 1);
                char cur = s.charAt(i);
                char right = s.charAt(i + 1);
 
                int newGroups = groups;
 
                // Remove boundary: left -> cur
                if (left != cur) {
                    newGroups--;
                }
 
                // Remove boundary: cur -> right
                if (cur != right) {
                    newGroups--;
                }
 
                // Add new boundary: left -> right
                if (left != right) {
                    newGroups++;
                }
 
                ans = Math.min(ans, newGroups);
            }
 
            System.out.println(ans);
        }
    }
}