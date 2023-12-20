import carproject.Car;

import java.util.Iterator;

public class CarLinkedList<T> implements CarListInterface<T>,CarQueue<T> {
    private Node first;
    private Node last;
    private int size;
    @Override
    public T get(int index) {
        return getNode(index).value;
    }

    @Override
    public boolean add(T car) {
        if(size == 0){
            first = new Node(null,car,null);
            last = first;
        }else{
            Node secondLast = last;
            last = new Node(secondLast,car,null);
            secondLast.next = last;
        }
        size++;
        return true;
    }

    @Override
    public T peek() {
        return size>0 ? get(0): null;
    }

    @Override
    public T poll() {
        T car =  get(0);
        removeAt(0);
        return car;
    }

    public boolean add(T car,int index){
        if (index < 0 || index>size){
            throw new IndexOutOfBoundsException();
        };
        if (index == size){
            return add(car);
        }
        Node nodeNext = getNode(index);
        Node nodePrevious = nodeNext.prev;
        Node newNode = new Node(nodePrevious,car,nodeNext);
        nodeNext.prev = newNode;
       if (nodePrevious !=null){
           nodePrevious.next = newNode;
       }else {
           first = newNode;
       }
       size++;
        return true;
    }
    @Override
    public boolean remove(T car) {
        Node node = first;
        for (int i = 0; i<size; i++){
            if (node.value.equals(car)){
                return  removeAt(i);
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        Node node = getNode(index);
        Node nodeNext = node.next;
        Node nodePrev = node.prev;
        if (nodeNext!=null){
            nodeNext.prev = nodePrev;
        }else{
            last = nodePrev;
        }

        if (nodePrev != null){
            nodePrev.next = nodeNext;
        }else{
            first = nodeNext;
        }

        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean contains(T c) {
        Node node = first;
        for (int i = 0; i<size; i++){
            if (node.value.equals(c)){
                return  true;
            }
            node = node.next;
        }
        return false;
    }

    public Node getNode(int index){
        if (index<0 || index>size){
            throw new IndexOutOfBoundsException();
        }
        Node node = first;
        for (int i = 0; i <index; i++){
            node = node.next;
        }
        return node;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node node = first;
            @Override
            public boolean hasNext() {
                return node!=null;
            }

            @Override
            public T next() {
                T car = node.value;
                node = node.next;
                return car;
            }
        };
    }

    private class Node{
        Node prev;
        T value;
        Node next;

        public Node(Node prev, T value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
}
