import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        max = 0;
        boolean[] visited = new boolean[n];
        select(0, 0, visited);
        System.out.println(max);
    }

    static int n, m, max;
    static int[] arr;

    static void select(int cnt, int now, boolean[] visited) {
        if (cnt == m) {
            max = Math.max(now, max);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                select(cnt+1, xor(now, arr[i]), visited);
                visited[i] = false;
            }
        }
    }

    static int xor(int a, int b) {
        char[] binA = Integer.toBinaryString(a).toCharArray();
        char[] binB = Integer.toBinaryString(b).toCharArray();

        int max_len = Math.max(binA.length, binB.length);
        int min_len = Math.min(binA.length, binB.length);

        // 결과는 역순으로 넣는다
        int[] bin = new int[max_len];
        for (int i = 0; i < min_len; i++) {
            // 끝에서부터 계산
            if (binA[binA.length - 1 - i] == binB[binB.length - 1 - i]) {
                bin[i] = 0;
            } else {
                bin[i] = 1;
            }
        }

        // 길이 안 맞을 경우 계산
        if (max_len != min_len) {
            char[] t = binA;
            if (max_len == binB.length) t = binB;
            for (int i = max_len - min_len - 1; i >= 0; i--) {
                if (t[i] == '1') bin[max_len - 1 - i] = 1;
                else bin[max_len - 1 - i] = 0;
            }
        }

        // 2진수 10진수로 변환
        int res = 0;
        for (int i = 0; i < max_len; i++) {
            res += bin[i] * Math.pow(2, i);
        }

        return res;
    }
}
