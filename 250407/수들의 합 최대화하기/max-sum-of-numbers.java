import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        max = 0;
        perm(0, new int[n], new boolean[n]);
        System.out.println(max);
        
    }
    public static int n, max;
    public static int[][] grid;
    public static void getSum(int[] sel) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += grid[i][sel[i]];
        }
        max = Math.max(max, sum);
    }
    public static void perm(int idx, int[] sel, boolean[] visited) {
        if (idx == n) {
            getSum(sel);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                sel[idx] = i;
                visited[i] = true;
                perm(idx+1, sel, visited);
                visited[i] = false;
            }
        }
    }
}