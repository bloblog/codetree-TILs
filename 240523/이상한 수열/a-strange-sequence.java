import java.util.*;

public class Main {
    static int val;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(getNum(n));
    }

    static int getNum(int num) {

        if (num == 1) {
            return 1;
        }

        if (num == 2) {
            return 2;
        }

        return getNum(num / 3) + getNum(num-1);
    }
}