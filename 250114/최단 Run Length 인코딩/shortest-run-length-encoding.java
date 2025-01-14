import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        int len = a.length();
        char[] arr = a.toCharArray();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            // 인코딩
            String str = encode(arr);
            // 길이 최소값 갱신
            if (str.length() < min) min = str.length();
            // shift
            shift(arr);
        }

        System.out.println(min);
    }

    static String encode(char[] arr) {
        String str = "";
        char t = arr[0];
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            if (t != arr[i]) {
                str += t + String.valueOf(cnt);
                // 초기화
                cnt = 1;
                t = arr[i];
            } else {
                cnt++;
            }
        }

        // 끝 글자도 처리
        str += t + String.valueOf(cnt);

        return str;
    }

    static void shift(char[] arr) {
        char temp = arr[arr.length-1];
        for (int i = arr.length-1; i > 0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
    }
}
