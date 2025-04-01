import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        total = 0;
        arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            int v = sc.nextInt();
            arr[i] = v;
            total += v;
        }

        min = Integer.MAX_VALUE;
        // n개 선택
        select(0, 0, new int[n]);
        System.out.println(min);
    }

    public static void select(int idx, int st, int[] sel) {
        if (idx == n) {
            // 합의 차 갱신
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += arr[sel[i]];
            }
            min = Math.min(Math.abs(total - sum - sum), min);
            return;
        }

        for (int i = st; i < 2 * n; i++) {
            sel[idx] = i;
            select(idx+1, i+1, sel);
        }
    }

    public static int n, total, min;
    public static int[] arr;

}
