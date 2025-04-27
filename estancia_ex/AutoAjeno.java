public class AutoAjeno extends Auto {
    public AutoAjeno(int people, String patente) {
        super(people, patente);
    }

    public int getMoney() {
        return 50 + 60 * getPeople();
    }
}
