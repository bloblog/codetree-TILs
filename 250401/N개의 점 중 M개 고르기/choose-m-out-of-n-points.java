import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        // 모든 점간의 유클리디안 거리 제곱
        List<Integer> dist = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                dist.add(calc(points[i], points[j]));
            }
        }

        Integer[] dArr = dist.toArray(new Integer[dist.size()]);
        Arrays.sort(dArr);
        System.out.println(dArr[m-2]);
    }

    public static int calc(int[] x, int[] y) {
        return (int)(Math.pow(x[0]-y[0], 2) + Math.pow(x[1]-y[1], 2));
    }
}
