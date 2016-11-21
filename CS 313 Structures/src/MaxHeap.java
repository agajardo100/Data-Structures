import java.util.Arrays;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class MaxHeap <AnyType extends Comparable<AnyType>> {
	
	private int heapSize;  		// Number of elements in heap
	private AnyType[] heap;		// The heap array
	private int capacity;		// The fixed capacity of array
	
	/*
	 * Construct an empty Heap with default capacity of 100
	 */
	public MaxHeap(){
		heapSize = 0;
		capacity = 100;
		heap = (AnyType[]) new Comparable[capacity +1];
	}
	
	/*
	 * Construct an empty Heap of a specified capacity
	 */
	public MaxHeap(int size){
		heapSize = 0;
		capacity = size;
		heap = (AnyType[]) new Comparable[capacity + 1];
	}
	
	/*
	 * Construct a max heap from an unsorted array
	 * As elements are added to Heap Array, call on Heapify Up
	 * to maintain heap order property
	 */
	public MaxHeap(AnyType[] Arr){
		heapSize = 0;
		heap = (AnyType[]) new Comparable[Arr.length+1];
		for (int i = 0; i < Arr.length; i++){
			heap[i+1] = Arr[i];
			heapSize++;
			heapifyUp(i+1);
		}
	}
	
	/*
	 * Check if Heap is empty
	 */
	public boolean isEmpty(){
		return (heapSize==0);
	}
	
	/*
	 * Returns and removes max element (root) and replaces it with last child node
	 * Goes through
	 * Average/Worst Case: O (lg n)
	 */
	public AnyType deleteMax(){
		if(heapSize == 0)
			throw new NoSuchElementException("Max Heap is empty");
		AnyType deleted = heap[1];
		heap[1] = heap[heapSize--]; //last leaf becomes root
		heapifyDown(1);
		return deleted;
	}
	
	/*
	 * Insert element into Heap Array.
	 * heapifyUp to maintain heap order property
	 * Best/Average Case: 	O( 1 )
	 * Worst Case: 			O(lg n)
	 */
	public void insert(AnyType toInsert){
		if (heapSize == capacity) // if Heap is full, resize
			heap = Arrays.copyOf(heap, capacity + 32);
		heap[++heapSize] = toInsert;
		heapifyUp(heapSize);
		
	}
	
	/*
	 * Private method to maintain the Max Heap order property
	 * Take an index and compare to parent index. 
	 * If larger than parent, swap.
	 */
	private void heapifyUp(int index) {
		while (index >= 1){
			if (heap[index / 2].compareTo(heap[index]) < 0){ // check if parent is less than child
				swap(index, index/2);
				index /= 2;
			}
		}
	}
	
	/*
	 * Private method to maintain Heap order property
	 * Take an index and compare to its two children
	 * If the parent is larger than its children, return, 
	 * else swap with largest child and follow that index down.
	 */
	private void heapifyDown(int index){
		while (index <= heapSize/2){
			if (heap[index].compareTo(heap[index*2])> 0 && heap[index].compareTo(heap[index*2+1]) > 0)
				return;  
			else if (heap[index*2].compareTo(heap[(index*2+1)]) >= 0){ //if Left child is greater than right
				swap(index,index*2);
				index *= 2;
			}
			else{ //swap with right child
				swap(index, index*2+1);  
				index = (index * 2) +1;	
			}
		}
	}
	
	/*
	 * Swaps two elements in Heap Array at given positions.
	 */
	private void swap(int posA, int posB){
		AnyType temp = heap[posB];
		heap[posB] = heap[posA];
		heap[posA] = temp;
	}
	
	/*
	 * Print to console 
	 */
	public void print(){
		System.out.println("  ROOT  : " + heap[1] + " LEFT CHILD : " +heap[2]+ " RIGHT CHILD :" + heap[3]);
        for (int i = 2; i <= heapSize / 2; i++ ){
            System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " + heap[2*i]
                  + " RIGHT CHILD :" + heap[2 * i  + 1]);
            System.out.println();
        }
    }
}
