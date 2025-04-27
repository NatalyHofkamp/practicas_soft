public class OpenAppointment extends Appointment {
    public OpenAppointment(String Name, int priority) {
        super(Name, priority);
    }
    public int compareTo(Appointment other) {
        return Integer.compare(this.priority, other.priority);
    }
    public Appointment better(Appointment other) {
        return this.compareTo(other) >= 0 ? this : other;
    }
}
