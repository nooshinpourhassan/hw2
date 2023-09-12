package ui;

import java.time.LocalDate;
import java.time.Month;

public class Date {
   public static LocalDate currentDate = LocalDate.of(2028,02,27);
    LocalDate startNovember = LocalDate.of(currentDate.getYear(), Month.NOVEMBER, 1);
    LocalDate endNovember = startNovember.plusWeeks(1);

    LocalDate startFebruary = LocalDate.of(currentDate.getYear(), Month.FEBRUARY, 25);
    LocalDate endFebruary = startFebruary.plusWeeks(1);

    public boolean checkDate(){
        if ((currentDate.isEqual(startNovember) || currentDate.isAfter(startNovember)) && currentDate.isBefore(endNovember)) {
            System.out.println("Welcome to the loan registration window for November!");
            return true;
        } else if ((currentDate.isEqual(startFebruary) || currentDate.isAfter(startFebruary)) && currentDate.isBefore(endFebruary)) {
            System.out.println("Welcome to the loan registration window for February!");
            return true;
        } else {
            return false;
        }
    }
}
