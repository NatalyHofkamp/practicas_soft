import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.DayOfWeek;

public class CalendarTest {

    @Test
    public void testFeriadoPuntual() {
        calendar cal = new calendar();
        cal.addFeriadoPuntual(LocalDate.of(2023, 5, 25));
        assertTrue(cal.isHoliday(LocalDate.of(2023, 5, 25)));
    }

    @Test
    public void testDiaNoFeriado() {
        calendar cal = new calendar();
        assertFalse(cal.isHoliday(LocalDate.of(2024, 1, 1)));
    }

    @Test
    public void testFeriadoSemanal() {
        calendar cal = new calendar();
        cal.addFeriadoSemanal(DayOfWeek.SUNDAY);
        assertTrue(cal.isHoliday(LocalDate.of(2024, 5, 5))); // Domingo
        assertFalse(cal.isHoliday(LocalDate.of(2024, 5, 6))); // Lunes
    }

    @Test
    public void testIntervaloFeriado() {
        calendar cal = new calendar();
        cal.addIntervaloFeriado(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5));
        assertTrue(cal.isHoliday(LocalDate.of(2024, 1, 3))); // Dentro del intervalo
        assertFalse(cal.isHoliday(LocalDate.of(2024, 1, 6))); // Fuera del intervalo
    }

    @Test
    public void testFeriadoRepetido() {
        calendar cal = new calendar();
        cal.addFeriadoPuntual(LocalDate.of(2023, 5, 25));
        cal.addFeriadoPuntual(LocalDate.of(2023, 5, 25));
        assertTrue(cal.isHoliday(LocalDate.of(2023, 5, 25)));
    }

    @Test
    public void testMultiplesTiposDeFeriados() {
        calendar cal = new calendar();
        cal.addFeriadoPuntual(LocalDate.of(2023, 5, 25));
        cal.addIntervaloFeriado(LocalDate.of(2023, 5, 24), LocalDate.of(2023, 5, 26));
        cal.addFeriadoSemanal(DayOfWeek.SUNDAY);
        assertTrue(cal.isHoliday(LocalDate.of(2023, 5, 25)));
    }


    @Test
    public void testMuchosFeriados() {
        calendar cal = new calendar();
        for (int i = 1; i <= 366; i++) { // 2024 es año bisiesto
            LocalDate date = LocalDate.ofYearDay(2024, i);
            cal.addFeriadoPuntual(date);
        }
        assertTrue(cal.isHoliday(LocalDate.of(2024, 2, 29))); // Año bisiesto
    }

    @Test
    public void testDiaNormalSinFeriado() {
        calendar cal = new calendar();
        cal.addFeriadoSemanal(DayOfWeek.SUNDAY);
        assertFalse(cal.isHoliday(LocalDate.of(2024, 4, 17))); // Miércoles
    }
}
