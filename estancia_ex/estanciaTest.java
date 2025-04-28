import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class estanciaTest {

    @Test
    void nuevaEstanciaEmpiezaVacia() {
        estancia estancia = new estancia();
        assertEquals(0, estancia.getAmountPeople());
        assertEquals(0, estancia.getAmountMoney());
    }

    @Test
    void agregarUnAutoSocioCuentaBien() {
        estancia estancia = new estancia();
        estancia.addAuto(new AutoSocio(4, "ABC123"));
        assertEquals(4, estancia.getAmountPeople());
        assertEquals(100, estancia.getAmountMoney());
    }

    @Test
    void agregarUnAutoInvitadoCuentaBien() {
        estancia estancia = new estancia();
        estancia.addAuto(new AutoInvitado(3, "DEF456"));
        assertEquals(3, estancia.getAmountPeople());
        assertEquals(150, estancia.getAmountMoney());
    }

    @Test
    void agregarUnAutoAjenoCuentaBien() {
        estancia estancia = new estancia();
        estancia.addAuto(new AutoAjeno(2, "GHI789"));
        assertEquals(2, estancia.getAmountPeople());
        assertEquals(50 + 60 * 2, estancia.getAmountMoney());
    }

    @Test
    void agregarVariosAutosDeDiferentesTipos() {
        estancia estancia = new estancia();
        estancia.addAuto(new AutoSocio(2, "A"));
        estancia.addAuto(new AutoInvitado(3, "B"));
        estancia.addAuto(new AutoAjeno(1, "C"));
        assertEquals(6, estancia.getAmountPeople());
        assertEquals(100 + 150 + (50 + 60), estancia.getAmountMoney());
    }

    @Test
    void eliminarAutoReduceCantidad() {
        estancia estancia = new estancia();
        estancia.addAuto(new AutoSocio(2, "A"));
        estancia.addAuto(new AutoAjeno(1, "B"));
        estancia.deleteAuto("A");
        assertEquals(1, estancia.getAmountPeople());
        assertEquals(50 + 60, estancia.getAmountMoney());
    }

    @Test
    void eliminarAutoQueNoExisteNoRompeNada() {
        estancia estancia = new estancia();
        estancia.addAuto(new AutoSocio(2, "A"));
        estancia.deleteAuto("ZZZ999"); // patente que no existe
        assertEquals(2, estancia.getAmountPeople());
        assertEquals(100, estancia.getAmountMoney());
    }

    @Test
    void reemplazarAutoConMismaPatente() {
        estancia estancia = new estancia();
        estancia.addAuto(new AutoSocio(2, "A"));
        estancia.addAuto(new AutoAjeno(3, "A")); // reemplaza
        assertEquals(3, estancia.getAmountPeople());
        assertEquals(50 + 60 * 3, estancia.getAmountMoney());
    }

    @Test
    void agregarAutoConCeroPasajeros() {
        estancia estancia = new estancia();
        estancia.addAuto(new AutoAjeno(0, "ZZZ000"));
        assertEquals(0, estancia.getAmountPeople());
        assertEquals(50, estancia.getAmountMoney());
    }

    @Test
    void eliminarTodosLosAutosDejaEstanciaVacia() {
        estancia estancia = new estancia();
        estancia.addAuto(new AutoSocio(1, "A"));
        estancia.addAuto(new AutoInvitado(2, "B"));
        estancia.addAuto(new AutoAjeno(3, "C"));
        estancia.deleteAuto("A");
        estancia.deleteAuto("B");
        estancia.deleteAuto("C");
        assertEquals(0, estancia.getAmountPeople());
        assertEquals(0, estancia.getAmountMoney());
    }
}
