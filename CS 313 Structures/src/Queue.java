import java.util.NoSuchElementException;

/*  Array Implementation of a generic queue class  */

@SuppressWarnings("unchecked")
public class Queue<T> {
	
	private T[] arr;			// Underlying array that contains elements of Queue
	private int max;			// The capacity of arr
	private int count;			// Number of elements in Queue
	private int front, rear;	// Indexes of the front and rear elements
	
	/*
	 * Default Constructor creates Queue with default size of 20
	 */
	public Queue(){
		max = 10;
		count = 0;
		front = 0;
		rear = -1;
		arr = (T[]) new Object[20];
	}
	
	/*
	 * Constructor that accepts a size value
	 */
	public Queue(int s){
		if (s < 0)
			throw new NegativeArraySizeException("Cannot create Queue of negative size.");
		max = s;
		arr = (T[]) new Object[max];
		count = 0;
		front = 0;
		rear = -1;
		
	}
	
	/* Check is Queue is empty */
	public boolean isEmpty(){
		return count == 0;
	}
	
	/* Return number of elements in queue */
	public int size(){
		return count;	
	}
	
	/*
	 * Remove front element from queue and return it
	 * Runtime: O(1)
	 */
	public T deQ() throws Exception{
		if (isEmpty())
			throw new NoSuchElementException("Queue is empty");
		T oldFront = arr[front];
		front = (front +1) % max;
		count--;
		return oldFront;
	}
	
	/*
	 * Add element to end of queue.  If underlying array is full,
	 * double the size.
	 * 
	 * Best / Average Case: O(1)
	 * Worst Case: O(n)
	 */
	public void enQ(T data){
		if (count == max ){ //if Queue and array are full, resize
			T[] newArr = (T[]) new Object[2*max]; 
			for(int i = 0; i < max; i++){
				newArr[i] = arr[front];
				front = (front +1) % max;
			}
			arr = newArr; 
			rear = max -1;
			front = 0; 
			max *= 2;
			
		}
		rear = (rear +1) % max;
		arr[rear] = data;
		count++;
	}
	
	/* Return element in the front of the queue */
	public T peek(){
		if (isEmpty())
			throw new NoSuchElementException("Queue is empty");
		return arr[front];
	}
	
	/* Make Queue logically empty */
	public void makeEmpty(){
		if (isEmpty())
			throw new NoSuchElementException("Queue is already empty");
		count = 0;
		front = 0 ;
		rear = -1;
	}
	

	public static void main(String args[]) throws Exception{
		Queue<Integer>myQueue = new Queue<Integer>();
		
		System.out.println("Is myQueue Empty?");
		System.out.println(myQueue.isEmpty());  //true
		
		myQueue.enQ(4);
		myQueue.enQ(3);
		myQueue.enQ(8);
		myQueue.enQ(9);
		myQueue.enQ(0);
		
		System.out.println("Dequeue 3 elements from myQueue:");
		System.out.println(myQueue.deQ());	//4
		System.out.println(myQueue.deQ());	//3
		System.out.println(myQueue.deQ());	//8
		
		System.out.println("Is myQueue Empty?");
		System.out.println(myQueue.isEmpty());	//false
		
		System.out.println("What is at the front of myQueue?");
		System.out.println(myQueue.peek());  	//9
		
		System.out.println("What is the size of myQueue?");
		System.out.println(myQueue.size());		//2
	}

}
