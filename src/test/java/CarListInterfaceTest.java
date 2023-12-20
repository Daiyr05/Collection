
import carproject.Car;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class CarListInterfaceTest {
    CarListInterface<Car> carList;
    @Before
    public void setUp() throws Exception {
        //init
        carList = new CarLinkedList();
        for (int i = 0; i<100; i++){
            carList.add(new carproject.Car("Brand"+i,i));
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100(){
        assertEquals(100,carList.size());
    }

    @Test
    public void whenElementRemovedByIndexSizeMustBeDiscreased(){
        carList.removeAt(5);
        assertEquals(99,carList.size());
    }

    @Test
    public  void whenElementRemovedSizeMustBeDiscreased(){
        carList.add(new carproject.Car("Toyota"+1,0));
        assertEquals(101,carList.size());
        assertTrue(carList.removeAt(100));
        assertEquals(100,carList.size());
    }

    @Test
    public void whenNonExistingElementRemovedMustReturnFalse(){
        carproject.Car c = new carproject.Car("cool",15);
        assertFalse(carList.remove(c));
        assertEquals(100,carList.size());
    }


    @Test
    public void whenListWasCleared(){
        carList.clear();
        assertEquals(0,carList.size());
    }

    @Test
    public  void whenReturnRightValue(){
        carproject.Car c = carList.get(0);
        assertEquals("Brand0",c.getBrand());
    }

    @Test(expected =  IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundException(){
        carList.get(101);
    }


    @Test
    public void whenAddElementByIndex(){
        carproject.Car car = new Car("Bugati",0);
        carList.add(car,0);
        assertEquals("Bugati",carList.get(0).getBrand());
    }

    @Test
    public void whenContainsElement(){
        assertFalse(carList.contains(new Car("Brand20",20)));
        assertTrue(carList.contains(carList.get(1)));
        assertTrue(carList.contains(carList.get(0)));
        assertFalse(carList.contains(new Car("Brand1000",1000)));
    }

    @Test
    public void whenUserForEach(){
        int index = 0;
        for (Car c : carList){
            index+=1;
        }
        assertEquals(carList.size(),index);
    }

}