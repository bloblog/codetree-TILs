import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        } // 인풋 받기 끝

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // arr 원복 위해 temp 에 복사 후 처리
                int[][] temp = new int[n][n];
                for (int r = 0; r < n; r++) {
                    temp[r] = Arrays.copyOf(arr[r], n);
                }
                pop(i, j, temp);
                down(temp);
                max = Math.max(count(temp), max);
            }
        }
        System.out.println(max);
    }

    static void down(int[][] arr) {
        for (int c = 0; c < arr.length; c++) {
            int[] temp = new int[arr.length];
            int idx = arr.length - 1;
            for (int r = arr.length - 1; r >= 0; r--) {
                if (arr[r][c] > 0) {
                    temp[idx--] = arr[r][c];
                }
            }
            // arr 에 반영
            for (int r = arr.length - 1; r >= 0; r--) {
                arr[r][c] = temp[r];
            }
        }
    }
    
    static int count(int[][] arr) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 0) continue;
                int t = arr[i][j];
                for (int d = 1; d < 3; d++) { // 우 하 만 체크
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    if (checkRange(nr, nc, arr.length)) continue;
                    if (arr[nr][nc] == t) {
                        arr[i][j] = 0;
                        arr[nr][nc] = 0;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    static int[] dr = new int[] {-1, 0, 1, 0}; // 상 우 하 좌
    static int[] dc = new int[] {0, 1, 0, -1};

    static void pop(int r, int c, int[][] arr) {
        int t = arr[r][c]; // 해당 숫자
        arr[r][c] = 0;

        for (int d = 0; d < 4; d++) {
            int nr = r;
            int nc = c;
            for (int i = 0; i < t-1; i++) {
                nr += dr[d];
                nc += dc[d];
                if (checkRange(nr, nc, arr.length)) break;
                arr[nr][nc] = 0;
            }
        }
    }

    static boolean checkRange(int r, int c, int n) {
        return r < 0 || r >= n || c < 0 || c >= n;
    }
}
