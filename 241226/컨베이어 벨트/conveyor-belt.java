import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();
        int[][] arr = new int[2][n];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        for (int i = 0; i < t; i++) {
            int temp = arr[0][n-1];
            // 윗줄 처리
            for (int j = 0; j < n-1; j++) {
                arr[0][n-j-1] = arr[0][n-j-2];
            }
            arr[0][0] = arr[1][n-1];

            // 아랫줄 처리
            for (int j = 0; j < n-1; j++) {
                arr[1][n-j-1] = arr[1][n-j-2];
            }
            arr[1][0] = temp;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}