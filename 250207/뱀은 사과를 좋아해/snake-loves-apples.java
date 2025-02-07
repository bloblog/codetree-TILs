import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 격자 크기
        int m = sc.nextInt(); // 사과 개수
        int k = sc.nextInt(); // 방향 변환 횟수

        int[][] arr = new int[n][n];
        for (int i = 0; i < m; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            arr[r][c] = 1; // 사과 표시
        }

        arr[0][0] = -1; // 뱀 방문 체크
        Deque<int[]> snake = new LinkedList<>(); // 뱀 머리 ~ 꼬리
        snake.addFirst(new int[] {0, 0});

        int t = 0;
        for (int i = 0; i < k; i++) {
            String d = sc.next();
            int p = sc.nextInt();

            int mt = move(d, p, snake, arr);
            t += mt;

            // 실제 이동 시간이 p보다 작으면 중간에 종료된 것
            if (mt < p) {
                t += 1; // 마지막 한 칸 처리
                break;
            }
        }
        System.out.println(t);
        sc.close();
    }

    static String[] dir = new String[] {"U", "D", "R", "L"};
    static int[] dr = new int[] {-1, 1, 0, 0};
    static int[] dc = new int[] {0, 0, 1, -1}; // U D R L
    static int move(String d, int p, Deque<int[]> snake, int[][] arr) {
        int t = 0;
        int idx = Arrays.asList(dir).indexOf(d);

        for (int i = 0; i < p; i++) {
            int[] head = snake.peekFirst();
            int nr = head[0] + dr[idx];
            int nc = head[1] + dc[idx];

            // 격자 벗어나면 return
            if (nr < 0 || nr >= arr.length || nc < 0 || nc >= arr.length) return t;
            // 몸 꼬이면 return
            if (arr[nr][nc] == -1) return t;

            // 다음 위치에 사과 있는 경우 제외하고 꼬리 사라짐 처리
            if (arr[nr][nc] != 1) {
                int[] tail = snake.pollLast();
                arr[tail[0]][tail[1]] = 0;
            }

            // 머리 처리
            snake.addFirst(new int[] {nr, nc});
            arr[nr][nc] = -1;

            t++;
        }
        return t;
    }
}
