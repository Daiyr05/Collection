import carproject.Car;

import java.util.Iterator;

public class CarSetList<T> implements CarSetInterface<T>{
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private Object[] array = new Object[INITIAL_CAPACITY];
    private int size = 0;
    @Override
    public boolean add(T car) {
        if (size>=array.length*LOAD_FACTOR){
            increaseArray();
        }
        boolean added = add(car,array);
        if (added){
            size++;
        }
        return added;
    }

    public boolean add(T car,Object[] dst){
        int position = getElementPosition(car,array.length);
        Entry entry = new Entry(car,null);
        if (dst[position] == null){
            dst[position] = entry;
            return true;
        }else{
            Entry existedElement = (Entry)dst[position];
            while (true){
                if (existedElement.value.equals(car)){
                    return false;
                }else  if(existedElement.next == null){
                    existedElement.next = entry;
                    return true;
                }else{
                    existedElement = existedElement.next;
                }
            }
        }
    }

    @Override
    public boolean remove(T car) {
        int position = getElementPosition(car,array.length);
        if (array[position]==null){
            return false;
        }
            Entry secondLast = (Entry)array[position];
            Entry last = secondLast.next;

            if (secondLast.value.equals(car)){
                array[position] = last;
                size--;
                return true;
            }

            while(last!=null){
                if (last.value.equals(car)){
                    secondLast  = last.next;
                    size--;
                    return true;
                }else{
                    secondLast = last;
                    last = last.next;
                }
            }

        return false;
    }

    private void increaseArray(){
        Object[] newArray = new Object[array.length*2];
        for (Object e : array){
            Entry existedElement = (Entry)e;
            while (existedElement!=null){
                add(existedElement.value,newArray);
                existedElement = existedElement.next;
            }
        }
        array = newArray;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public boolean contains(T c) {
        int position = getElementPosition(c,array.length);
        if (array[position]==null){
            return false;
        }
        Entry secondLast = (Entry)array[position];
        Entry last = secondLast.next;

        if (secondLast.value.equals(c)){
            return true;
        }

        while(last!=null){
            if (last.value.equals(c)){
                return true;
            }else{
                last = last.next;
            }
        }

        return false;
    }

    private int getElementPosition(T car,int arrLength){
        return Math.abs(car.hashCode() % arrLength);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            int indexArray = 0;
            Entry entry;
            @Override
            public boolean hasNext() {
                return index<size;
            }

            @Override
            public T next() {
                while (array[indexArray]==null){
                    indexArray++;
                }
                if (entry==null){
                    entry = (Entry)array[indexArray];
                }
                T result = entry.value;
                entry = entry.next;
                if (entry==null){
                    indexArray++;
                }
                index++;
                return result;
            }
        };
    }

    public class Entry{
        T value;
        Entry next;

        public Entry(T value, Entry next) {
            this.value = value;
            this.next = next;
        }
    }
}
