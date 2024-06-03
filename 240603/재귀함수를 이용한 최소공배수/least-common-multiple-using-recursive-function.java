import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            arr[i] = val;
            if (max < val) max = val;
        } // 인풋 받기 끝

        // 최대값부터 시작해서 타겟 숫자 1씩 증가
        // 타겟 숫자가 모든 원소들로 나누어 떨어진다 = 최소공배수
        recur(max);   
    }

    static void recur(int n) {
        if (check(n)) {
            System.out.println(n);
            return;
        }

        recur(n+1);

    }

    static boolean check(int n) {
        for (int t : arr) {
            if (n % t != 0) return false;
        }
        return true;
    }
}