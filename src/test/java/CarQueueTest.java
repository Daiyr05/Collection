import carproject.Car;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class CarQueueTest {
    Queue queue;
    @Before
    public void setUp() throws Exception {
        queue = new LinkedList();
        for (int  i = 0; i < 10; i++){
            queue.add(new carproject.Car("Brand"+i,i));
        }
    }

    @Test
    public void add() {
        assertEquals(10,queue.size());
    }

    @Test
    public void peek() {
        carproject.Car car = (carproject.Car) queue.peek();
        assertEquals("Brand0",car.getBrand());

    }

    @Test
    public void poll() {
        carproject.Car car = (Car) queue.peek();
        assertEquals(queue.poll(),car);
        assertEquals(9,queue.size() );
    }
}