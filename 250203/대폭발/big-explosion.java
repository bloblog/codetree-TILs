import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt()-1; int c = sc.nextInt()-1;

        boolean[][] arr = new boolean[n][n];
        int cnt = bomb(r, c, m, arr);

        System.out.println(cnt);
    }

    static int[] dr = new int[] {-1, 0, 1, 0};
    static int[] dc = new int[] {0, 1, 0, -1}; // 상 우 하 좌
    static int bomb(int r, int c, int m, boolean[][] arr) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});
        arr[r][c] = true; // 초기 위치 세팅
        int cnt = 1;

        int t = 1;
        while (t <= m) {
            int size = queue.size();
            while (size-- > 0) {
                int[] pos = queue.poll();
                int dist = (int)Math.pow(2, t-1);

                for (int d = 0; d < 4; d++) {
                    int nr = pos[0] + dr[d] * dist;
                    int nc = pos[1] + dc[d] * dist;
                    if (nr < 0 || nr >= arr.length || nc < 0 || nc >= arr.length) continue;

                    queue.add(new int[] {nr, nc});
                    if (!arr[nr][nc]) {
                        arr[nr][nc] = true;
                        cnt++;
                    }
                }
                queue.add(pos);
            }
            t++;
        }
        return cnt;
    }
}
