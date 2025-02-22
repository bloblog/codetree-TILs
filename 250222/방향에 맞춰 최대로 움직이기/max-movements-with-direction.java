import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = new int[n][n];
        dirs = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dirs[i][j] = sc.nextInt()-1;
            }
        }

        int r = sc.nextInt()-1;
        int c = sc.nextInt()-1;
        bfs(r, c);

    }

    public static int n, max;
    public static int[][] nums;
    public static int[][] dirs;

    static void bfs(int r, int c) {
        max = 0;
        Queue<int[]> queue = new LinkedList<>(); // 위치 r, c, 움직인 횟수
        queue.add(new int[] {r, c, 0});

        while (!queue.isEmpty()) {
            int[] t = queue.poll();
            int i = t[0];
            int j = t[1];
            int cnt = t[2];
            max = Math.max(max, cnt);

            int[] next = move(dirs[i][j], i, j);
            int nr = next[0];
            int nc = next[1];
            while (rangeCheck(nr, nc)) {
                if (nums[nr][nc] > nums[i][j]) {
                    queue.add(new int[] {nr, nc, cnt + 1});
                }
                next = move(dirs[i][j], nr, nc);
                nr = next[0];
                nc = next[1];
            }
        }
        System.out.println(max);
    }

    static boolean rangeCheck(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    static int[] move(int type, int r, int c) {
        // r, c 에서 type 에 맞게 한 칸 이동 후 nr, nc 반환
        int[] dr = new int[] {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dc = new int[] {0, 1, 1, 1, 0, -1, -1, -1};
        return new int[] {r + dr[type], c + dc[type]};
    }
}
