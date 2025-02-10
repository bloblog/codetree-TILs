import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][n];
            Queue<Integer>[][] dir = new Queue[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    dir[r][c] = new LinkedList<>();
                }
            }
            String[] dirMap = new String[] {"U", "D", "R", "L"};
            for (int j = 0; j < m; j++) {
                int x = sc.nextInt()-1;
                int y = sc.nextInt()-1;
                String d = sc.next();
                arr[x][y]++;
                dir[x][y].add(Arrays.asList(dirMap).indexOf(d));
            }

            for (int time = 0; time < n*n; time++) {
//                for (int[] a : arr) {
//                    System.out.println(Arrays.toString(a));
//                }
//                System.out.println("--------");
                int[][] copyArr = new int[n][n];
                for (int k = 0; k < n; k++) copyArr[k] = Arrays.copyOf(arr[k], n);

                // 한 칸 이동
                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {
                        if (arr[r][c] == 1) {
                            int d = dir[r][c].poll();
//                            System.out.println("r = " + r + " c = " + c + " d = " + d);
                            int nr = r + dr[d];
                            int nc = c + dc[d];
                            // 벽에 부딪히면 방향 전환
                            if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                                changeDir(r, c, d, dir);
                                continue;
                            }
                            copyArr[nr][nc]++;
                            copyArr[r][c]--;
                            dir[nr][nc].add(d);
                        }
                    }
                }

                // 구슬 사라짐
                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {
                        if (copyArr[r][c] > 1) {
                            copyArr[r][c] = 0;
                            dir[r][c].clear();
                        }
                    }
                }

                // 원래 배열에 복사
                for (int k = 0; k < n; k++) arr[k] = Arrays.copyOf(copyArr[k], n);

            }

            // 남은 구슬 카운트
            int cnt = 0;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (arr[r][c] == 1) cnt++;
                }
            }
            System.out.println(cnt);
        }
    }

    static void changeDir(int r, int c, int d, Queue<Integer>[][] dir) {
        if (d == 0) dir[r][c].add(1);
        else if (d == 1) dir[r][c].add(0);
        else if (d == 2) dir[r][c].add(3);
        else if (d == 3) dir[r][c].add(2);
    }

    static int[] dr = new int[] {-1, 1, 0, 0}; // U D R L
    static int[] dc = new int[] {0, 0, 1, -1}; // U D R L
}