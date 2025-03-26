import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        min = Integer.MAX_VALUE;
        List<Integer> coins = new ArrayList<>();
        grid = new char[N][N];

        for (int i = 0; i < N; i++) {
            grid[i] = sc.next().toCharArray();
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 'S') {
                    st = new int[] {i, j};
                } else if (grid[i][j] == 'E') {
                    ed = new int[] {i, j};
                } else if (grid[i][j] != '.') {
                    coins.add((int)grid[i][j] - 48);
                }
            }
        }

        arr = coins.toArray(new Integer[]{});
        Arrays.sort(arr);

        getCoin(0, 0, new int[3]);

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }

    }
    public static void getCoin(int idx, int st, int[] sel) {
        // 순서대로 3개 뽑는 경우의 수
        if (idx == 3) {
            move(sel);
            return;
        }

        for (int i = st; i < arr.length; i++) {
            sel[idx] = i;
            getCoin(idx+1, i+1, sel);
        }
    }

    public static void move(int[] sel) {
        // sel 순서대로 동전 수집했을 때 최소 이동횟수 구하기
        int total = 0;
        int[] p = st;
        for (int i = 0; i < 4; i++) {
            // 출발 ~ 도착 3번 반복
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[grid.length][grid.length];
            queue.add(new int[] {p[0], p[1], 0});
            visited[p[0]][p[1]] = true;
            int cnt = 0;

            while (!queue.isEmpty()) {
                int[] t = queue.poll();
                // 도착지 판별
                if (i == 3 && grid[t[0]][t[1]] == 'E') {
                    cnt = t[2];
                    break;
                }

                if (i != 3 && grid[t[0]][t[1]] - 48 == arr[sel[i]]) {
                    p = new int[] {t[0], t[1], 0};
                    cnt = t[2];
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = t[0] + dr[d];
                    int nc = t[1] + dc[d];
                    if (check(nr, nc) && !visited[nr][nc]) {
                        queue.add(new int[] {nr, nc, t[2]+1});
                        visited[nr][nc] = true;
                    }
                }
            }
            total += cnt;

        }
        min = Math.min(total, min);
    }

    public static boolean check(int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid.length;
    }

    static int[] dr = new int[] {-1, 0, 1, 0}; // 상 우 하 좌
    static int[] dc = new int[] {0, 1, 0, -1};
    static char[][] grid;
    static int[] st, ed;
    static Integer[] arr;
    static int min;
}
