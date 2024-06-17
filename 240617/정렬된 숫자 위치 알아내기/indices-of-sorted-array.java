import java.util.*;

class Number implements Comparable<Number> {
    int idx;
    int val;

    public Number(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }

    @Override
    public int compareTo(Number n) {
        if (this.val == n.val) {
            return this.idx - n.idx;
        }
        return this.val - n.val;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        Number[] arr = new Number[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Number(i, sc.nextInt());
        }

        Arrays.sort(arr);

        int[] index = new int[n]; // 인덱스
        int[] place = new int[n]; // 이동 위치

        for (int i = 0; i < n; i++) {
            index[i] = arr[i].idx;
        }

        for (int i = 0; i < n; i++) {
            place[index[i]] = i+1;
        }
        
        // 출력
        for (int i = 0; i < n; i++) {
            System.out.print(place[i] + " ");
        }

    }
}