import java.util.EmptyStackException;

/* Array implementation of a generic stack */

@SuppressWarnings("unchecked")
public class Stack<T> {
	private T[] data;	// Contains elements of stack
	private int top;	// Index of element at the top of stack
	private int max;	// Number of elements in stack
	
	/* 
	 * Initialize an empty stck with default
	 * capacity of 20.
	 */
	public Stack(){
		max = 20;
		data = (T[]) new Object[20];
		top = -1;
	}
	
	/* 
	 * Initialize empty stack with specified capacity. 
	 */
	public Stack(int capacity){
		max = capacity;
		data = (T[]) new Object[50];
		top = -1;
	}
	
	/* 
	 * Add item to top of stack.
	 * If stack is empty, double the capacity
	 * 
	 * Best / Average Case: O(1)
	 * Worst Case: O(n)
	 */
	public void push(T toAdd){
		if (top == max-1){ // resize if stack is full
			T[] newData = (T[]) new Object[2*max];
			for (int i = 0; i < max; i++)
				newData[i] = data[i];
			max *= 2;
			data = newData;
		}
		data[++top] = toAdd;
	}
	
	/* 
	 * If stack is empty return true, else return false. 
	 */
	public boolean isEmpty(){
		return (top == -1);
	}
	
	/*
	 * Removes and returns element at the top 
	 * of the stack, which was the most recently added
	 * 
	 * Best/Average/Worst Case: O(1)
	 */
	public T pop(){
		if (isEmpty())
			throw new EmptyStackException();
		return data[top--];
	}
	
	/*
	 * Return element at the top of the stack.
	 * 
	 * Best/Average/Worst Case: O(1)
	 */
	public T peek(){
		if (isEmpty())
			throw new EmptyStackException();
		return data[top];
	}
	
	
	@Override
	public String toString(){
		StringBuilder s = new StringBuilder();
		for(int i = top; i <= 0; i--)
			s.append(data[i].toString()+" ");
		return s.toString();
	}
	
	
	
	
}
