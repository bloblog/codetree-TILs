import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 늘어나는 부분
        for (int i = 0; i < n; i++) {
            // 공백
            for (int j = 0; j < n - i -1 ; j++) {
                System.out.print(" ");
            }
            // 별
            for (int j = 0; j < i+1 ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // 줄어드는 부분
        for (int i = n-1; i > 0; i--) {
            // 공백
            for (int j = 0; j < n - i ; j++) {
                System.out.print(" ");
            }
            // 별
            for (int j = 0; j < i ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}