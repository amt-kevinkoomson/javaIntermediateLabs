package WeekTwo.BehaviorialPatterns;

import java.util.Arrays;

// Strategy interface for sorting algorithms
interface SortingStrategy {
    void sort(int[] array);
}

// Concrete class implementing Bubble Sort algorithm
class BubbleSort implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap elements if they are in the wrong order
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}

// Concrete class implementing Quick Sort algorithm
class QuickSort implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                // Swap elements if they are in the wrong order
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // Swap elements
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}

// Context class that uses a Strategy for sorting
class SortContext {
    private SortingStrategy sortingStrategy;

    public SortContext(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void performSort(int[] array) {
        sortingStrategy.sort(array);
    }
}

// Client code to use sorting strategies
public class StrategyClient {
    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};

        // Bubble Sort strategy
        SortingStrategy bubbleSort = new BubbleSort();
        SortContext bubbleSortContext = new SortContext(bubbleSort);
        bubbleSortContext.performSort(array.clone());
        System.out.println("After Bubble Sort: " + Arrays.toString(array));

        // Quick Sort strategy
        SortingStrategy quickSort = new QuickSort();
        SortContext quickSortContext = new SortContext(quickSort);
        quickSortContext.performSort(array.clone());
        System.out.println("After Quick Sort: " + Arrays.toString(array));
    }
}

