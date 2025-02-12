import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[n][n];
        spot = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = sc.nextInt();
                arr[i][j] = val;
                if (val == 1) spot.add(new int[] {i, j});
            }
        }

        int[] sel = new int[spot.size()]; // 폭발 방법 선택
        func(0, sel);
        System.out.println(max);
    }

    static int[][] arr;
    static List<int[]> spot;
    static int max = 0;

    static int getCnt(int[] sel) {
        int[] dr = new int[] {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dc = new int[] {0, 0, -1, 1, -1, 1, -1, 1};
        boolean[][] visited = new boolean[arr.length][arr.length];

        for (int i = 0; i < spot.size(); i++) {
            int[] t = spot.get(i);
            int nr = t[0];
            int nc = t[1];
            visited[nr][nc] = true;

            int d = sel[i];
            if (d == 0) {
                for (int j = 0; j < 4; j++) {
                    if (j == 2) {
                        nr = t[0];
                        nc = t[1];
                    }
                    nr += dr[j / 2];
                    nc += dc[j / 2];
                    if (nr < 0 || nr >= arr.length || nc < 0 || nc >= arr.length) continue;
                    visited[nr][nc] = true;
                }
            } else if (d == 1) {
                for (int j = 0; j < 4; j++) {
                    nr = t[0] + dr[j];
                    nc = t[1] + dc[j];
                    if (nr < 0 || nr >= arr.length || nc < 0 || nc >= arr.length) continue;
                    visited[nr][nc] = true;
                }
            } else {
                for (int j = 4; j < 8; j++) {
                    nr = t[0] + dr[j];
                    nc = t[1] + dc[j];
                    if (nr < 0 || nr >= arr.length || nc < 0 || nc >= arr.length) continue;
                    visited[nr][nc] = true;
                }
            }
        }
        // 카운트
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (visited[i][j]) cnt++;
            }
        }
        return cnt;
    }
    static void func(int idx, int[] sel) {
        if (idx == sel.length) {
            max = Math.max(getCnt(sel), max);
            return;
        }

        for (int i = 0; i < 3; i++) {
            sel[idx] = i;
            func(idx+1, sel);
        }
    }
}
