import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int m = sc.nextInt();
        int r = sc.nextInt()-1; int c = sc.nextInt()-1;

        int[][] arr = new int[n][n];
        // 맨 처음 주사위 상태
        // 하 상 좌 우 전 후 순서
        int[] dice = new int[] {6, 1 ,4, 3, 2, 5};

        int nr; int nc;
        arr[r][c] = dice[0];

        for (int i = 0; i < m; i++) {
            String dir = sc.next();

            // dir 정수 변환
            String[] dir_arr = {"U", "D", "L", "R"};
            int dir_num = Arrays.asList(dir_arr).indexOf(dir);

            // 다음 위치 체크
            nr = r + dr[dir_num];
            nc = c + dc[dir_num];
            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;

            // 주사위 굴리기
            roll(dir, dice);

            // arr 에 표시
            arr[nr][nc] = dice[0];

            // 위치 갱신
            r = nr;
            c = nc;
        }

        // 합 구하기
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += arr[i][j];
            }
        }
        System.out.println(sum);
    }

    static int[] dr = new int[] {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dc = new int[] {0, 0, -1, 1};

    static void roll(String dir, int[] dice) {
        // dice 순서 : 하 상 좌 우 전 후
        int temp = dice[0];
        if (dir.equals("L")) {
            dice[0] = dice[2];
            dice[2] = dice[1];
            dice[1] = dice[3];
            dice[3] = temp;
        } else if (dir.equals("R")) {
            dice[0] = dice[3];
            dice[3] = dice[1];
            dice[1] = dice[2];
            dice[2] = temp;
        } else if (dir.equals("U")) {
            dice[0] = dice[5];
            dice[5] = dice[1];
            dice[1] = dice[4];
            dice[4] = temp;
        } else {
            dice[0] = dice[4];
            dice[4] = dice[1];
            dice[1] = dice[5];
            dice[5] = temp;
        }
    }
}