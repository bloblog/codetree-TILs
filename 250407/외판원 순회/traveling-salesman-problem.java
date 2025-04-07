import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        min = 987654321;
        perm(0, new int[n], new boolean[n]);
        System.out.println(min);
    }

    public static int n, min;
    public static int[][] cost;

    public static void calc(int[] sel) {
        int sum = 0;
        int row = 0;
        for (int i = 0; i < n; i++) {
            // 순회 불가한 경우 돌아가
            if (cost[row][sel[i]] == 0) return;
            sum += cost[row][sel[i]];
            row = sel[i];
        }
        min = Math.min(min, sum);
    }

    public static void perm(int idx, int[] sel, boolean[] visited) {
        
        if (idx == n-1) {
            calc(sel);
            return;
        }

        for (int i = 1; i < n; i++) {
            if (!visited[i]) {
                sel[idx] = i;
                visited[i] = true;
                perm(idx+1, sel, visited);
                visited[i] = false;
            }
        }
    }
}