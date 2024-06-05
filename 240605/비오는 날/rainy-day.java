import java.util.*;

class Weather {
    int year;
    int month;
    int day;
    String dateStr;
    String dow;
    String condition;

    public Weather(int year, int month, int day, String dateStr, String dow, String condition) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.dateStr = dateStr;
        this.dow = dow;
        this.condition = condition;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Weather> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String date = sc.next();
            String[] dateList = date.split("-");
            Weather w = new Weather(Integer.parseInt(dateList[0]), Integer.parseInt(dateList[1]), Integer.parseInt(dateList[2]), date, sc.next(), sc.next());
            if (w.condition.equals("Rain")) {
                arr.add(w);
            }
        }

        Weather[] newArr = arr.toArray(new Weather[arr.size()]);

        Arrays.sort(newArr, new Comparator<Weather>() {
            @Override
            public int compare(Weather w1, Weather w2) {
                if (w1.year == w2.year) {
                    if (w1.month == w2.month) {
                        return w1.day - w2.day;
                    }
                    return w1.month - w2.month;
                }
                return w1.year - w2.year;
            }
        });

        System.out.printf("%s %s %s", newArr[0].dateStr, newArr[0].dow, newArr[0].condition);

    }
}