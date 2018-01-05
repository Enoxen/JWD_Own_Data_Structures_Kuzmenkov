package by.tc.own_data_structures.collection;

/**
 * Created by Y50-70 on 05.01.2018.
 */
public interface List<T> extends Collection<T> {
    void add(int index, T element);
    T get(int index);
}
