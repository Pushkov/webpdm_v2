package nicomed.backend.utils;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Utils {

    public static Calendar getBeforeMonth(Calendar date){
        int beforeYear = date.get(Calendar.MONTH) == 0 ? date.get(Calendar.YEAR) - 1 : date.get(Calendar.YEAR);
        int beforeMonth = date.get(Calendar.MONTH) == 0 ? 11 : date.get(Calendar.MONTH) - 1;
        Calendar before = new GregorianCalendar(
                beforeYear,
                beforeMonth,
                Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH));
        return before;
    }

    public static Calendar getAfterMonth(Calendar date){
        int afterYear = date.get(Calendar.MONTH) == 11 ? date.get(Calendar.YEAR) + 1 : date.get(Calendar.YEAR);
        int afterMonth = date.get(Calendar.MONTH) == 11 ? 0 : date.get(Calendar.MONTH) + 1;
        Calendar after = new GregorianCalendar(
                afterYear,
                afterMonth,
                1);
        return after;
    }

    public static Calendar getBeforeYear(Calendar date){
        int beforeYear = date.get(Calendar.YEAR) - 1;
        Calendar before = new GregorianCalendar(beforeYear, 11, 31);
        return before;
    }

    public static Calendar getAfterYear(Calendar date){
        int afterYear = date.get(Calendar.YEAR) + 1;
        Calendar after = new GregorianCalendar(afterYear, 0, 1);
        return after;
    }
}
