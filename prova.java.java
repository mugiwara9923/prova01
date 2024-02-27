import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class SortingAlgorithms {

    public static void main(String[] args) {
        generateNumbersToFile("sorted.txt", 1000000, true); 
        generateNumbersToFile("reversed.txt", 1000000, false); 
        generateNumbersToFile("random.txt", 1000000, false); 

        int[] sortedArray = readFromFile("sorted.txt");
        int[] reversedArray = readFromFile("reversed.txt");
        int[] randomArray = readFromFile("random.txt");

        testAndMeasure("Bubble Sort", sortedArray.clone());
        testAndMeasure("Bubble Sort", reversedArray.clone());
        testAndMeasure("Bubble Sort", randomArray.clone());

        testAndMeasure("Insertion Sort", sortedArray.clone());
        testAndMeasure("Insertion Sort", reversedArray.clone());
        testAndMeasure("Insertion Sort", randomArray.clone());

        testAndMeasure("Selection Sort", sortedArray.clone());
        testAndMeasure("Selection Sort", reversedArray.clone());
        testAndMeasure("Selection Sort", randomArray.clone());

        testAndMeasure("Merge Sort", sortedArray.clone());
        testAndMeasure("Merge Sort", reversedArray.clone());
        testAndMeasure("Merge Sort", randomArray.clone());

        testAndMeasure("Quick Sort", sortedArray.clone());
        testAndMeasure("Quick Sort", reversedArray.clone());
        testAndMeasure("Quick Sort", randomArray.clone());

        testAndMeasure("Heap Sort", sortedArray.clone());
        testAndMeasure("Heap Sort", reversedArray.clone());
        testAndMeasure("Heap Sort", randomArray.clone());
    }

    public static void testAndMeasure(String algorithmName, int[] array) {
        long startTime = System.currentTimeMillis();
        switch (algorithmName) {
            case "Bubble Sort":
                bubbleSort(array);
                break;
            case "Insertion Sort":
                insertionSort(array);
                break;
            case "Selection Sort":
                selectionSort(array);
                break;
            case "Merge Sort":
                mergeSort(array);
                break;
            case "Quick Sort":
                quickSort(array, 0, array.length - 1);
                break;
            case "Heap Sort":
                heapSort(array);
                break;
            default:
                System.out.println("Invalid algorithm name");
                return;
        }
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Algorithm: " + algorithmName);
        System.out.println("Execution Time (ms): " + executionTime);
        System.out.println();
    }

    public static void generateNumbersToFile(String filename, int count, boolean sorted) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 1; i <= count; i++) {
                writer.write(Integer.toString(sorted ? i : count - i + 1));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] readFromFile(String filename) {
        int[] array = new int[1000000];
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null && i < 1000000) {
                array[i] = Integer.parseInt(line.trim());
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void mergeSort(int[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;
            int[] left = Arrays.copyOfRange(array, 0, mid);
            int[] right = Arrays.copyOfRange(array, mid, array.length);
            mergeSort(left);
            mergeSort(right);
            merge(array, left, right);
        }
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    public static void heapSort(int[] array) {
    int n = array.length;

    // Build heap (rearrange array)
    for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(array, n, i);
    }

    // One by one extract an element from heap
    for (int i = n - 1; i >= 0; i--) {
        // Move current root to end
        int temp = array[0];
        array[0] = array[i];
        array[i] = temp;

        // call max heapify on the reduced heap
        heapify(array, i, 0);
    }
}

private static void heapify(int[] array, int n, int i) {
    int largest = i; // Initialize largest as root
    int left = 2 * i + 1; // left = 2*i + 1
    int right = 2 * i + 2; // right = 2*i + 2

    // If left child is larger than root
    if (left < n && array[left] > array[largest]) {
        largest = left;
    }

    // If right child is larger than largest so far
    if (right < n && array[right] > array[largest]) {
        largest = right;
    }

    // If largest is not root
    if (largest != i) {
        int swap = array[i];
        array[i] = array[largest];
        array[largest] = swap;

        // Recursively heapify the affected sub-tree
        heapify(array, n, largest);
    }
}

