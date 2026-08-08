import java.io.*;
import java.util.*;
 
public class Main {
 
    static int[] nums = {4, 8, 15, 16, 23, 42};
    static boolean[] used = new boolean[6];
    static int[] perm = new int[6];
    static long[] prod = new long[4];
    static PrintWriter out = new PrintWriter(System.out, true);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    static boolean found = false;
 
    static void generate(int idx) {
        if (found) return;
 
        if (idx == 6) {
            if ((long) perm[0] * perm[1] == prod[0] &&
                (long) perm[1] * perm[2] == prod[1] &&
                (long) perm[2] * perm[3] == prod[2] &&
                (long) perm[3] * perm[4] == prod[3]) {
 
                out.print("! ");
                for (int i = 0; i < 6; i++) {
                    out.print(perm[i] + " ");
                }
                out.println();
                out.flush();
                found = true;
            }
            return;
        }
 
        for (int i = 0; i < 6; i++) {
            if (!used[i]) {
                used[i] = true;
                perm[idx] = nums[i];
                generate(idx + 1);
                used[i] = false;
            }
        }
    }
 
    public static void main(String[] args) throws Exception {
 
        int[][] queries = {
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5}
        };
 
        for (int i = 0; i < 4; i++) {
            out.println("? " + queries[i][0] + " " + queries[i][1]);
            out.flush();
            prod[i] = Long.parseLong(br.readLine());
        }
 
        generate(0);
    }
}