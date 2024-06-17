import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        int[] days = new int[] {0, 31,28,31,30,31,30,31,31,30,31,30,31};

        // 1월 1일에서 m2월 d2일까지 몇일?
        int day1 = 0;
        for (int i = 1; i < m2; i++) {
            day1 += days[i];
        }
        day1 += d2;

        // 1월 1일에서 m1월 d1일까지 몇일?
        int day2 = 0;
        for (int i = 1; i < m1; i++) {
            day2 += days[i];
        }
        day2 += d1;

        // 둘 사이 기간
        int gap = day1 - day2;

        // 7로 나눠서 요일 구하기
        // 나머지 0이면 Mon
        String[] wod = new String[] {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        if (gap > 0) {
            System.out.println(wod[gap%7]);
        } else {
            if (gap % 7 == 0) {
                System.out.println(wod[gap%7]);
            } else {
                System.out.println(wod[gap%7 + 7]);
            }
        }

    }
}