import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < N - 2; j++) {
                int coin = getCoin(i, j, arr);
                if (max < coin) {
                    max = coin;
                }
            }
        }

        System.out.println(max);
    }

    static int getCoin(int r, int c, int[][] arr) {
        int total = 0;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (arr[i][j] == 1) total++;
            }
        }
        return total;
    }
}