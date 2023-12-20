import carproject.Car;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CarSetInterfaceTest {
    CarSetInterface CarSetList;
    @Before
    public void setUp() throws Exception {
        CarSetList = new CarSetList();
        for (int i = 0; i < 100; i++){
            CarSetList.add(new Car("BMW",i));
        }
    }


    @Test
    public void whenAdd2DifferrentCar(){
        Car c = new Car("BMW",100);
        assertTrue(CarSetList.add(c));
        assertEquals(100,c.getNumber());
        assertEquals(101,CarSetList.size());
        Car c2 = new Car("BMW",101);
        assertTrue(CarSetList.add(c2));
        assertEquals(101,c2.getNumber());
        assertEquals(102,CarSetList.size());

    }

    @Test
    public void whenAdd2SimilarCar(){
        Car c = new Car("Mercedes",1);
        assertTrue(CarSetList.add(c));
        assertEquals(101,CarSetList.size());
        assertFalse(CarSetList.add(c));
        assertEquals(101,CarSetList.size());
        Car c2 = new Car("Mercedes",2);
        assertTrue(CarSetList.add(c2));
        assertEquals(102,CarSetList.size());
        assertFalse(CarSetList.add(c2));
        assertEquals(102,CarSetList.size());
    }

    @Test
    public void whenRemoveElement(){
        Car c = new Car("Cool",100);
        CarSetList.add(c);
        assertEquals(101,CarSetList.size());
        assertTrue(CarSetList.remove(c));
        assertEquals(100,CarSetList.size());
        assertFalse(CarSetList.remove(c));

    }

    @Test
    public void whenclearList(){
        CarSetList.clear();
        assertEquals(0,CarSetList.size());
    }

    @Test
    public void whenContainsElement(){
        assertFalse(CarSetList.contains(new Car("Brand0",0)));
    }

    @Test
    public void whenUseForEach(){
        int index = 0;
        for (Object c : CarSetList){
            index++;
        }
        assertEquals(CarSetList.size(),index);
    }
}