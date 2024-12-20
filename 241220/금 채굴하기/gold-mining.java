import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] land = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                land[i][j] = sc.nextInt();
            }
        }

        // 중심 바꿔가며 계산
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // k 늘려가며 체크
                int k = 0;
                boolean flag = false; // k가 모든 영역 포괄 가능한지
                while (!flag) {
                    int fee = k * k + (k+1) * (k+1);
                    int goldCnt = getGold(k, i, j, land);
                    if (goldCnt * m - fee > 0 && max < goldCnt) {
                        max = goldCnt;
                    }
                    flag = check(++k, i, j, n);
                }
            }
        }

        System.out.println(max);
    }

    static int[] dr = {-1, 0, 1, 0}; // 상 우 하 좌
    static int[] dc = {0, 1, 0, -1};
    static int getGold(int k, int r, int c, int[][] land) {
        int cnt = 0;
        int n = land.length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        queue.add(new int[] {r, c, 0});
        visited[r][c] = true;
        if (land[r][c] == 1) cnt++;

        while(!queue.isEmpty()) {
            int[] t = queue.poll();
            if (t[2] >= k) continue;

            for (int d = 0; d < 4; d++) {
                int nr = t[0] + dr[d];
                int nc = t[1] + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new int[] {nr, nc, t[2]+1});
                    if (land[nr][nc] == 1) cnt++;
                }
            }
        }

        return cnt;
    }

    static boolean check(int k, int r, int c, int n) {
        // (0, 0) (0, n-1), (n-1, 0), (n-1, n-1) 중 가장 먼 거리 체크
        int max = Math.max(r + c, r + Math.abs(c-n+1));
        max = Math.max(max, Math.abs(r-n+1) + c);
        max = Math.max(max, Math.abs(r-n+1) + Math.abs(c-n+1));

        return max < k;
    }
}