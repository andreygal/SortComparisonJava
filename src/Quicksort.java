import java.util.Random;

/**
 * Created by andre on 5/2/2016.
 */
public class Quicksort extends Sort {
    public <T extends Comparable<T>> void sort(T[] inputArr) {
        sort(inputArr, 0, inputArr.length - 1);
    }
    private <T extends Comparable<T>> void sort (T[] inputArr, int begin, int end) {
        if (begin < end) {
            int pivotIndex = randPartition(inputArr, begin, end);
            sort(inputArr, begin, pivotIndex - 1);
            sort(inputArr, pivotIndex + 1, end);
        }
    }
    private <T extends Comparable<T>> int partition (T[] inputArr, int begin, int end) {
        T pivot = inputArr[end];
        T temp;
        int index = begin - 1;
        for (int j = begin; j < end; j++) {
            if (inputArr[j].compareTo(pivot) >= 0) {
                index++;
                temp = inputArr[j];
                inputArr[j] = inputArr[index];
                inputArr[index] = temp;
            }
        }
        temp = inputArr[index + 1];
        inputArr[index + 1] = inputArr[end];
        inputArr[end] = temp;
        return ++index;
    }
    private <T extends Comparable<T>> int randPartition (T[] inputArr, int begin, int end) {
        Random rand = new Random();
        int pivotIndex = begin + (rand.nextInt(end - begin + 1));
        T temp = inputArr[pivotIndex];
        inputArr[pivotIndex] = inputArr[end];
        inputArr[end] = temp;
        return partition(inputArr, begin, end);
    }
}
