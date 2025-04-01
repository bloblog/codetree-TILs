import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        // 모든 점간의 유클리디안 거리 제곱
        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int v = calc(points[i], points[j]);
                dist[i][j] = v;
                dist[j][i] = v;
            }
        }

        min = Integer.MAX_VALUE;
        // m개 선택
        select(0, 0, new int[m]);
        System.out.println(min);

    }

    public static int n, m, min;
    public static int[][] dist;

    public static void select(int idx, int st, int[] sel) {
        if (idx == m) {
            // 해당 점들을 골랐을 때 가장 먼 두 점 사이의 거리 구하기
            int max = 0;
            for (int i = 0; i < sel.length-1; i++) {
                for (int j = i+1; j < sel.length; j++) {
                    max = Math.max(dist[sel[i]][sel[j]], max);
                }
            }
            min = Math.min(min, max);
            return;
        }

        for (int i = st; i < n; i++) {
            sel[idx] = i;
            select(idx+1, i+1, sel);
        }
    }

    public static int calc(int[] x, int[] y) {
        return (int)(Math.pow(x[0]-y[0], 2) + Math.pow(x[1]-y[1], 2));
    }
}
