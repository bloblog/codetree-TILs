import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        String n = sc.next();

        // n을 십진수로 바꿔
        int num = 0;
        for (int i = 0; i < n.length(); i++) {
            int t = Integer.parseInt(String.valueOf(n.charAt(i)));
            num = a * num + t;
        }

        // num을 b진수로 바꿔
        Stack<Integer> stack = new Stack<>();
        while (num > 1) {
            stack.add(num % b);
            num = num / b;
        }

        stack.add(1);

        // 출력
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}