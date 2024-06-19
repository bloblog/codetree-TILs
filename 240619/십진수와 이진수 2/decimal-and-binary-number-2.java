import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char[] arr = str.toCharArray();

        int num = 0;
        for (char a : arr) {
            int t = Integer.parseInt(String.valueOf(a));
            num = 2 * num + t;
        }

        int target = num * 17;
        Stack<Integer> stack = new Stack<>();
        while (target > 1) {
            stack.add(target % 2);
            target = target / 2;
        }

        stack.add(1);

        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }

    }
}