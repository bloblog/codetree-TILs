import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int new_end = n;
        while (true) {
            int t = arr[0];
            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == t) {
                    cnt++;
                    // 마지막 숫자도 포함해서 체크
                    if (i == arr.length-1 && cnt >= m) {
                        for (int j = 0; j < cnt; j++) {
                            arr[i-j] = -1; // 방문체크
                        }
                        new_end -= cnt;
                    }
                } else {
                    if (cnt >= m) {
                        for (int j = 0; j < cnt; j++) {
                            arr[i-1-j] = -1; // 방문체크
                        }
                        new_end -= cnt;
                    }
                    cnt = 1;
                    t = arr[i];
                }
            }

            // 터지는 게 없을 경우
            if (new_end == arr.length) {
                break;
            }

            // 배열 재조정
            int[] new_arr = new int[new_end];

            // 다 터진 경우
            if (new_end == 0) {
                arr = new int[] {};
                break;
            } else {
                int idx = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] != -1) {
                        new_arr[idx++] = arr[i];
                    }
                }
            }
            arr = Arrays.copyOf(new_arr, new_end);
        }
        
        // 결과 출력
        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
