import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 바람 시작
        for (int i = 0; i < q; i++) {
            int r = sc.nextInt() - 1;
            String d = sc.next();

            // 1차 shift
            shift(r, d, arr);

            // 위쪽 체크 및 shift
            int ur = r;
            String nd = d;
            while (ur - 1 >= 0) {
                if (!check(ur, -1, arr)) break;
                // 바람 방향 수정
                nd = nd.equals("L") ? "R" : "L";
                shift(--ur, nd, arr);
            }

            // 아래쪽 체크 및 shift
            int dr = r;
            nd = d;
            while (dr + 1 < arr.length) {
                if (!check(dr, 1, arr)) break;
                nd = nd.equals("L") ? "R" : "L";
                shift(++dr, nd, arr);
            }
        }

        // 결과 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    static boolean check(int r, int d, int[][] arr) {
        // d 는 전파 방향 (위 -1 아래 1)
        for (int i = 0; i < arr[0].length; i++) {
            if (arr[r][i] == arr[r+d][i]) {
                return true;
            }
        }
        return false;
    }

    static void shift(int r, String d, int[][] arr) {
        int m = arr[0].length;
        if (d.equals("L")) {
            int temp = arr[r][m-1];
            for (int i = m-1; i > 0; i--) {
                arr[r][i] = arr[r][i-1];
            }
            arr[r][0] = temp;
        } else if (d.equals("R")) {
            int temp = arr[r][0];
            for (int i = 0; i < m-1; i++) {
                arr[r][i] = arr[r][i+1];
            }
            arr[r][m-1] = temp;
        }
    }
}
