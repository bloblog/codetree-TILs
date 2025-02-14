import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[] selRow = new int[2]; // 도둑이 선택할 행
        selectRow(0, 0, selRow);
        System.out.println(max);
    }
    static int n, m, c, max;
    static int[][] arr;

    static void calc(int[] selRow, int[][] selCol) {
        int[][] valArr = new int[2][m];
        for (int idx = 0; idx < 2; idx++) {
            int col = 0;
            for (int c = selCol[idx][0]; c <= selCol[idx][1]; c++) {
                valArr[idx][col++] = arr[selRow[idx]][c];
            }
        }

        // 최대 무게 고려하여 무게 계산
        int val1 = getMax(valArr[0]);
        int val2 = getMax(valArr[1]);
        // 최대값 갱신
        max = Math.max(max, val1 + val2);
    }

    static int getMax(int[] val) {
        int weight = 0;
        int value = 0;

        Arrays.sort(val);
        for (int i = val.length - 1; i >= 0; i--) {
            if (weight + val[i] <= c) {
                weight += val[i];
                value += val[i] * val[i];
            }
        }

        return value;
    }
    static void selectCol(boolean flag, int[] selRow) {
        // 열 시작 지점 ~ 끝 지점
        int[][] selCol = new int[2][2];

        if (flag) {
            // 두 도둑이 같은 행 선택
            for (int i = 0; i <= n - m * 2; i++) {
                // 첫번째 도둑
                selCol[0][0] = i;
                selCol[0][1] = i + m - 1;
                for (int j = i + m; j <= n - m; j++) {
                    // 두번째 도둑
                    selCol[1][0] = j;
                    selCol[1][1] = j + m - 1;
                    calc(selRow, selCol);
                }
            }
        } else {
            for (int i = 0; i <= n - m; i++) {
                // 첫번째 도둑
                selCol[0][0] = i;
                selCol[0][1] = i + m - 1;
                for (int j = 0; j <= n - m; j++) {
                    // 두번째 도둑
                    selCol[1][0] = j;
                    selCol[1][1] = j + m - 1;
                    calc(selRow, selCol);
                }
            }
        }

    }

    static void selectRow(int idx, int sIdx, int[] sel) {
        if (idx == 2) {
            // 같은 행 선택시 중복 고려하기
            selectCol(sel[0] == sel[1], sel);
            return;
        }

        if (sIdx == n) return;

        sel[idx] = sIdx;
        selectRow(idx+1, sIdx, sel);
        selectRow(idx, sIdx+1, sel);
    }
}
