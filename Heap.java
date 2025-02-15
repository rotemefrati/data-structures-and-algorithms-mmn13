import java.util.Arrays;
import java.util.Random;

public class Heap {
    private int[] heap; // Array to store the heap
    private int heapSize; // Size of the heap
    private int comparisons, copies; // Counters for comparisons and copies
    private final Random rand; // Random number generator

    public Heap(int size) {
        heap = new int[size];
        heapSize = size;
        rand = new Random();
        comparisons = 0;
        copies = 0;
    }

    // d-ary heap sort
    public void heapSort(int d) {
        comparisons = 0;
        copies = 0;
        buildMaxHeap(d);
        // Swap the root with the last element and maxHeapify the root
        for(int i = heap.length - 1; i >= 1; i--) {
            swap(0, i);
            heapSize--;
            maxHeapify(0, d);
        }
    }

    // Fill the heap with random numbers
    public void fillHeap() {
        for(int i = 0; i < heapSize; i++) {
            int MAX_RAND = 1024;
            heap[i] = rand.nextInt(MAX_RAND);
        }
    }

    // Returns a copy of the heap array
    public int[] getHeap() {
        return Arrays.copyOf(heap, heapSize);
    }

    // Reset the heap to the original array
    public void resetHeap(int[] originalHeap) {
        heap = Arrays.copyOf(originalHeap, originalHeap.length);
        heapSize = originalHeap.length;
        comparisons = 0;
        copies = 0;
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getCopies() {
        return copies;
    }

    private void maxHeapify(int i, int d) {
        int largest = i; // Initialize largest as root
        for(int k = 0; k < d; k++) { // Iterate over all d children of the node
            int childIndex = child(d, i, k); // Calculate the index of the child
            if(childIndex < heapSize) { // Check if the child is within the heap
                comparisons++;
                if(heap[childIndex] > heap[largest]) { // Compare the child with the largest
                    largest = childIndex; // Update the largest if the child is larger
                }
            }
        }
        // Swap and recursively heapify if the largest is not the current node
        if(largest != i) {
            swap(i, largest);
            maxHeapify(largest, d);
        }
    }

    private void buildMaxHeap(int d) {
        heapSize = heap.length;
        for(int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(i, d);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
        copies += 3; // Increment the copy counter (3 assignments per swap)
    }

    // Calculates the index of the k-th child of node i in a d-ary heap
    private int child(int d, int i, int k) {
        return d*i+1+k;
    }
}