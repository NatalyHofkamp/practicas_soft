import java.time.DayOfWeek;
import java.time.LocalDate;

public class feriadoSemanal extends Holiday {
    private final DayOfWeek dayOfWeek;

    public feriadoSemanal(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public boolean isHoliday(LocalDate date) {
        return date.getDayOfWeek().equals(dayOfWeek);
    }
}
