public class ArrayDeque<T> {
    private T[] arr;
    private int size;
    private int frontIndex;
    private int endIndex;
    public ArrayDeque() {
        arr = (T[]) new Object[8];
        size = 0;
        frontIndex = 7;
        endIndex = 0;
    }
    private void upsize() {
        T[] arr1 = (T[]) new Object[size * 2];
        for (int i = 0; i < endIndex; i++) {
            arr1[i] = arr[i];
        }
        for (int i = frontIndex + 1; i < size; i++) {
            arr1[i + size] = arr[i];
        }
        frontIndex += size;
        arr = arr1;
    }
    public void addFirst(T item) {
        if (size == arr.length) {
            upsize();
        }
        arr[frontIndex] = item;
        frontIndex--;
        size++;
    }
    public void addLast(T item) {
        if (frontIndex < endIndex) {
            upsize();
        }
        arr[endIndex] = item;
        endIndex++;
        size++;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        for (int i = frontIndex + 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        for (int i = 0; i < endIndex - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print(arr[endIndex - 1]);
    }
    private void downsize() {
        T[] arr1 = (T[]) new Object[arr.length / 2];
        if (frontIndex < endIndex) {
            for (int i = 0; i < size; i++) {
                arr1[i] = arr[frontIndex + 1 + i];
            }
            frontIndex = arr1.length - 1;
            endIndex = size;
        } else {
            for (int i = 0; i < endIndex; i++) {
                arr1[i] = arr[i];
            }
            for (int i = frontIndex + 1; i < arr.length; i++) {
                arr1[i - arr.length / 2] = arr[i];
            }
            frontIndex -= arr.length / 2;
        }
        arr = arr1;
    }
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (arr.length >= 16 && size <= arr.length / 4) {
            downsize();
        }
        int index = (frontIndex + 1) % arr.length;
        T res = arr[index];
        frontIndex = index;
        size--;
        return res;
    }
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (arr.length >= 16 && size <= arr.length / 4) {
            downsize();
        }
        int index = (endIndex - 1 + arr.length) % arr.length;
        T res = arr[index];
        endIndex = index;
        size--;
        return res;
    }
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return arr[(frontIndex + 1 + index) % arr.length];
    }
}
