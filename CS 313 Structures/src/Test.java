
public class Test {

	public static void main(String args[]) throws Exception{
		/*
		// Stack Test
		Stack<String>mystack = new Stack<String>(10);
		System.out.println("Test Stack:");
		mystack.push("5");
		mystack.push("4");
		mystack.push("3");
		mystack.push("2");
		mystack.push("1");
		
		while(! mystack.isEmpty()){
			System.out.println(mystack.pop());
		}
		
		//Queue Test
		Queue<String>myqueue = new Queue<String>();
		System.out.println("Test Stack:");
		myqueue.enQ("RZA");
		myqueue.enQ("GZA");
		myqueue.enQ("Ol Dirty Bastard");
		myqueue.enQ("Inspectah Deck");
		myqueue.enQ("Raekwon");
		
		while(! myqueue.isEmpty()){
			System.out.println(myqueue.deQ());
		}
		// BST Test
		BinarySearchTree<String> my_tree = new BinarySearchTree<String>();
		String[] people = new String[]{"Andres", "Ricardo", "Carolina", "Christina","Michael", "Jordan", "Justin","Abby"};
		for(String s:people){
			my_tree.insert(s);
		}
		my_tree.preOrder();
		
		//AVL TEST
		AVLTree<String> my_tree = new AVLTree<String>();
		String[] people = new String[]{"Andres", "Ricardo", "Carolina", "Christina","Michael", "Jordan", "Justin"};
		my_tree.insert(people[0]);
		my_tree.insert(people[1]);
		System.out.println("Current Root is "+my_tree.getRoot());
		my_tree.insert(people[2]);
		my_tree.insert(people[3]);
		System.out.println("\nCurrent Root is "+my_tree.getRoot());
		my_tree.insert(people[4]);
		my_tree.insert(people[5]);
		System.out.println("\nCurrent Root is "+my_tree.getRoot());
		my_tree.insert(people[6]);
		System.out.println("\nCurrent Root is "+my_tree.getRoot());
		System.out.println("AVL Tree");
		my_tree.inOrder();
		*/
		
		MaxHeap<String> myHeap = new MaxHeap<String>(32);
		String[] numbers = new String[]{"1", "2", "3", "4", "5","6","7"};
		for(String s:numbers)
			myHeap.insert(s);
		myHeap.print();
		myHeap.deleteMax();
	}
}
