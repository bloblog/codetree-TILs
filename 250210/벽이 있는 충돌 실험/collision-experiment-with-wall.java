import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][n];
            Queue<int[]> queue = new LinkedList<>();

            String[] dirMap = new String[] {"U", "D", "R", "L"};
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken())-1;
                int y = Integer.parseInt(st.nextToken())-1;
                String d = st.nextToken();
                arr[x][y]++;
                queue.add(new int[] {x, y, Arrays.asList(dirMap).indexOf(d)});
            }

            for (int time = 0; time < n*2; time++) {
                int[][] copyArr = new int[n][n];
                for (int k = 0; k < n; k++) {
                    copyArr[k] = Arrays.copyOf(arr[k], n);
                }

                // 한 칸씩 이동
                int iter = queue.size();
                while (iter-- > 0) {
                    int[] q = queue.poll();
                    int r = q[0];
                    int c = q[1];
                    int d = q[2];

                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    // 벽에 부딪히면 방향 전환
                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                        changeDir(r, c, d, queue);
                        continue;
                    }
                    copyArr[nr][nc]++;
                    copyArr[r][c]--;
                    queue.add(new int[] {nr, nc, d});
                }

                // 구슬 사라짐
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    int[] a = queue.poll();
                    if (copyArr[a[0]][a[1]] == 1) {
                        queue.add(new int[] {a[0], a[1], a[2]});
                    }
                }

                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < n; y++) {
                        if (copyArr[x][y] > 1) copyArr[x][y] = 0;
                    }
                }


                // 원래 배열에 복사
                for (int k = 0; k < n; k++) {
                    arr[k] = Arrays.copyOf(copyArr[k], n);
                }
            }
            System.out.println(queue.size());
        }
    }

    static void changeDir(int r, int c, int d, Queue<int[]> queue) {
        if (d == 0) queue.add(new int[] {r, c, 1});
        else if (d == 1) queue.add(new int[] {r, c, 0});
        else if (d == 2) queue.add(new int[] {r, c, 3});
        else if (d == 3) queue.add(new int[] {r, c, 2});
    }

    static int[] dr = new int[] {-1, 1, 0, 0}; // U D R L
    static int[] dc = new int[] {0, 0, 1, -1}; // U D R L
}
