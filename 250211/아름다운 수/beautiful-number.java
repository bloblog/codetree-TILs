import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        getNum(0, arr);
        System.out.println(cnt);
    }
    static int cnt = 0;
    static void getNum(int idx, int[] arr) {
        if (idx == arr.length) {
//            System.out.println(Arrays.toString(arr));
            if (check(arr)) cnt++;
            return;
        }

        for (int i = 1; i <= 4; i++) {
            arr[idx] = i;
            getNum(idx+1, arr);
        }
    }

    static boolean check(int[] arr) {
        int t = arr[0];
        int cnt = 1;
        for (int i = 1; i < arr.length; i++) {
            if (cnt == t) {
                // 초기화
                t = arr[i];
                cnt = 1;
            } else {
                if (t == arr[i]) cnt++;
                else {
                    return false;
                }
            }
        }
        if (t != cnt) return false;
        return true;
    }
}
