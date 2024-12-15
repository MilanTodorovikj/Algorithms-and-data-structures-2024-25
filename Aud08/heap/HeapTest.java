package Aud08.heap;

import java.util.Random;

public class HeapTest {

    public static void main(String[] args) {
        int i;
        Random r = new Random(System.currentTimeMillis());

        Heap<Integer> heap = new Heap<Integer>(10);

        for (i = 0; i < 10; i++)
            heap.setElement(i, r.nextInt(100));

        // Print initial values in heap
        for (i = 0; i < 10; i++)
            System.out.println(heap.getAt(i));

        System.out.println();

        heap.heapSort();

        // Check if heap is sorted
        for (i = 1; i < 10; i++) {
            if (heap.getAt(i - 1).compareTo(heap.getAt(i)) > 0)
                System.out.println("ERROR");
        }

        // Print heap after sorting
        for (i = 0; i < 10; i++)
            System.out.println(heap.getAt(i));
    }

}
