import java.util.HashMap;
import java.util.Map;

public class estancia {
    private Map<String, Auto> autos = new HashMap<>();

    public int getAmountPeople() {
        return autos.values().stream()
                .mapToInt(Auto::getPeople)
                .sum();
    }

    public int getAmountMoney() {
        return autos.values().stream()
                .mapToInt(Auto::getMoney)
                .sum();
    }
    public void addAuto(Auto newCar) {
        autos.put(newCar.getPatente(), newCar);
    }

    public void deleteAuto(String patente) {
        Auto car = autos.remove(patente);
    }

}
