public class Appointment {
    String Name;
    int priority;

    public Appointment(String Name, int priority){
        this.Name = Name;
        this.priority = priority;
    }
    public String getAppName(){
        return Name;
    }

    public Appointment better(Appointment other) {
        return this;
    }
}

