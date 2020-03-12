package Java2Assignment;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class MachineIn {
    private LocalDate dateIn;
    private int timeIn;
    public MachineIn() {

    }

    public LocalDate getDateIn() {
        return dateIn;
    }
    public int getTimeIn(){
        return timeIn;
    }
    public static LocalDate userRandomDate(int startYear, int endYear) {
        int day = IntBetween(1, 28);
        int month = IntBetween(1, 12);
        int year = IntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }

    public static int IntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }
    public static boolean sameDay(){
        int randomDay = (int)(Math.random() * (2 - 1 + 1) + 1);
        return randomDay != 2;
    }

}
