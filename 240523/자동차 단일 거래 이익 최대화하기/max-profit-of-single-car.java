import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int answer = 0;
        int min = Integer.MAX_VALUE;
        int min_idx = -1;

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt(); // 현재 값을 최대값으로 친다

            if (val < min) {
                min = val;
                min_idx = i;
            }
            if (val - min > answer) {
                answer = val- min;
            }
        }

        System.out.println(answer);

    }
}