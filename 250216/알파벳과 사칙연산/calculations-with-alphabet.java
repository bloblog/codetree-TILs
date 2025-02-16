import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] arr = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                map.put(arr[i], 0);
            }
        }
        // 각 알파벳에 부여할 숫자 배열 만들기
        List<int[]> arrList = new ArrayList<>();
        int[] sel = new int[map.size()];
        getNum(0, sel, arrList);

        int max = 0;
        Character[] keySet = map.keySet().toArray(new Character[] {});
        for (int[] a : arrList) {
            for (int i = 0; i < map.size(); i++) {
                char t = keySet[i];
                map.replace(t, a[i]);
            }
            // 해당 숫자대로 계산 후 최대값 갱신
            max = Math.max(max, calc(arr, map));
        }
        System.out.println(max);
    }

    static int calc(char[] arr, Map<Character, Integer> map) {
        int val = map.get(arr[0]);
        if (arr.length == 1) return val;

        char op = arr[1];
        for (int i = 2; i < arr.length; i++) {
            if (i % 2 == 0) {
                // 숫자인 경우 연산자로 연산
                int num = map.get(arr[i]);
                if (op == '+') {
                    val += num;
                } else if (op == '-') {
                    val -= num;
                } else {
                    val *= num;
                }
            } else {
                // 연산자
                op = arr[i];
            }
        }
        return val;
    }

    static void getNum(int idx, int[] sel, List<int[]> arrList) {
        if (idx == sel.length) {
            arrList.add(Arrays.copyOf(sel, sel.length));
            return;
        }

        for (int i = 1; i <= 4; i++) {
            sel[idx] = i;
            getNum(idx+1, sel, arrList);
        }
    }
}
