import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int max = -1;
        // 시작점 바꿔가며 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] <= 0) continue;
                max = Math.max(max, findSquare(i, j, arr));
            }
        }
        System.out.println(max);
    }
    static int n, m;
    static int findSquare(int r, int c, int[][] arr) {
        // r, c 를 시작점으로 하는 양수 직사각형의 최대 크기 리턴
        int max = 0;

        // i, j 는 각각 사각형의 세로 가로 길이
        for (int i = n-r; i >= 1; i--) {
            for (int j = m-c; j >= 1; j--) {
                boolean flag = true;
                loop: for (int k = r; k < r+i; k++) {
                    for (int l = c; l < c+j; l++) {
                        if (arr[k][l] <= 0) {
                            flag = false;
                            break loop;
                        }
                    }
                }
                if (flag) max = Math.max(max, i * j);
            }
        }
        return max;
    }
}
