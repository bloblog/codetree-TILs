import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        // ㄴ 모양
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m-1; j++) {
                int val = getTotal1(i, j, board);
                if (val > max) max = val;
            }
        }

        // 일자 모양 (가로)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m-2; j++) {
                boolean isVertical = false;
                int val = getTotal2(isVertical, i, j, board);
                if (val > max) max = val;
            }
        }   

        // 일자 모양 (세로)
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < m; j++) {
                boolean isVertical = true;
                int val = getTotal2(isVertical, i, j, board);
                if (val > max) max = val;
            }
        }        

        System.out.println(max);
    }

    static int getTotal1(int r, int c, int[][] board) {
        int total = 0;
        for (int i = r; i < r+2; i++) {
            for (int j = c; j < c+2; j++) {
                total += board[i][j];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = r; i < r+2; i++) {
            for (int j = c; j < c+2; j++) {
                if (board[i][j] < min) min = board[i][j];
            }
        }
        return total - min;
    }

    static int getTotal2(boolean isVertical, int r, int c, int[][] board) {
        int total = 0;

        if (!isVertical) {
            for (int i = c; i < c + 3; i++) {
                total += board[r][i];
            }    
        } else {
            for (int i = r; i < r + 3; i++) {
                total += board[i][c];
            } 
        }

        return total;
    }
}