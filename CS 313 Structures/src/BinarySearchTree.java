
@SuppressWarnings("unchecked")

public class BinarySearchTree<AnyType extends Comparable<AnyType>> {
	
	private BinaryNode<AnyType> root;
	
	protected class BinaryNode<T>{
		protected T data;
		protected BinaryNode<T> leftChild;
		protected BinaryNode<T> rightChild;
		
		public BinaryNode(T element){
			data = element;
			leftChild = null;
			rightChild = null;
		}
	}
	
	public BinarySearchTree(){
		root = null;
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	public void makeEmpty(){
		root = null;
	}
	
	public void insert(AnyType toAdd) throws Exception{
		root = insert(toAdd, root);
	}
	
	private BinaryNode<AnyType> insert(AnyType toAdd, BinaryNode<AnyType> t) throws Exception{
		if (t == null)
			t = new BinaryNode<AnyType>(toAdd);
		else if(toAdd.compareTo((AnyType)t.data) < 0)
			t.leftChild = insert(toAdd,t.leftChild);
		else if(toAdd.compareTo((AnyType)t.data) > 0)
			t.rightChild = insert(toAdd,t.rightChild);
		else
			throw new Exception( "Duplicate Item: " +toAdd.toString());
		return t;
	}
	
	public void delete(AnyType toRemove) throws Exception{
		if (isEmpty())
			throw new Exception("BinarySearchTree is empty.");
		root = delete(toRemove, root);
	}
	
	private BinaryNode<AnyType> delete(AnyType toRemove, BinaryNode<AnyType> t) throws Exception{
		if (t == null)
			throw new Exception("No Such Element: " +toRemove.toString());
		if (toRemove.compareTo(t.data) < 0)
			t.leftChild = delete(toRemove, t.leftChild);
		else if (toRemove.compareTo(t.data) > 0)
			t.rightChild = delete(toRemove, t.rightChild);
		else if (t.leftChild != null && t.rightChild != null){ //check if both children are not null
			AnyType y = findMin(t.rightChild);
			t.data = y;
			t.rightChild = delete(y,t.rightChild);
		}
		else if (t.leftChild == null)
			t = t.rightChild;
		else 
			t = t.leftChild;
		return t;
	}
	
	public AnyType findMax() throws Exception{
		if (isEmpty())
			throw new Exception("BinarySearchTree is empty.");
		AnyType max = findMax(root);
		return max;
	}
	
	private AnyType findMax(BinaryNode<AnyType> t){
		if (t != null)
			while(t.rightChild != null)
				t = t.rightChild;
		return t.data;
	}
	
	public AnyType findMin() throws Exception{
		if (isEmpty())
			throw new Exception("BinarySearchTree is empty.");
		AnyType min = findMin(root);
		return min;
	}
	
	private AnyType findMin(BinaryNode<AnyType> t){
		if (t != null)
			while(t.leftChild != null)
				t = t.leftChild;
		return t.data;
	}
	
}
