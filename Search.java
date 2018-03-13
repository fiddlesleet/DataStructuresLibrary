package Algorithms;

public class Search<E> implements Comparable<T> {

    public boolean containsBinarySearch(E[] listToSearch, E toFind) {
        int lo = 0;
        int hi = listToSearch.length - 1;

        while (lo < hi) {
            int mid = hi + lo / 2;
            if (toFind == listToSearch[mid]) {
                return true;
            }
            if (toFind.compareTo(listToSearch[mid]) < 0 {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }
}
