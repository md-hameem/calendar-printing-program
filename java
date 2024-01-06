/*
Write pseudocode for a calendar-printing program, as follows:
Su   M   T   W   Th   F   Sa
1     2   3    4
5    6    7   8     9   10   11
12   13  14  15    16   17   18
19   20  21  22    23   24   25
26   27  28  29    30  31

*/

import java.util.Calendar;

public class CalenderPrint {
    public static void main(String[] args) {
        int targetMonth = Calendar.DECEMBER;
        int targetYear = 2023;
        printCalendar(targetMonth, targetYear);
    }

    static void printCalendar(int targetMonth, int targetYear) {
        int daysInMonth = getNumberOfDaysInMonth(targetMonth, targetYear);
        int firstDayOfWeek = getFirstDayOfWeek(targetMonth, targetYear);

        System.out.println("Su   M   T   W   Th   F   Sa");

        for (int i = 1; i < firstDayOfWeek; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%-4d", day);

            if ((day + firstDayOfWeek - 1) % 7 == 0) {
                System.out.println(); 
            }
        }
    }

    static int getNumberOfDaysInMonth(int targetMonth, int targetYear) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(targetYear, targetMonth, 1); 
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    static int getFirstDayOfWeek(int targetMonth, int targetYear) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(targetYear, targetMonth, 1); 
        return calendar.get(Calendar.DAY_OF_WEEK);
    }
}
