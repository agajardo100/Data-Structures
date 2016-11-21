import java.util.NoSuchElementException;

public class QueueList<AnyType> {
	
	private Node<AnyType> rear;  	// Access point of the queue
	private int size;				// Number of elements in queue
	
	protected class Node<E> {
		public E data;
		public Node<E> next;
		
		public Node(E item){
			data = item;
		}
		
		public Node(E item, Node<E> n){
			data = item;
			next = n;
		}
	}
	
	/* Constructor */
	public QueueList(){
		rear = null;
		size = 0;
	}
	
	/* Check if queue is empty */
	public boolean isEmpty(){
		return rear.next == null;
	}
	
	public void enQ(AnyType item){
		if (!isEmpty())
			rear = rear.next = new Node<AnyType>(item, rear.next);
		else //if Queue was empty
			rear.next = rear = new Node<AnyType>(item);
		size++;
	}
	
	public AnyType deQ(){
		if(isEmpty())
			throw new NoSuchElementException("Queue is empty");
		AnyType oldFront = rear.next.data;
		if (rear == rear.next)
			rear = null;
		else 
			rear.next = rear.next.next;
		size--;
		return oldFront;
	}
}
