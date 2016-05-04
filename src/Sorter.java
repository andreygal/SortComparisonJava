/**
 * Created by andre on 5/4/2016.
 */
public class Sorter {
    static SortTimer t = new SortTimer();
    public static <T extends  Comparable<T>> void sort (Sorts sortType, T[] inputArr) {
        switch (sortType) {
            case MERGESORT:
                showSort(sortType, new MergeSort(), inputArr);
                break;
            case INSERTIONSORT:
                showSort(sortType, new InsertionSort(), inputArr);
                break;
            case QUICKSORT:
                showSort(sortType, new Quicksort(), inputArr);
                break;
        }
    }
    private static <T extends Comparable<T>> void firstLast(T[] inputArr) {
        int i, n = inputArr.length, m = 5;
        // if the vector size is 10 or less, just
        // output the whole vector
        if (n <= 10)
            m = n;
        // output m elements
        for (i = 0; i < m; i++)
            System.out.print(inputArr[i] + "  ");
        // for n > 10, output "..." and the last 5 elements
        if (n > 10) {
            System.out.print(". . .  ");
            for (i = n - 5; i < n; i++)
                System.out.print(inputArr[i] + "  ");
        }
        System.out.println();
    }
    private static <T> void reverseArr(T[] inputArr) {
        int mid = inputArr.length / 2;
        int end = inputArr.length - 1;
        T temp;
        if (mid == 0 || inputArr == null) {
            return;
        }
        for (int i = 0; i < mid; i++) {
            temp = inputArr[i];
            inputArr[i] = inputArr[end - i];
            inputArr[end] = temp;
        }
    }
    private static <T extends Comparable<T>> void showSort(Sorts sortType, Sort testSort, T[] inputArr) {
        System.out.println("Initial state: "); firstLast(inputArr);
        t.start();
        testSort.sort(inputArr);
        t.stop();
        System.out.println("After sorting "); firstLast(inputArr);
        System.out.println(sortType + " took " + t.getTime() + " seconds sorting a shuffled array");
        System.out.println();

        //test the sort with a sorted array
        System.out.println("Initial state: "); firstLast(inputArr);
        System.out.println("After sorting "); firstLast(inputArr);
        t.start();
        testSort.sort(inputArr);
        t.stop();
        System.out.println(sortType + " took " + t.getTime() + " seconds sorting an already sorted array");
        System.out.println();

        //reverse the array and tested the sort with an a reverse sorted input
        reverseArr(inputArr);
        System.out.println("Initial state: "); firstLast(inputArr);
        t.start();
        testSort.sort(inputArr);
        t.stop();
        System.out.println("After sorting "); firstLast(inputArr);
        System.out.println(sortType + " took " + t.getTime() + " seconds sorting a reverse sorted array");
        System.out.println();
    }
}
