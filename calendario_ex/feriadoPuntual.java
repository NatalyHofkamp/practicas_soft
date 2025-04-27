import java.time.LocalDate;

public class feriadoPuntual extends Holiday {
    private final LocalDate date;

    public feriadoPuntual(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean isHoliday(LocalDate date) {
        return this.date.equals(date);
    }
}
