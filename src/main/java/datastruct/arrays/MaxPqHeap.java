package datastruct.arrays;

public class MaxPqHeap<Key extends Comparable> {
    private Key[] keys;
    private int size;

    public MaxPqHeap(int capacity) {
        keys = (Key[]) new Comparable[capacity + 1];
    }

    private void swap(int i, int j) {
        Key temp = keys[i];
        keys[i] = keys[j];
        keys[j] = temp;
    }

    private void swim(int k) {
        while (k > 1 && keys[k / 2].compareTo(keys[k]) < 0) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && keys[j].compareTo(keys[j + 1]) < 0) {
                j++;
            }
            if (keys[j].compareTo(keys[k]) < 0) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    public void add(Key el) {
        keys[++size] = el;
        swim(size);
    }

    public Key removeMax() {
        Key el = keys[1];
        swap(1, size--);
        keys[size + 1] = null;
        sink(1);
        return el;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public int size(){
        return size;
    }
}
