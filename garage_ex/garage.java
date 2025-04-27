import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;

public class garage {
    private final Map<LocalDate, Appointment> Dates = new HashMap<>();

    public String getName (LocalDate fecha ){
        return Dates.get(fecha).getAppName();
    }
    public void closeDate(LocalDate fecha) {
        Dates.put(fecha,new CloseAppointment( Dates.get(fecha).getAppName(),Dates.get(fecha).priority));
    }
    public void createAppointment(LocalDate fecha, String Name, int priority) {
        Appointment nuevoAppointment = new OpenAppointment(Name, priority);
        Appointment anterior = Dates.getOrDefault(fecha, nuevoAppointment);
        Dates.put(fecha, anterior.better(nuevoAppointment));
    }
}
