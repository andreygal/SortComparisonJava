import java.util.ArrayList;

public class MergeSort extends Sort {
    public <T extends Comparable<T>> void sort(T[] inArr) {
        sort(inArr, 0, inArr.length);
    }
    private <T extends Comparable<T>> void merge(T[] inArr, int first, int mid, int last) {
        ArrayList<Object> tmp = new ArrayList<>();
        int indexA = first;
        int indexB = mid;

        while (indexA < mid && indexB < last) {
            if(inArr[indexA].compareTo(inArr[indexB]) < 0)
                tmp.add(inArr[indexA++]);
            else
                tmp.add(inArr[indexB++]);
        }
        while (indexA < mid) {
            tmp.add(inArr[indexA++]);
        }
        while (indexB < last) {
            tmp.add(inArr[indexB++]);
        }
        indexA = first;
        for(Object elem : tmp) {
            inArr[indexA++] = (T) elem;
        }
    }
    private <T extends Comparable<T>> void sort(T[] inArr, int first, int last) {
        if (first + 1 < last) {
            //compute the midpoint
            int mid = (first + last) / 2;
            //sort the left and right sides, then merge them
            sort(inArr, first, mid);
            sort(inArr, mid, last);
            merge(inArr, first, mid, last);
        }
    }
}
