import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[3000];
        int st = 1500; // 시작 지점
        String prevDir = "";

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            String dir = sc.next();

            // 시작점 조정
            if (i != 0 && prevDir.equals(dir)) {
                if (dir.equals("L")) {
                    st--;
                } else {
                    st++;
                }
            }

            for (int j = 0; j < x; j++) {
                if (dir.equals("L")) {
                    // 음의 방향
                    arr[st--]++;

                } else {
                    arr[st++]++;
                }
            }

            // 시작점 조정
            if (i != 0 && !prevDir.equals(dir)) {
                if (dir.equals("L")) st++;
                else st--;
            } else if (i == 0) {
                if (dir.equals("L")) st++;
                else st--;
            }
            prevDir = dir;
        }

        // 카운트
        int cnt = 0;
        for (int a : arr) {
            if (a > 1) cnt++;
        }
        System.out.println(cnt);
    }
}