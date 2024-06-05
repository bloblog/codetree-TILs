import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[2*n];
        for (int i = 0; i < 2*n; i++) {
            arr[i] = sc.nextInt();
        } // 인풋 받기 끝

        int max = 0;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            int sum = arr[i] + arr[2*n-1-i];
            if (sum > max) max = sum;
        }

        System.out.println(max);
    }
}