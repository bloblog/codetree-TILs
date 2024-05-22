import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            // 별
            for (int j = 0; j < n-i; j++) {
                System.out.print("*");
            }
            // 공백
            for (int j = 0; j < i; j += 1) {
                System.out.print("  ");
            }

            // 별
            for (int j = 0; j < n-i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}