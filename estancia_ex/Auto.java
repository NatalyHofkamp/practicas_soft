public abstract class Auto {
    private int people;
    private String patente;

    public Auto(int people, String patente) {
        this.people = people;
        this.patente = patente;
    }
    public int getPeople() {
        return this.people;
    }
    public String getPatente() {
        return this.patente;
    }
    public abstract int getMoney();
}
