package com.bobocode.cs;

import com.bobocode.util.ExerciseNotCompletedException;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

/**
 * {@link ArrayList} is an implementation of {@link List} interface. This resizable data structure
 * based on an array and is simplified version of {@link java.util.ArrayList}.
 * <p><p>
 * <strong>TODO: to get the most out of your learning,
 * <a href="https://www.bobocode.com/learn">visit our website</a></strong>
 * <p>
 *
 * @author Serhii Hryhus
 */
public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 5;
    private static final float DEFAULT_RESIZE_COEFFICIENT = 1.5f;
    private Object[] storage;
    private int capacity;
    private int size;

    /**
     * This constructor creates an instance of {@link ArrayList} with a specific capacity of an
     * array inside.
     *
     * @param initCapacity - the initial capacity of the list
     * @throws IllegalArgumentException – if the specified initial capacity is negative or 0.
     */
    public ArrayList(int initCapacity) {
        if (initCapacity <= 0) {
            throw new IllegalArgumentException();
        }
        capacity = initCapacity;
        storage = new Object[capacity];
//        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * This constructor creates an instance of {@link ArrayList} with a default capacity of an
     * array inside.
     * A default size of inner array is 5;
     */
    public ArrayList() {
        capacity = DEFAULT_CAPACITY;
        storage = new Object[capacity];
//        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Creates and returns an instance of {@link ArrayList} with provided elements
     *
     * @param elements to add
     * @return new instance
     */
    public static <T> List<T> of(T... elements) {
        List<T> list = new ArrayList<>((int) (elements.length * DEFAULT_RESIZE_COEFFICIENT));
        Stream.of(elements).forEach(list::add);
        return list;
//        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Adds an element to the array.
     *
     * @param element element to add
     */
    @Override
    public void add(T element) {
        if (size == capacity) {
            resize();
        }
        storage[size] = element;
        size++;
//        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    private void resize() {
        capacity *= DEFAULT_RESIZE_COEFFICIENT;
        Object[] newStorage = new Object[capacity];
        System.arraycopy(storage, 0, newStorage, 0, size);
        storage = newStorage;
    }

    /**
     * Adds an element to the specific position in the array where
     *
     * @param index   index of position
     * @param element element to add
     */
    @Override
    public void add(int index, T element) {
        checkIndex(index);
        if (size == capacity) {
            resize();
        }
        Object[] tempStorage = new Object[capacity];
        System.arraycopy(storage, 0, tempStorage, 0, index);
        tempStorage[index] = element;
        System.arraycopy(storage, index, tempStorage, index + 1, size - index);
        storage = tempStorage;
        size++;
//        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Retrieves an element by its position index. In case provided index in out of the list
     * bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index index of element
     * @return en element
     */
    @Override
    public T get(int index) {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        checkIndex(index);
        return (T) storage[index];
//        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size || size == 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the first element of the list. Operation is performed in constant time O(1)
     *
     * @return the first element of the list
     * @throws java.util.NoSuchElementException if list is empty
     */
    @Override
    public T getFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return (T) storage[0];
//        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Returns the last element of the list. Operation is performed in constant time O(1)
     *
     * @return the last element of the list
     * @throws java.util.NoSuchElementException if list is empty
     */
    @Override
    public T getLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return (T) storage[size - 1];
//        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Changes the value of array at specific position. In case provided index in out of the list
     * bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   position of value
     * @param element a new value
     */
    @Override
    public void set(int index, T element) {
        checkIndex(index);
        storage[index] = element;
//        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Removes an elements by its position index. In case provided index in out of the list
     * bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     * @return deleted element
     */
    @Override
    public T remove(int index) {
        checkIndex(index);
        T element = (T) storage[index];
        Object[] tempStorage = new Object[capacity];
        System.arraycopy(storage, 0, tempStorage, 0, index);
        System.arraycopy(storage, index + 1, tempStorage, index, size - index - 1);
        storage = tempStorage;
        size--;
        return element;
//        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Checks for existing of a specific element in the list.
     *
     * @param element is element
     * @return If element exists method returns true, otherwise it returns false
     */
    @Override
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            T object = (T) storage[i];
            if (object.equals(element)) {
                return true;
            }
        }
        return false;
//        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Checks if a list is empty
     *
     * @return {@code true} if list is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
//        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * @return amount of saved elements
     */
    @Override
    public int size() {
        return size;
//        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Removes all list elements
     */
    @Override
    public void clear() {
        storage = new Object[capacity];
        size = 0;
//        throw new ExerciseNotCompletedException(); // todo: implement this method
    }
}
