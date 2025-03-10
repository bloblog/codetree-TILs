import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int MAX = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        for (int i = 0; i < n-1; i++) {
            int max = arr[i];
            for (int j = i+1; j <= Math.min(i+max, n-1); j++) {
                dp[j] = Math.min(dp[j], dp[i]+1);
            }
        }
        if (dp[n-1] == MAX) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n-1]);
        }
    }
}
