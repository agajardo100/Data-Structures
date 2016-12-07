import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueList<AnyType> implements Iterable<AnyType>{
	
	private Node<AnyType> rear;  	// Access point of the Queue
	private int size;				// Number of elements in Queue
	
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
	
	/* Return the size of the Queue	*/
	public int size(){
		return size;
	}
	
	/* Check if Queue is empty */
	public boolean isEmpty(){
		return rear.next == null;
	}
	
	/*
	 * Add an object to the end of the Queue
	 * Runtime O(1)
	 */
	public void enQ(AnyType item){
		if (!isEmpty())
			rear = rear.next = new Node<AnyType>(item, rear.next);
		else
			rear.next = rear = new Node<AnyType>(item);
		size++;
	}
	
	/*
	 * Return and remove object at the front of the Queue.
	 * Runtime O(1)
	 */
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

	/*
	 * Returns the element at the front of Queue, but does not remove it
	 * Runtime O(1)
	 */
	public AnyType peek(){
		if (isEmpty())
			throw new NoSuchElementException("Queue is empty");
		return rear.next.data;
		
	}
	
	/* 
	 * Return Queue as a single string
	 */
	@Override
	public String toString(){
		StringBuilder s = new StringBuilder();
		for (AnyType element: this)
			s.append(element.toString() + " ");
        return s.toString();
    } 
	
	/* 
	 * Returns an iterator that goes through elements Queue
	 */
	@Override
	public Iterator<AnyType> iterator() {
		return new QueueIterator();
	}
		
	private class QueueIterator implements Iterator<AnyType> {
		private Node<AnyType> current = rear.next;

	        public boolean hasNext(){ 
	        	return current != null;
	        }
	        
	        /* Unimplemented function */
	        public void remove(){ 
	        	throw new UnsupportedOperationException();
	        }

	        public AnyType next() {
	            if (!hasNext()) 
	            	throw new NoSuchElementException();
	            AnyType data = current.data;
	            current = current.next; 
	            return data;
	        }
	}
}
