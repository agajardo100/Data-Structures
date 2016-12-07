import java.util.NoSuchElementException;

public class AVLTree <AnyType extends Comparable<AnyType>> {
	
	private avlNode<AnyType> root;
	
		protected class avlNode<E>{
			protected E data;					// Generic data
			protected int height;				// The height of the node
			protected avlNode<E> rightChild;	
			protected avlNode<E> leftChild;
		
			public avlNode(){
				this(null,null,null);
				height = 0;
			}
			
			public avlNode(E element){
				this(element, null, null);
				height = 0;
			}
			
			public avlNode(E element, avlNode<E>left, avlNode<E>right){
				data = element;
				leftChild = left;
				rightChild = right;
				height = 0;
			}
		}  //End avlNode class
		
	/* Constructor */
	public AVLTree(){
		root = null;
	}
	
	/* Check if tree is empty */
    public boolean isEmpty(){
        return root == null;
    }

    /* Make the tree logically empty */
    public void makeEmpty(){
        root = null;
    }
    
	/*
	 * Internal method that returns height 
	 * of a subtree 
	 */
	private int height(avlNode<AnyType> t){
		return  t== null ? -1: t.height; 
	}
	
	/* Insert element into AVL Tree */ 
	public void insert(AnyType element) throws Exception{
		root= insert(element, root);
	}
	/* Recursive private method to insert into AVL Tree */
	private avlNode<AnyType> insert(AnyType element, avlNode<AnyType> t) throws Exception{
		if (t==null)  //found location to insert
			t = new avlNode<AnyType>(element);
		
		else if (element.compareTo(t.data) < 0 ) {
			t.leftChild = insert(element, t.leftChild);
			
			if( Math.abs(height(t.leftChild) - height(t.rightChild)) > 1) //check if subtree unbalanced
				if( element.compareTo(t.leftChild.data) < 0)
					t = rotateWithLeft(t);
				else
					t = doubleRotateLeft(t);
		}
		
		else if(element.compareTo(t.data) > 0){
			t.rightChild = insert(element, t.rightChild);
			
			if (Math.abs(height(t.rightChild) - height(t.leftChild)) > 1) //check if subtree unbalanced
				if (element.compareTo(t.rightChild.data) > 0)
					t = rotateWithRight(t);
				else
					t = doubleRotateRight(t);
		}
		else
			throw new Exception("Duplicate Item Exception");
		t.height = Math.max(height(t.leftChild), height(t.rightChild)) + 1; //update the heights of parents
		return t;
	}
	
	
	/*
	 * 
	 */
	private avlNode<AnyType> rotateWithRight(avlNode<AnyType> t){
		avlNode<AnyType> temp = t.rightChild;
		t.rightChild = temp.leftChild;
		temp.leftChild = t;
		t.height = Math.max(height(t.leftChild),height(t.rightChild)) + 1;
		temp.height = Math.max(t.height, height(temp.rightChild)) +1;
		return temp;
	}
	
	/*
	 * 
	 */
	private avlNode<AnyType> rotateWithLeft(avlNode<AnyType> t){
		avlNode<AnyType> temp = t.leftChild;
		t.leftChild = temp.rightChild;
		temp.rightChild = t;
		t.height = Math.max(height(t.rightChild),height(t.leftChild)) + 1;
		temp.height = Math.max(t.height, height(temp.leftChild)) +1;
		return temp;
	}
	
	/*
	 * First rotate right child with its left child
	 * then rotate parent with right child
	 */
	private avlNode<AnyType> doubleRotateRight(avlNode<AnyType> t){
		t.rightChild = rotateWithLeft(t.rightChild);
		return rotateWithRight(t);
	}
	
	/*
	 * First rotate left child with its right child
	 * Then rotate left with parent
	 */
	private avlNode<AnyType> doubleRotateLeft(avlNode<AnyType> t){
		t.leftChild = rotateWithRight(t.leftChild);
		return rotateWithLeft(t);
	}
	
	/*
	 * Public method to delete an element from AVL Tree.
	 * Calls on private method and starts at the root.
	 * Does not rebalance tree after deletion
	 */
	public void delete(AnyType toDelete) throws Exception{
		if (root == null)
			throw new Exception("AVL Tree is null");
		root = delete(toDelete, root);
	}
	
	private avlNode<AnyType> delete(AnyType toDelete, avlNode<AnyType> t){
		if (t == null)
			throw new NoSuchElementException("Element not found.");
		//Recursive calls
		if (toDelete.compareTo(t.data) < 0 )
			t.leftChild = delete(toDelete, t.leftChild);
		
		else if (toDelete.compareTo(t.data) > 0)
			t.rightChild = delete(toDelete, t.rightChild);
		
		else if (t.leftChild != null && t.rightChild != null) { //target has 2 children
			AnyType y = findMin(t.rightChild);
			t.data = y;
			t.rightChild = delete(y,t.rightChild);
			}
		// Check left or right children of target node
		else if(t.leftChild == null)
			t = t.rightChild;
		else //(t.rightChild == null)
			t = t.leftChild;
		t.height = Math.max(height(t.leftChild), height(t.rightChild)) + 1; //update the heights of parents
		return t;			
	}
	
	/* Public method to find smallest element in AVL Tree */
	public AnyType findMin(){
		if (root == null)
			throw new NullPointerException("BST is null");
		avlNode<AnyType> t = root;
		while (t.leftChild != null)
			t = t.leftChild;
		return t.data;
	}
	
	/* 
	 * Internal method to find smallest element
	 * in a subtree 
	 */
	private AnyType findMin(avlNode<AnyType> t){
		AnyType min = null;
		while(t.leftChild !=null)
			min = t.leftChild.data;
		return min;
	}
	
	/* Public method to find largest element in AVL Tree */
	public AnyType findMax(){
		if (root == null)
			throw new NullPointerException("AVL Tree is null");
		avlNode<AnyType> t =root;
		while(t.rightChild !=null)
			t = t.rightChild;
		return t.data;
	}
	
	/*
	 * Prints contents in sorted order
	 */
	public void inOrder(){
		inOrder(root);
	}
	private void inOrder(avlNode<AnyType> t){
		if(t!=null){
			inOrder(t.leftChild);
			System.out.println(t.data.toString());
			inOrder(t.rightChild);
		}
	} 
	
	/*
	 * For diagnostic purposes
	 */
	public AnyType getRoot(){
		return root.data;
	}
}
