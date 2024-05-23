import java.util.*;

public class Main {
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        cnt = 0;
        calc(n);
    }

    static void calc(int n) {
        if (n == 1) {
            System.out.println(cnt);
            return;
        }
        cnt++;
        if (n% 2 == 1) {
            calc(3*n + 1);
        } else {
            calc(n/2);
        }
    }
}