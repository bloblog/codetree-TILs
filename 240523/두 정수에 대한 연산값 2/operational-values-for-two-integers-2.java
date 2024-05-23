import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] answer = func(a, b);

        System.out.printf("%d %d", answer[0], answer[1]);
    }

    static int[] func(int a, int b) {
        int newA = a;
        int newB = b;
        
        if (a > b) {
            newA = a*2;
            newB = b+10;
        } else {
            newA = a + 10;
            newB = b*2;
        }

        return new int[] {newA, newB};
    }
}