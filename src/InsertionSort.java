/**
 * Created by andre on 5/2/2016.
 */
public class InsertionSort extends Sort {
    public <T extends Comparable<T>> void sort (T[] inArr) {
        int i, j, n = inArr.length;
        T key;
        for (i = 1; i < n; i++) {
            key = inArr[i];
            j = i - 1;
            while (j >= 0 && (key.compareTo(inArr[j]) < 0)) {
                inArr[j + 1] = inArr[j];
                j--;
            }
            inArr[j + 1] = key;
        }
    }
}
