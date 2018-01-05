package by.tc.own_data_structures.collection;

/**
 * Created by Y50-70 on 05.01.2018.
 */
public interface Iterator<T> {
    boolean hasNext();
    T next();
    boolean hasPrevious();
    T previous();
    void remove();
}
