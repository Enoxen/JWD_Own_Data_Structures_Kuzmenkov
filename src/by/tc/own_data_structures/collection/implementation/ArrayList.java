package by.tc.own_data_structures.collection.implementation;

import by.tc.own_data_structures.collection.Iterator;
import by.tc.own_data_structures.collection.List;
import by.tc.own_data_structures.collection.exception.InvalidIndexException;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Created by Y50-70 on 05.01.2018.
 */
public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_SIZE = 10;
    private T[] array;
    private int size;

    public ArrayList(){
        this(DEFAULT_SIZE);
    }

    public ArrayList(int size){
        array = (T[]) new Object[size];
    }

    private void ensureCapacity() {
        if (size < array.length) {
            return;
        }
        resize();
    }
    private void resize() {
        T[] temp =(T[]) new Object[array.length * 2];
        System.arraycopy(array, 0, temp, 0, array.length);
        array = temp;
    }
    private void checkIndex(int index) {
        if (index > size || index < 0) {
            throw new InvalidIndexException("Index: " + index + ", Size: " + size);
        }
    }

    private void checkIndexForRemoving(int index) {
        if (index >= size || size == 0) {
            throw new InvalidIndexException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public void add(int index, T element) {
        checkIndex(index);
        ensureCapacity();
        for(int i = size; i > index; i--){
            array[i] = array[i-1];
        }
        array[index] = element;
        size++;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public boolean set(int index, T t) {
        checkIndex(index);
        array[index] = t;
        return false;
    }

    @Override
    public int indexOf(T t) {
        for(int i = 0; i < size; i++){
            if(get(i).equals(t))
                return i;
        }
        return -1;
    }

    @Override
    public boolean add(T t) {
        ensureCapacity();
        array[size++] = t;
        return true;
    }

    @Override
    public boolean remove(T t) {
        for (int i = 0; i < size; ++i) {
            if (array[i].equals(t)) {
                int numberElements = size - i - 1;

                System.arraycopy(array, i + 1, array, i, numberElements);
                array[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {
        checkIndexForRemoving(index);
        T value = array[index];
        int numberElements = size - index - 1;

        System.arraycopy(array, index + 1, array, index, numberElements);
        array[--size] = null;
        return value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T t) {
        for (int i = 0; i < size; i++){
            if(array[i].equals(t)){
                return true;
            }
        }
        return false;
    }
    @Override
    public Iterator<T> getIterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T>{
        private int index;
        int lastReturnedIndex;
        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if(this.hasNext()){
                lastReturnedIndex = index;
                return  array[index++];
            }
            throw new NoSuchElementException();
        }

        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        @Override
        public T previous() {
            if(this.hasPrevious()){
                lastReturnedIndex = index - 1;
                return array[--index];
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            int numberElements = size - lastReturnedIndex - 1;
            System.arraycopy(array, lastReturnedIndex + 1, array, lastReturnedIndex, numberElements);
            array[--size] = null;
            index--;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArrayList)) return false;

        ArrayList<?> arrayList = (ArrayList<?>) o;

        if (size != arrayList.size) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(array, arrayList.array);

    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(array);
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }
}
