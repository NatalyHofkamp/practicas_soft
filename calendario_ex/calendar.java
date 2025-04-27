import java.time.LocalDate;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;


public class calendar {
    private final List<Holiday> holidays = new ArrayList<>();

    public boolean isHoliday(LocalDate date) {
        return holidays.stream().anyMatch(h -> h.isHoliday(date));
    }

    public void addFeriadoPuntual(LocalDate date) {
        holidays.add(new feriadoPuntual(date));
    }

    public void addFeriadoSemanal(DayOfWeek dayOfWeek) {
        holidays.add(new feriadoSemanal(dayOfWeek));
    }

    public void addIntervaloFeriado(LocalDate start, LocalDate end) {
        holidays.add(new intervaloFeriado(start, end));
    }
}
