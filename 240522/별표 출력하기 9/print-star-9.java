import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n= sc.nextInt();
        for (int i = 0; i < n; i++) {
            int star = 2 * i + 1;
            // 앞 공백
            for (int j = 0; j < n - i -1; j += 1) {
                System.out.print("  ") ;
            }
            // 별
            for (int j = 0; j < star; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
 
    }
}