import java.io.*;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder out = new StringBuilder();
 
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken());
 
            String s = br.readLine().trim();
            int len = 2 * n;
 
            int redScore = 0;
            int blueScore = 0;
 
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) != '1')
                    continue;
 
                int next = (i + 1) % len;
 
                if (s.charAt(next) == '0') {
                    // Potato can be passed.
                    // It ends up on the opposite team,
                    // so the current team's score increases.
                    if (i % 2 == 0) {
                        redScore++;
                    } else {
                        blueScore++;
                    }
                } else {
                    // Potato is blocked.
                    // It remains on its current team,
                    // so the opposite team's score increases.
                    if (i % 2 == 0) {
                        blueScore++;
                    } else {
                        redScore++;
                    }
                }
            }
 
            out.append(redScore)
               .append(' ')
               .append(blueScore)
               .append('
');
        }
 
        System.out.print(out);
    }
}