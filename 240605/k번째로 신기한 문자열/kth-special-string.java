import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        String t = sc.next();
        int len = t.length();
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            if (str.length() >= len && str.substring(0, len).equals(t)) {
                arr.add(str);
            }
        } // 문자열 t로 시작하는 단어만 필터링

        // ArrayList를 배열로 변환        
        int size = arr.size();        
        String newArr[] = arr.toArray(new String[size]);

        Arrays.sort(newArr);
        System.out.println(newArr[k-1]);

    }
}