import java.util.*;

public class Main {
    static int n;
    static int max;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        findMax(0);
    }

    static void findMax(int idx) {
        if (idx == n) {
            System.out.println(max);
            return;
        }
        if (max < arr[idx]) {
            max = arr[idx];
        }

        findMax(idx+1);
    }
}