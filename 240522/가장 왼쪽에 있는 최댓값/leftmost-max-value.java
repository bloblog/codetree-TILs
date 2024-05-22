import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n+1];

        for (int i = 1; i < n + 1; i++) {
            arr[i] = sc.nextInt();
        }

        int idx = n;
        while (idx > 0) {
            int max = -1;
            int tempIdx = -1;
            for (int i = 1; i <= idx; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    tempIdx = i;
                }
            }
            System.out.print(tempIdx + " ");
            idx = tempIdx - 1;
        }

    }
}