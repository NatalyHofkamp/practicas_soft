import java.time.LocalDate;

public class intervaloFeriado extends Holiday {
    private final LocalDate startDate;
    private final LocalDate endDate;

    public intervaloFeriado(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public boolean isHoliday(LocalDate date) {
        return (date.isEqual(startDate) || date.isAfter(startDate)) &&
                (date.isEqual(endDate) || date.isBefore(endDate));
    }
}
