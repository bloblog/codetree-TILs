import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        perm(n, 0, new int[n], new boolean[n+1]);
    }
    public static void print(int[] sel) {
        for (int i = 0; i < sel.length; i++) {
            System.out.print(sel[i] + " ");
        }
        System.out.println();
    }
    public static void perm(int n, int idx, int[] sel, boolean[] visited) {
        if (idx == sel.length) {
            print(sel);
            return;
        }

        for (int i = n; i >= 1; i--) {
            if (!visited[i]) {
                sel[idx] = i;
                visited[i] = true;
                perm(n, idx+1, sel, visited);
                visited[i] = false;

            }
        }

    }
}