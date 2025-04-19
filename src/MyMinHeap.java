import java.util.ArrayList;

public class MyMinHeap<T extends Comparable<T>> {
    private ArrayList<T> heap;

    public MyMinHeap() {
        heap = new ArrayList<>();
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void insert(T value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    public T peek() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }

    public T removeMin() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");

        T min = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return min;
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIdx = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parentIdx)) >= 0) break;

            swap(index, parentIdx);
            index = parentIdx;
        }
    }

    private void heapifyDown(int index) {
        int size = heap.size();
        while (index < size) {
            int leftIdx = 2 * index + 1;
            int rightIdx = 2 * index + 2;
            int smallest = index;

            if (leftIdx < size && heap.get(leftIdx).compareTo(heap.get(smallest)) < 0) {
                smallest = leftIdx;
            }
            if (rightIdx < size && heap.get(rightIdx).compareTo(heap.get(smallest)) < 0) {
                smallest = rightIdx;
            }

            if (smallest == index) break;

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        T tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }

    public void printHeap() {
        System.out.println(heap);
    }
}
