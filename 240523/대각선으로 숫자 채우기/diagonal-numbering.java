import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        
        int r = 0;
        int c = 0;
        int next_col = 1;
        int next_row = 1;
        for (int i = 1; i <= n*m; i++) {
            arr[r][c] = i;

            if (r+1 >= n || c-1 < 0) {
                r = 0;
                c = next_col++;

                if (c >= m) {
                    r = next_row++;
                    c = m-1;
                }
                
            } else {
                r++;
                c--;
            }

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}