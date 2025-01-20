import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        String dir = sc.next();
        // 입력 끝

        // 위, 아래인 경우 (열별로 판단)
        if (dir.equals("U") || dir.equals("D")) {
            for (int c = 0; c < 4; c++) {
                int[] col = new int[4];
                for (int r = 0; r < 4; r++) {
                    col[r] = arr[r][c];
                }
                int[] res = push(col, dir);

                // arr 에 반영
                for (int r = 0; r < 4; r++) {
                    arr[r][c] = res[r];
                }
            }
        }

        // 오른쪽, 왼쪽인 경우 (행별로 판단)
        else {
            for (int r = 0; r < 4; r++) {
                int[] res = push(arr[r], dir);

                // arr 에 반영
                arr[r] = res;

            }
        }

        // 결과 출력
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[] push(int[] arr, String dir) {
        int[] temp = new int[arr.length];

        // 왼 or 위
        if (dir.equals("L") || dir.equals("U")) {
            // 0 처리
            int temp_idx = 0;
            for (int i = 0; i < 4; i++) {
                if (arr[i] != 0) {
                    temp[temp_idx++] = arr[i];
                }
            }

            temp_idx = 0;
            int idx = 0;
            while (idx < 4 && temp[idx] > 0) {
                if (idx+1 < 4 && temp[idx] == temp[idx+1]) {
                    temp[temp_idx++] = temp[idx++] * 2;
                    idx++;
                } else {
                    temp[temp_idx++] = temp[idx++];
                }
            }
            // 나머지는 0으로 채워
            for (int i = temp_idx; i < 4; i++) {
                temp[i] = 0;
            }
        }

        // 오른 or 아래
        else if (dir.equals("R") || dir.equals("D")) {
            // 0 처리
            int temp_idx = 3;
            for (int i = 3; i >= 0; i--) {
                if (arr[i] != 0) {
                    temp[temp_idx--] = arr[i];
                }
            }

            temp_idx = 3;
            int idx = 3;
            while (idx >= 0 && temp[idx] > 0) {
                if (idx-1 >= 0 && temp[idx] == temp[idx-1]) {
                    temp[temp_idx--] = temp[idx--] * 2;
                    idx--;
                } else {
                    temp[temp_idx--] = temp[idx--];
                }
            }
            // 나머지는 0으로 채워
            for (int i = temp_idx; i >= 0; i--) {
                temp[i] = 0;
            }
        }

//        System.out.println("temp = " + Arrays.toString(temp));
        return temp;
    }
}
