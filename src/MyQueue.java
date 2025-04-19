import java.util.NoSuchElementException;

public class MyQueue<T extends Comparable<T>> { private final MyLinkedList<T> list = new MyLinkedList<>();
    public void enqueue(T item) {
        list.addLast(item);
    }

    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        T value = list.getFirst();
        list.removeFirst();
        return value;
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return list.getFirst();
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
        StringBuilder sb = new StringBuilder("Front -> ");
        for (Object o : arr) {
            sb.append(o).append(" ");
        }
        sb.append("<- Rear");
        return sb.toString();
    }
}