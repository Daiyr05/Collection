public interface CarCollections<T> extends Iterable<T>{
    boolean add(T c);
    boolean remove(T c);
    int size();
    void clear();
    boolean contains(T c);
}
