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
        }
        int r = sc.nextInt()-1;
        int c = sc.nextInt()-1;
        // 인풋 받기 끝

        int t = arr[r][c]; // 선택된 숫자

        // 상우하좌 델타값
        int[] dr = new int[] {-1, 0, 1, 0};
        int[] dc = new int[] {0, 1, 0, -1};

        // 터진 위치 체크
        arr[r][c] = 0;
        for (int d = 0; d < 4; d++) {
            int nr = r;
            int nc = c;
            for (int i = 0; i < t-1; i++) {
                nr += dr[d];
                nc += dc[d];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) break;
                arr[nr][nc] = 0;
            }
        }

        // 하강
        for (int i = 0; i < n; i++) {
            int[] temp = new int[n];
            int idx = n-1;
            for (int j = n-1; j >= 0; j--) {
                if (arr[j][i] != 0) {
                    temp[idx--] = arr[j][i];
                }
            }
            // copy
            for (int j = 0; j < n; j++) {
                arr[j][i] = temp[j];
            }
        }

        // 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
