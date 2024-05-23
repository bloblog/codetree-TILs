import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        printHello(n);
    }

    static void printHello(int n) {
        if (n == 0) {
            return;
        }

        System.out.println("HelloWorld");
        printHello(n-1);
    }
}