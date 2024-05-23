import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        up(n);
        System.out.println();
        down(n);
    }

    static void up(int n) {
        if (n==0) return;

        up(n-1);
        System.out.printf("%d ", n);
    }

    static void down(int n) {
        if (n==0) return;

        System.out.printf("%d ", n);
        down(n-1);

    }
}