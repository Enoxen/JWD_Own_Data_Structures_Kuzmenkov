package by.tc.own_data_structures.collection;

/**
 * Created by Y50-70 on 05.01.2018.
 */
public interface Queue<T> extends Collection<T> {
    boolean offer(T t);
    T poll();
    T peek();
    T remove();
    T element();
}
