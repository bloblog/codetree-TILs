import java.util.*;

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

        int max = 0;
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < n-1; j++) {
                // 시작점
                max = Math.max(max, getSum(i, j, arr));
            }
        }

        System.out.println(max);
    }

    static int[] dr = new int[] {-1, -1, 1, 1};
    static int[] dc = new int[] {1, -1, -1, 1};
    static int getSum(int r, int c, int[][] arr) {
        int maxSum = 0;

        // 1, 2 방향으로 전진하는 횟수
        List<int[]> move = new ArrayList<>();
        for (int i = 1; i < arr.length - c; i++) {
            // 1 방향으로 i 번 이동
            int nr = r;
            int nc = c;
            for (int j = 0; j < i; j++) {
                nr += dr[0];
                nc += dc[0];
            }
            // 2 방향으로 이동
            nr += dr[1];
            nc += dc[1];
            int cnt = 1;
            while (nr >= 0 && nc >= 0) {
                move.add(new int[] {i, cnt++});
                nr += dr[1];
                nc += dc[1];
            }
        }

        for (int[] m : move) {
            // 합 계산 및 최대값 갱신
            maxSum = Math.max(maxSum, makeMove(r, c, m, arr));
        }

        return maxSum;
    }

    static int makeMove(int r, int c, int[] move, int[][] arr) {
        // 해당 움직임에서의 합 계산
        // 유효한 움직임이 아닌 경우 -1 반환
        int sum = 0;
        int nr = r;
        int nc = c;
        for (int d = 0; d < 4; d++) {
            for (int i = 0; i < (d == 0 || d == 2 ? move[0] : move[1]); i++) {
                nr += dr[d];
                nc += dc[d];
                if (nr < 0 || nr >= arr.length || nc < 0 || nc >= arr.length) return -1;
                sum += arr[nr][nc];
            }
        }

        return sum;
    }
}
