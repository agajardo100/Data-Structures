import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackList<AnyType> implements Iterable<AnyType> {
	
	private Node<AnyType> top;		//Top of stack
	private int size;				//Number of elements in Stack
	
	protected class Node<E> {
		public E data;
		public Node<E> next;
		
		public Node(E item, Node<E> n){
			data = item;
			next = n;
		}
	}
	
	/* Constructor */
	public StackList(){
		top = null;
		size = 0;
	}
	
	/* Returns the number of elements in Stack */
	public int size(){
		return size;
	}
	
	/* Returns True if top is null, otherwise
	 * return false.
	 */
	public boolean isEmpty(){
		return top == null;
	}
	
	/*
	 * Makes Stack logically empty setting top Node equal to null
	 */
	public void makeEmpty(){
		if (isEmpty())
			throw new NoSuchElementException("Stack is already empty");
		top = null;
		size = 0;
	}
	
	/* Append new element to Stack and set it as the top
	 * Best/Avg/Worst Runtime: O(1)
	 */
	public void push(AnyType item){
		top = new Node<AnyType>(item, top);
		size++;
	}
	
	/* Remove top element off the Stack and return it 
	 * Best/Avg/Worst Runtime: O(1)
	 */
	public AnyType pop(){
		if (isEmpty())
			throw new NoSuchElementException("Stack is empty");
		AnyType oldTop = top.data;
		top = top.next;
		size--;
		return oldTop;
	}
	
	/* Return the top element 
	 * Best/Avg/Worst Runtime: O(1)
	 */
	public AnyType peek(){
		if (isEmpty())
			throw new NoSuchElementException("Stack is empty");
		return top.data;
	}
	
	/* Return String representation of Stack */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
	    for (AnyType element : this)
	    	s.append(element.toString() + " ");
	    return s.toString();
	    }
	
	/* 
	 * Returns an Interator that goes through the Stack, 
	 * starting at the top 
	 */
	@Override
	public Iterator<AnyType> iterator() {
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator<AnyType>{
		private Node<AnyType> current = top;
		
		@Override
		public boolean hasNext(){ 
        	return current != null;
        }
		
		@Override
        public AnyType next() {
            if (!hasNext()) 
            	throw new NoSuchElementException();
            AnyType data = current.data;
            current = current.next; 
            return data;
		}
	}
	
	
}