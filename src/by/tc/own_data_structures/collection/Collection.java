package by.tc.own_data_structures.collection;

/**
 * Created by Y50-70 on 05.01.2018.
 */
public interface Collection<T> extends Iterable<T> {
    boolean add(T t);
    void remove(Object o);
    int size();
    boolean isEmpty();
    boolean contains(T t);
}
