import java.util.NoSuchElementException;

public class LinkedList<T extends Comparable<T>> {
	
	private int size;
	private Node<T> head;
	
	public class Node<E> {
		private E data;
		private Node<E> next;
		
		public Node(E item){
			data = item;
		}
		
		public Node(E item, Node<E> n){
			data = item;
			next = n;
		}
	}
	
	/* Construtor */
	public LinkedList(){
		head = null;
		size = 0;
	}
	
	/* Check if LinkedList is empty */
	public boolean isEmpty(){
		return head.next == null;
	}
	
	/* Return the number of elements in LinkedList */
	public int size() {
		return size;
	}
	
	/* Add an element to beginning of LinkedList */
	public void prepend(T item){ 
		head = new Node<T>(item, head);
		size++;
	}
	
	/* Add an element to end of LinkedList */
	public void append(T item){
		Node<T> curr = head;
		while(curr.next != null)
			curr = curr.next;
		curr.next = new Node<T>(item);
		size++;
	}
	
	/**/
	public void insert(T item){
		Node<T> prev = null;
		Node<T> curr = head;
		while((curr!=null) && (curr.data.compareTo(item) < 0)){
			prev = curr;
			curr = curr.next;
		}
		prev.next = new Node<T>(item, curr);
	}
	
	/* Searches for and deletes specified item in LinkedList */
	public void remove(T item){
		if (head == null)
			throw new NoSuchElementException("LinkedList is empty");
		Node<T> prev = null;
		Node<T> curr = head;
		while(!(curr.data.equals(item)) && curr!=null) {
			prev = curr;
			curr = curr.next;
		}
		if (curr == null)
			throw new NoSuchElementException("Specified item not found in list.");
		prev.next = curr.next;
	}
	
	
}
