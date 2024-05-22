import java.util.*;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

       int n = sc.nextInt();
       for (int i = n; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                String text = "";
                for (int t = 0; t < i; t++) {
                    text += "*";

                }
                System.out.print(text + " ");
            }
           System.out.println(); 
       }
    }
}