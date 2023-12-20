import carproject.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarHasMapListTest {
    private CarMap map;

    @Before
    public void setUp() throws Exception {
        map = new CarHasMapList();
    }

    @Test
    public void whenPut100Elements(){
        for (int i = 0; i < 100; i++){
            CarOwner carOwner = new CarOwner("Brand"+i,"lastName"+i,i);
            carproject.Car value = new Car("Brand"+i,i);
            map.put(carOwner,value);
        }
        assertEquals(100,map.size());
    }


    @Test
    public void whenAddOnly10UniqueElements(){
        for (int i = 0; i < 100; i++){
            int index = i%10;
            CarOwner carOwner = new CarOwner("Brand"+index,"lastname"+index,index);
            Car value = new Car("Brand"+index,index);
            map.put(carOwner,value);
        }
        assertEquals(10,map.size());
    }


    @Test
    public void whenGetElement(){
        for (int i = 0; i < 100; i++){
            CarOwner carOwner = new CarOwner("Brand"+i,"lastName"+i,i);
            carproject.Car value = new Car("Brand"+i,i);
            map.put(carOwner,value);
        }
        CarOwner carOwner1 = new CarOwner("Brand","lastname",100);
        Car value = new Car("Brand",100);
        map.put(carOwner1,value);
        assertEquals("Brand",map.get(carOwner1).getBrand());

    }

    @Test
    public void whenRemoveReturnBoolean(){
        for(int i = 0 ; i <100;i++){
            CarOwner carOwner = new CarOwner("Brand"+i,"lastName"+i,i);
            carproject.Car value = new Car("Brand"+i,i);
            map.put(carOwner,value);
        }
        CarOwner carOwner1 = new CarOwner("Brand","lastname",100);
        Car value = new Car("Brand",100);
        map.put(carOwner1,value);
        assertEquals(101,map.size());
        assertTrue(map.remove(carOwner1));
        assertEquals(100,map.size());


    }

}