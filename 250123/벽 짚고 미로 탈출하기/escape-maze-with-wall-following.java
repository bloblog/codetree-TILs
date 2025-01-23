import java.util.Arrays;
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

        boolean[][] visited = new boolean[n][n]; // 방문배열
        visited[x][y] = true;

        int d = 0;
        boolean flag = true; // 탈출 가능 여부
        while (!checkRange(x, y, n)) {
            int nx = x + dr[d];
            int ny = y + dc[d];
            // 이동 불가능
            if (!checkRange(nx, ny, n) && arr[nx][ny] == 1) {
                // 반시계 방향 전환
                d = (d+1) % 4;
            } else {
                if (checkRange(nx, ny, n)) {
                    // 탈출(범위 벗어남)한 경우
                    // 위치 갱신 및 이동
                    x = nx;
                    y = ny;
                } else {
                    // 다음 칸 짚을 벽 있는지 체크
                    if (checkWall(nx, ny, d, arr)) {
                        // 위치 갱신 및 이동
                        x = nx;
                        y = ny;
                        // 이동한 칸이 이미 방문한 칸이면 탈출 실패
                        if (visited[x][y]) {
                            flag = false;
                            break;
                        }
                        visited[x][y] = true;
                    } else {
                        // 이동한 칸이 이미 방문한 칸이면 탈출 실패
                        if (visited[nx][ny]) {
                            flag = false;
                            break;
                        }
                        visited[nx][ny] = true;

                        // 시계 방향 전환 및 한 칸 더 이동
                        d = d-1 < 0 ? ((Math.abs(d-1) - 1) / 4 + 1) * 4 + d-1 : d-1;
                        nx += dr[d];
                        ny += dc[d];

                        // 위치 갱신 및 이동
                        x = nx;
                        y = ny;
                        // 이동한 칸이 이미 방문한 칸이면 탈출 실패
                        if (visited[x][y]) {
                            flag = false;
                            break;
                        }
                        visited[x][y] = true;
                    }

                }
            }
        }
        if (!flag) System.out.println(-1);
        else {
            int cnt = 0;
            // 방문한 칸 개수 카운트
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
    static int[] dr = new int[] {0, -1, 0, 1}; // 우 상 좌 하
    static int[] dc = new int[] {1, 0, -1, 0}; // 우 상 좌 하
    static boolean checkWall(int r, int c, int d, int[][] arr) {
        int nr = r;
        int nc = c;
        if (d == 0) {
            // 아래에 벽이 있어야 함
            nr += dr[3];
            nc += dc[3];
            if (!checkRange(nr, nc, arr.length) && arr[nr][nc] == 1) return true;
            else return false;
        } else if (d == 1) {
            // 오른쪽에 벽이 있어야 함
            nr += dr[0];
            nc += dc[0];
            if (!checkRange(nr, nc, arr.length) && arr[nr][nc] == 1) return true;
            else return false;
        } else if (d == 2) {
            // 위에 벽이 있어야 함
            nr += dr[1];
            nc += dc[1];
            if (!checkRange(nr, nc, arr.length) && arr[nr][nc] == 1) return true;
            else return false;
        } else {
            // 왼쪽에 벽이 있어야 함
            nr += dr[2];
            nc += dc[2];
            if (!checkRange(nr, nc, arr.length) && arr[nr][nc] == 1) return true;
            else return false;
        }
    }

    static boolean checkRange(int nx, int ny, int n) {
        return nx < 0 || nx >= n || ny < 0 || ny >= n;
    }
}
