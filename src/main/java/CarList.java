
import carproject.Car;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class CarList<T> implements CarListInterface<T> {
    private Object[] array = new Object[10];
    private int size = 0;

    public T get(int index){
        checkIndex(index);
        return (T)array[index];
    }

    public boolean add(T c){
        if(size >= array.length){
            Object[] temp = new Object[array.length*2];
            for (int i = 0; i<array.length; i++){
                temp[i] = array[i];
            }
            array = temp;
//            array = Arrays.copyOf(array,array.length*2);
        }
        array[size] = c;
        size++;
        return true;

    }

    @Override
    public boolean add(T car, int index) {
        for (int i = size; i>index; i--){
            array[i] = array[i-1];
        }
        array[index] = car;
        size++;
        return true;
    }


    public boolean remove(T car){
        for (int i = 0; i<size; i++){
            if(array[i].equals(car)){
                return  removeAt(i);
            }
        }
        return false;
    }

    public boolean removeAt(int index){
        checkIndex(index);
        for (int i = index; i<size-1; i++){
            array[i] = array[i+1];
        }
        size--;
        return true;
    }

    private void checkIndex(int index){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }

    public int size(){
        return this.size;
    }

    public void clear(){
        array = new Object[10];
        size = 0;
    }

    @Override
    public boolean contains(T c) {
        for (int i = 0; i < array.length; i++){
            if (array[i] != null){
                if (array[i].equals(c)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index<size;
            }

            @Override
            public T next() {
                return (T)array[index++];
            }
        };
    }
}
