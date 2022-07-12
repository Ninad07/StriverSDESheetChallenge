
public class Solution {
    private static int[] heap;
    private static int size;
    
    private static boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }
    
    private static int getParentIndex(int index) {
        return (index - 1) / 2;
    }
    
    private static boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }
    
    private static boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }
    
    private static int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }
    
    private static int getRightChildIndex(int index) {
        return 2 * index + 2;
    }
    
    private static void swap(int childIndex, int parentIndex) {
        int temp = heap[childIndex];
        heap[childIndex] = heap[parentIndex];
        heap[parentIndex] = temp;
    }
    
    private static void add(int data) {
        heap[size++] = data;
        heapifyUp();
    }
    
    private static int poll() {
        int item = heap[0];
        size--;
        heap[0] = heap[size];
        heapifyDown();
        return item;
    }
    
    private static void heapifyUp() {
        int index = size - 1;
 
        while(hasParent(index) && heap[getParentIndex(index)] > heap[index]) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }
    
    private static void heapifyDown() {
        int index = 0;
        while(hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && heap[getRightChildIndex(index)] < heap[smallerChildIndex]) {
                smallerChildIndex = getRightChildIndex(index);
            }
            
            if(heap[index] < heap[smallerChildIndex]) {
                break;
            }
            swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }
    
    static int[] minHeap(int n, int[][] q) {
        heap = new int[1000005];
        size = 0;
        int length = 0;
        for(int[] a : q) {
            if(a.length == 1) length++;
        }
        int[] ans = new int[length];
        int index = 0;
        
        for(int i = 0; i < q.length; i++) {
            if(q[i].length == 1) {
                ans[index++] = poll();
            } else {
                add(q[i][1]);
            }
        }
        return ans;
    }
}
