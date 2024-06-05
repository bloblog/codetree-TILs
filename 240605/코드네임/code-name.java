import java.util.*;

class Member {
    String codeName;
    int score;

    public Member(String codeName, int score) {
        this.codeName = codeName;
        this.score = score;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Member[] arr = new Member[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = new Member(sc.next(), sc.nextInt());
        } // 인풋 받기 끝

        Arrays.sort(arr, new Comparator<Member>() {
            @Override
            public int compare(Member m1, Member m2) {
                return m1.score - m2.score;
            }
        });

        System.out.println(arr[0].codeName + " " + arr[0].score);
    }
}