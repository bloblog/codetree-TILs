import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 12;

    public static int n, m, k, max;
    public static int[] nums = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        max = 0;
        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        getPerm(0, new int[n]);
        System.out.println(max);
    }

    static int getPoint(int[] sel) {
        int point = 0;
        int[] stat = new int[n];

        for (int i = 0; i < n; i++) {
            if (stat[sel[i]] == -1) continue;
            stat[sel[i]] += nums[i];
            if (stat[sel[i]] >= m-1) {
                point++;
                stat[sel[i]] = -1; // 완료 플래그
            }
        }

        return point;
    }

    static void getPerm(int idx, int[] sel) {
        if (idx == n) {
            // 해당 순서대로 말 진행시 점수 계산
            max = Math.max(max, getPoint(sel));
            return;
        }

        for (int i = 0; i < k; i++) {
            sel[idx] = i;
            getPerm(idx+1, sel);
        }
    }
}