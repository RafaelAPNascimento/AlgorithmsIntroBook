package _03DataStructures;

public interface MyArrayList<T> {

    // Replaces the element of the list specified by the index position
    // with a new element
    void set(int index, T value);

    // Returns the element from the position specified by the index
    T get(int index);

    // Returns quantity of elements in the list
    int size();

    // Checks if a list has an elements
    boolean isEmpty();

    // Appends the element to the end of the list
    void add(T value);

    // Inserts the new element into specified by an index position
    // shifting elements after the index toward the end of a list
    void insert(int index, T value);

    // Removes the element from the position specified by the index
    // shifting elements after the index toward the beginning of a list
    void delete(int index);

    // Checks if the list has a specified value
    boolean contains(T value);
}
