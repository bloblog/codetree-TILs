import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] nums = new int[n];
        getNums(0, nums);
    }

    public static int n;

    static boolean check(int[] nums) {
        int maxGap = n / 2;
        // 한 칸 단위는 이미 체크함
        if (maxGap <= 1) return true;

        int gap = 2;
        while (gap <= maxGap) {
            for (int i = 0; i < gap; i++) {
                // 시작지점 i
                // 범위 넘어가면 break
                if (i + gap * 2 - 1 >= n) break;

                String t = ""; // 바로 앞 연속 수열
                String now = ""; // 현재 연속 수열
                for (int j = i; j < n - 1; j += gap) {
                    for (int k = 0; k < gap; k++) {
                        now += nums[j + k];
                    }
                    if (!t.equals("") && now.equals(t)) {
                        return false;
                    }
                    t = now;
                    now = "";
                }
            }
            gap++;
        }

        return true;
    }
    static void getNums(int idx, int[] nums) {
        if (idx == nums.length) {
            // 맨 처음 조건에 부합하는 수열을 출력
            if (check(nums)) {
                for (int i = 0; i < n; i++) {
                    System.out.print(nums[i]);
                }
                System.exit(0);
            }
            return;
        }

        for (int i = 4; i <= 6; i++) {
            if (idx == 0) {
                nums[idx] = i;
                getNums(idx+1, nums);
            } else {
                // 바로 앞 숫자와 같은 숫자는 못들어감
                if (nums[idx-1] != i) {
                    nums[idx] = i;
                    getNums(idx+1, nums);
                }
            }
        }
    }
}
