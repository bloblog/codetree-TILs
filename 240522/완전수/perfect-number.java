import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int start = sc.nextInt();
        int end = sc.nextInt();
        
        int cnt = 0;
        for (int i = start; i<= end; i++) {
            if (isComp(i)) cnt++;
        }

        System.out.println(cnt);
        
    }

    static boolean isComp(int n) {
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0 && i != n) {
                if (i == n/i) {
                    sum += i;
                } else {
                    sum += i;
                    sum += n / i;
                }
            }
        }
        if (sum == n) return true;
        return false;
    }
}