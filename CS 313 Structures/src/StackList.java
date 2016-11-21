import java.util.NoSuchElementException;

public class StackList<T extends Comparable<T>> {
	
	Node<T> top;		//Top of stack
	
	protected class Node<E> {
		public E data;
		public Node<E> next;
		
		public Node(E item, Node<E> n){
			data = item;
			next = n;
		}
	}
		
		public boolean isEmpty(){
			return top == null;
		}
		
		public void push(T item){
			top = new Node<T>(item, top);
		}
		
		public T pop(){
			T pop = top.data;
			top = top.next;
			return pop;
		}
		
		public void makeEmpty(){
			if (isEmpty())
				throw new NoSuchElementException("Stack is already empty");
			top = null;
		}
		
		public T peek(){
			if (isEmpty())
				throw new NoSuchElementException("Stack is empty");
			return top.data;
		}
		
	}