import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        cnt = 0;
        arr = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    arr.add(1);
                    dfs(i, j, visited);
                    cnt++;
                }
            }
        }
        // arr 오름차순 정렬
        Integer[] sortArr = arr.toArray(new Integer[arr.size()]);
        Arrays.sort(sortArr);

        System.out.println(cnt);
        for (int i : sortArr) {
            System.out.println(i);
        }
        
        
    }

    public static List<Integer> arr;
    public static int[][] grid;
    public static int n, cnt;

    public static void dfs(int r, int c, boolean[][] visited) {
        
        int[] dr = new int[] {-1, 0, 1, 0}; // 상 우 하 좌
        int[] dc = new int[] {0, 1, 0, -1};

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
            if (!visited[nr][nc] && grid[nr][nc] != 0) {
                visited[nr][nc] = true;
                arr.set(cnt, arr.get(cnt)+1);
                dfs(nr, nc, visited);
            }
        }
    }
}