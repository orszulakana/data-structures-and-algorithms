package algorithms;

public class BubbleSort {

    public void bubbleSortSimpleCase(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[i + 1]) {
                    swapElements(array, j, j + 1);
                }
            }
        }
    }

    private void swapElements(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /*
    Outer loop stops when no changes in the inner loop
    Inner loop does not check the last sorted elements
     */
    public void bubbleSortOptimized(int[] array) {
        int arraySize = array.length - 1;
        while (arraySize > 0) {
            int last = 0;
            for (int j = 0; j < arraySize; j++) {
                if (array[j] > array[j + 1]) {
                    swapElements(array, j, j + 1);
                    last = j;
                }
            }
            arraySize = last;
        }
    }
}
