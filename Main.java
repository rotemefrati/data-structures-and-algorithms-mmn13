public class Main {
    public static void main(String[] args) {
        // Create three heaps of sizes 50, 100, and 200
        Heap A = new Heap(50);
        Heap B = new Heap(100);
        Heap C = new Heap(200);

        // Fill the heaps with random numbers
        A.fillHeap();
        B.fillHeap();
        C.fillHeap();

        // Save the original heaps for resetting
        int[] originalA = A.getHeap();
        int[] originalB = B.getHeap();
        int[] originalC = C.getHeap();

        // Test the heap sort algorithm for d = 2, 3, 4, 5 on heaps A, B, and C
        System.out.println("Heap A:");
        for(int d = 2; d <= 5; d++) {
            A.heapSort(d);
            System.out.println(A.getComparisons() + " comparisons for d=" + d);
            System.out.println(A.getCopies() + " copies for d=" + d);
            A.resetHeap(originalA);
        }

        System.out.println("-------------------------------------");

        System.out.println("Heap B:");
        for(int d = 2; d <= 5; d++) {
            B.heapSort(d);
            System.out.println(B.getComparisons() + " comparisons for d=" + d);
            System.out.println(B.getCopies() + " copies for d=" + d);
            B.resetHeap(originalB);
        }

        System.out.println("-------------------------------------");

        System.out.println("Heap C:");
        for(int d = 2; d <= 5; d++) {
            C.heapSort(d);
            System.out.println(C.getComparisons() + " comparisons for d=" + d);
            System.out.println(C.getCopies() + " copies for d=" + d);
            C.resetHeap(originalC);
        }
    }
}