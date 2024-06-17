import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        // 0시 0분에서 4시 1분
        int val1 = 60*c + d;

        // 0시 0분에서 2시 5분
        int val2 = 60*a + b;

        // 둘의 차
        System.out.println(val1 - val2);

    }
}