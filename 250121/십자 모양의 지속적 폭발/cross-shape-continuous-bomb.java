import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][n];
        int[] cols = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            cols[i] = sc.nextInt() - 1;
        } // 인풋 받기 끝

        for (int c : cols) {
            // 숫자 있는 맨 위칸 찾기
            int r = 0;
            while (r < n && arr[r][c] == 0) r++;

            // 모두 0인 경우 변화 x
            if (r == n) continue;

            int t = arr[r][c];
            // t 칸만큼 터진다
            pop(r, c, t, arr);
            // 하강
            down(c, t, arr);
        }

        // 결과 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void down(int c, int t, int[][] arr) {
        // 변화 있는 열만 체크
        for (int i = c-t+1; i < c+t; i++) {
            if (i < 0 || i >= arr.length) continue;
            int[] temp = new int[arr.length];
            int idx = arr.length-1;
            for (int r = arr.length-1; r >= 0; r--) {
                if (arr[r][i] > 0) {
                    temp[idx--] = arr[r][i];
                }
            }
            // temp -> arr 에 반영
            for (int r = arr.length-1; r >= 0; r--) {
                arr[r][i] = temp[r];
            }
        }
    }

    static void pop(int r, int c, int t, int[][] arr) {
        arr[r][c] = 0;

        int[] dr = new int[] {-1, 0, 1, 0}; // 상 우 하 좌
        int[] dc = new int[] {0, 1, 0, -1};

        for (int d = 0; d < 4; d++) {
            int nr = r;
            int nc = c;
            for (int i = 0; i < t-1; i++) {
                nr += dr[d];
                nc += dc[d];
                if (nr < 0 || nr >= arr.length || nc < 0 || nc >= arr.length) break;
                arr[nr][nc] = 0;
            }
        }
    }
}
