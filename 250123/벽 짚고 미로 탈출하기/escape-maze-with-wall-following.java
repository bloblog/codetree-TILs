import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt()-1;
        int y = sc.nextInt()-1;

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            char[] cArr = sc.next().toCharArray();
            for (int j = 0; j < n; j++) {
                if (cArr[j] == '.') {
                    arr[i][j] = 0; // 벽 없음
                } else {
                    arr[i][j] = 1; // 벽 있음
                }
            }
        } // 인풋 받기 끝

        boolean[][][] visited = new boolean[n][n][4]; // 방문배열
        visited[x][y][0] = true;

        int d = 0;
        int cnt = 0;
        while (true) {
            int nx = x + dr[d];
            int ny = y + dc[d];

            if (!checkRange(nx, ny, n)) {
                // 범위 밖으로 나가면 탈출 성공
                cnt++;
                break;
            }

            if (visited[nx][ny][d]) {
                // 동일한 상태를 방문하면 탈출 실패
                cnt = -1;
                break;
            }

            if (arr[nx][ny] == 1) {
                // 벽이면 반시계 방향 전환
                d = (d + 1) % 4;
            } else if (checkWall(nx, ny, d, arr)) {
                // 벽이 없지만 짚을 수 있는 벽이 있으면 이동
                x = nx;
                y = ny;
                visited[x][y][d] = true;
                cnt++;
            } else {
                // 벽도 없고 짚을 벽도 없으면 시계 방향 전환 후 이동
                d = (d + 3) % 4;
                x = nx;
                y = ny;
                visited[x][y][d] = true;
                cnt++;
            }
        }

        System.out.println(cnt);

    }
    static int[] dr = new int[] {0, -1, 0, 1}; // 우 상 좌 하
    static int[] dc = new int[] {1, 0, -1, 0}; // 우 상 좌 하
    static boolean checkWall(int r, int c, int d, int[][] arr) {
        // 각 방향에 따라 벽을 확인해야 할 상대 위치
        int[] wallDr = {1, 0, -1, 0}; // 하 우 상 좌
        int[] wallDc = {0, 1, 0, -1};
        int nr = r + wallDr[d];
        int nc = c + wallDc[d];
        return checkRange(nr, nc, arr.length) && arr[nr][nc] == 1;
    }

    static boolean checkRange(int nx, int ny, int n) {
        return nx >= 0 && nx < n && ny >= 0 && ny < n;
    }
}
