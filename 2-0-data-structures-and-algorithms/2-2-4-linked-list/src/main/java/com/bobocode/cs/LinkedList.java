package com.bobocode.cs;


import com.bobocode.util.ExerciseNotCompletedException;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * {@link LinkedList} is a list implementation that is based on singly linked generic nodes. A
 * node is implemented as
 * inner static class {@link Node<T>}.
 * <p><p>
 * <strong>TODO: to get the most out of your learning,
 * <a href="https://www.bobocode.com/learn">visit our website</a></strong>
 * <p>
 *
 * @param <T> generic type parameter
 * @author Taras Boychuk
 * @author Serhii Hryhus
 */
public class LinkedList<T> implements List<T> {
    private static class Node<T> {
        T element;
        Node<T> next;

        public Node(T element) {
            this.element = element;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * This method creates a list of provided elements
     *
     * @param elements elements to add
     * @param <T>      generic type
     * @return a new list of elements the were passed as method parameters
     */
    public static <T> LinkedList<T> of(T... elements) {
        LinkedList<T> list = new LinkedList<>();
        for (T element : elements) {
            list.add(element);
        }
        return list;
//        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param element element to add
     */
    @Override
    public void add(T element) {
        if (element == null) {
            throw new NullPointerException();
        }
        Node<T> node = new Node<>(element);
        if (size == 0) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
//        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Adds a new element to the specific position in the list. In case provided index in out of
     * the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an index of new element
     * @param element element to add
     */
    @Override
    public void add(int index, T element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = new Node<>(element);
        if (index == 0) {
            node.next = head;
            head = node;
        } else if (index == size) {
            tail.next = node;
            tail = node;
        } else {
            Node<T> prevNode = head;
            Node<T> nextNode = head.next;
            for (int i = 1; i < size - 1; i++) {
                if (index == i) {
                    prevNode.next = node;
                    node.next = nextNode;
                }
                prevNode = nextNode;
                nextNode = nextNode.next;
            }
        }
        size++;
//        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Changes the value of a list element at specific position. In case provided index in out
     * of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an position of element to change
     * @param element a new element value
     */
    @Override
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = head;
        for (int i = 0; i < size - 1; i++) {
            if (index == i) {
                node.element = element;
            }
            node = node.next;
        }
//        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Retrieves an elements by its position index. In case provided index in out of the list
     * bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     * @return an element value
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = head;
        for (int i = 0; i < size - 1; i++) {
            if (index == i) {
                break;
            }
            node = node.next;
        }
        return node.element;
//        throw new ExerciseNotCompletedException(); // todo: implement this method
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
        return head.element;
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
        return tail.element;
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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            Node<T> node = head;
            head = head.next;
            size--;
            return node.element;
        }
        Node<T> prevNode = head;
        Node<T> node = head.next;
        for (int i = 1; i < size - 1; i++) {
            if (index == i) {
                prevNode.next = node.next;
                if (index == size - 1) {
                    tail = prevNode.next;
                }
                break;
            }
            prevNode = node;
            node = node.next;
        }
        size--;
        return node.element;
//            throw new ExerciseNotCompletedException(); // todo: implement this method
    }


    /**
     * Checks if a specific exists in he list
     *
     * @return {@code true} if element exist, {@code false} otherwise
     */
    @Override
    public boolean contains(T element) {
        Node<T> node = head;
        for (int i = 0; i < size - 1; i++) {
            if (node.element.equals(element)) {
                return true;
            }
            node = node.next;
        }
//        throw new ExerciseNotCompletedException(); // todo: implement this method
        return false;
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
     * Returns the number of elements in the list
     *
     * @return number of elements
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
        head = tail = null;
        size = 0;
//        throw new ExerciseNotCompletedException(); // todo: implement this method
    }
}
