import java.util.List;
import java.util.Set;

public interface CarMap {

    void put(CarOwner carOwner, carproject.Car value);
    carproject.Car get(CarOwner carOwner);
    Set<CarOwner> KeySet();
    List<carproject.Car> values();
    boolean remove(CarOwner key);
    int size();
    void clear();
}
