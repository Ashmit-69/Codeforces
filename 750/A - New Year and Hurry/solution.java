import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int k = sc.nextInt();
 
        int timeLeft = 240 - k; // Time available for solving problems
        int solved = 0;
        int timeSpent = 0;
 
        for (int i = 1; i <= n; i++) {
            timeSpent += 5 * i;
            if (timeSpent <= timeLeft) {
                solved++;
            } else {
                break;
            }
        }
 
        System.out.println(solved);
    }
}