import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final int ARRAY_SIZE = 100000;
        Random rand = new Random();
        Integer[] array1 = new Integer[ARRAY_SIZE];
        Integer[] array2 = new Integer[ARRAY_SIZE];
        Integer[] array3 = new Integer[ARRAY_SIZE];
        //initialize the arrays
        for (int i = 0; i < ARRAY_SIZE; i++) {
            Integer randInt = rand.nextInt(ARRAY_SIZE);
            array1[i] = randInt;
            array2[i] = randInt;
            array3[i] = randInt;
        }
        Sorter.sort(Sorts.MERGESORT, array1);
        Sorter.sort(Sorts.INSERTIONSORT, array2);
        Sorter.sort(Sorts.QUICKSORT, array3);
    }
}
