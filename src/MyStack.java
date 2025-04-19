import java.util.EmptyStackException;

public class MyStack<T extends Comparable<T>> {
    private final MyLinkedList<T> list = new MyLinkedList<>();

    public void push(T item) {
        list.addLast(item);
    }

    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T value = list.getLast();
        list.removeLast();
        return value;
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    public void clear() {
        list.clear();
    }

    @Override
    public String toString() {
        Object[] arr = list.toArray();
        StringBuilder sb = new StringBuilder("Top -> ");
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]).append(" ");
        }
        return sb.toString();
    }
}