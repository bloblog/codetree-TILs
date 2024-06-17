import java.util.*;

class Student implements Comparable<Student> {
    String name;
    int class1;
    int class2;
    int class3;

    public Student(String name, int class1, int class2, int class3) {
        this.name = name;
        this.class1 = class1;
        this.class2 = class2;
        this.class3 = class3;
    }

    public int getSum(Student s) {
        return s.class1 + s.class2 + s.class3;
    }

    @Override
    public int compareTo(Student s) {
        return getSum(this) - getSum(s);
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Student[] arr = new Student[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i].name + " " + arr[i].class1 + " " + arr[i].class2 + " " + arr[i].class3);
            System.out.println();
        }

    }
}