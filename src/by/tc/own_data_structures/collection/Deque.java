package by.tc.own_data_structures.collection;

/**
 * Created by Y50-70 on 05.01.2018.
 */
public interface Deque<T> extends Queue<T> {
    void addFirst(T t);
    void addLast(T t);
    T removeFirst();
    T removeLast();
    T getFirst();
    T getLast();

    boolean offerFirst(T t);
    boolean offerLast(T t);
    T pollFirst();
    T pollLast();
    T peekFirst();
    T peekLast();
}
