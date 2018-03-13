package Algorithms;

public class Sort {

    private void swap(int[] vals, int current) {
        int temp = vals[current];
        vals[current] = vals[current - 1];
        vals[current - 1] = temp;
    }

    public void insertionSort(int[] vals) {
        int current;
        for (int pos = 1; pos < vals.length; pos++) {
            current = pos;
            while (current > 0 && vals[current] < vals[current - 1]) {
                swap(vals, current);
                current--;
            }
        }
    }
}
