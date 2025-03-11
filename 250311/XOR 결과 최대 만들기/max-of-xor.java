import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        max = 0;
        boolean[] visited = new boolean[n];
        select(0, 0, 0);
        System.out.println(max);
    }

    static int n, m, max;
    static int[] arr;

    static void select(int idx, int cnt, int now) {
        if (cnt == m) {
            max = Math.max(now, max);
            return;
        }

        if (idx == n) return;

        // 선택 x
        select(idx+1, cnt, now);
        // 선택 o
        select(idx+1, cnt+1, now ^ arr[idx]);
    }
}