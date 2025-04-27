import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
        import java.time.LocalDate;

public class testGarage {

    @Test
    public void testCrearNuevaReserva() {
        garage g = new garage();
        g.createAppointment(LocalDate.of(2025, 4, 27), "Juan", 2);
        g.closeDate(LocalDate.of(2025, 4, 27));
        assertEquals("Juan", g.getName(LocalDate.of(2025, 4, 27)));
    }

    @Test
    void testInsertarPeorPrioridadNoCambia() {
        garage g = new garage();
        g.createAppointment(LocalDate.of(2025, 4, 27), "Juan", 2);
        g.createAppointment(LocalDate.of(2025, 4, 27), "Pedro", 1);
        g.closeDate(LocalDate.of(2025, 4, 27));
        assertEquals("Juan", g.getName(LocalDate.of(2025, 4, 27)));
    }

    @Test
    void testInsertarMejorPrioridadReemplaza() {
        garage g = new garage();
        g.createAppointment(LocalDate.of(2025, 4, 27), "Juan", 2);
        g.createAppointment(LocalDate.of(2025, 4, 27), "Maria", 3);
        g.closeDate(LocalDate.of(2025, 4, 27));
        assertEquals("Maria", g.getName(LocalDate.of(2025, 4, 27)));
    }

    @Test
    void testInsertarIgualPrioridadNoCambia() {
        garage g = new garage();
        g.createAppointment(LocalDate.of(2025, 4, 27), "Juan", 2);
        g.createAppointment(LocalDate.of(2025, 4, 27), "Lucas", 2);
        g.closeDate(LocalDate.of(2025, 4, 27));
        assertEquals("Juan", g.getName(LocalDate.of(2025, 4, 27)));
    }

    @Test
    void testInsertarFechasDiferentes() {
        garage g = new garage();
        g.createAppointment(LocalDate.of(2025, 4, 27), "Juan", 2);
        g.createAppointment(LocalDate.of(2025, 4, 28), "Pedro", 1);
        g.closeDate(LocalDate.of(2025, 4, 27));
        g.closeDate(LocalDate.of(2025, 4, 28));
        assertEquals("Juan", g.getName(LocalDate.of(2025, 4, 27)));
        assertEquals("Pedro", g.getName(LocalDate.of(2025, 4, 28)));
    }

    @Test
    void testCerrarFechaYConsultar() {
        garage g = new garage();
        g.createAppointment(LocalDate.of(2025, 4, 27), "Juan", 2);
        g.closeDate(LocalDate.of(2025, 4, 27));
        assertEquals("Juan", g.getName(LocalDate.of(2025, 4, 27)));
    }

    @Test
    void testModificarDespuesDeCerrarNoAfecta() {
        garage g = new garage();
        g.createAppointment(LocalDate.of(2025, 4, 27), "Juan", 2);
        g.closeDate(LocalDate.of(2025, 4, 27));
        g.createAppointment(LocalDate.of(2025, 4, 27), "Pedro", 5);
        assertEquals("Juan", g.getName(LocalDate.of(2025, 4, 27)));
    }

    @Test
    void testCerrarFechaSinReservas() {
        garage g = new garage();
        // ¡Acá depende tu diseño!
        // Si cerrás sin reservas, puede lanzar excepción o permitirlo.
        // Ejemplo si esperás excepción:
        assertThrows(NullPointerException.class, () -> {
            g.closeDate(LocalDate.of(2025, 5, 1));
            g.getName(LocalDate.of(2025, 5, 1));
        });
    }

    @Test
    void testCargaMasivaDeReservas() {
        garage g = new garage();
        for (int i = 1; i <= 100; i++) {
            g.createAppointment(LocalDate.of(2025, 4, 30), "Persona" + i, i);
        }
        g.closeDate(LocalDate.of(2025, 4, 30));
        assertEquals("Persona100", g.getName(LocalDate.of(2025, 4, 30)));
    }

    @Test
    void testPrioridadesNegativas() {
        garage g = new garage();
        g.createAppointment(LocalDate.of(2025, 5, 2), "Ana", -1);
        g.closeDate(LocalDate.of(2025, 5, 2));
        assertEquals("Ana", g.getName(LocalDate.of(2025, 5, 2)));
    }
}
