import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[] {sc.nextInt(), sc.nextInt()};
        }

        while (true) {
            int[] sel = new int[n--]; // 뽑을 선분 인덱스
            func(0, 0, sel);
            if (n == 0) {
                System.out.println(1);
                break;
            }
        }
    }

    static int[][] arr;
    static boolean check(int[] sel) {
        boolean[] visited = new boolean[1001];
        for (int i = 0; i < sel.length; i++) {
            int[] t = arr[sel[i]];
            for (int j = t[0]; j <= t[1]; j++) {
                if (visited[j]) return false;
                visited[j] = true;
            }
        }
        return true;
    }

    static void func(int idx, int sIdx, int[] sel) {
        if (idx == sel.length) {
            // 겹치지 않으면 정답 출력 후 종료
            if (check(sel)) {
                System.out.println(sel.length);
                System.exit(0);
            }
            return;
        }

        if (sIdx == arr.length) return;

        sel[idx] = sIdx;
        func(idx+1, sIdx+1, sel);
        func(idx, sIdx+1, sel);
    }
}
