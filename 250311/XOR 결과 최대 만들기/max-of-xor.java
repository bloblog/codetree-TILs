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
        select(0, 0, visited);
        System.out.println(max);
    }

    static int n, m, max;
    static int[] arr;

    static void select(int cnt, int now, boolean[] visited) {
        if (cnt == m) {
            max = Math.max(now, max);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                select(cnt+1, now ^ arr[i], visited);
                visited[i] = false;
            }
        }
    }
}