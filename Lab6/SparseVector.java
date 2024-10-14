public class SparseVector {

	private Node head;
	private int length;
	private int index;
	private double value;

	public SparseVector(int len){
		head = null;
		length = len;
	}

	// Prints out a sparse vector (including zeros)
	public String toString(){

		String result = "";
		Node currNode = head;
		int currIndex = 0;
		while( currNode != null ){
			int idx = currNode.getIndex();

			// Pad the space between nodes with zero
			while( currIndex < idx ){
				result += "0, ";
				currIndex++;
			}
			result += currNode;
			currNode = currNode.getNext();
			currIndex++;

			// Only add a comma if this isn't the last element
			if( currNode != null ){ result += ", "; }
		}
		return result;
	}
	
	// TODO: Implement me for milestone 1
	public void addElement(int index, double value){
		
		//1st Case: Check to see if the index is invalid
		if (index < 0 || index >= length){
			System.out.println("Invalid");
		}

		// 2nd Case: If the list is empty, create a new node and set it as the head
		Node node = new Node(index, value);
		if(head == null) {
			head = node;
			return;
		}
		
		//Last Case: Go through the whole list to the end and then add the new node
		Node current = head;
		while (current.getNext() != null) {
			current = current.getNext();
		}
		
		current.setNext(new Node(index, value));
		
	}

	public void removeElement(int index) {
		// Case 1: Check for Empty Lst
		if (head == null) {
			System.out.println("List is empty");
			return;
		}

		// Case 2: Removing the head node based on index
		if (head.getIndex() == index) {
			head = head.getNext();
			return;
		}

		// Case 3: Removing a non head nodes
		Node current = head;
		Node previous = null;

		while (current != null) {
			if (current.getIndex() == index) {
				previous.setNext(current.getNext());
				return;
			}

			previous = current;
			current = current.getNext();
		}

		// Case 4: Index not found
		System.out.println("Index not found");
	}


	// TODO: Implement me for milestone 3
	public static double dot(SparseVector x, SparseVector y){
		// Check if the vectors have the same length and are not empty
		if(x.length == y.length && x.length != 0) {
			double ret = 0.0;
			Node currentX = x.head;
			Node currentY = y.head;
			while(currentX != null) { // Go through both sparsevectors at the same time
				while(currentY != null) {
					// If the indices match, multiply the values and add to the result
					if(currentX.getIndex() == currentY.getIndex()) {
						ret += currentX.getValue() * currentY.getValue();
					}
					currentY = currentY.getNext();
				}
				currentX = currentX.getNext();
				currentY = y.head;
			}
			return ret;
		}
		else {
			System.out.println("Vectors are not the same size");
			return -1.0;
		}
	}
	
	// TODO: Test out your code here!
	public static void main(String[] args) {
		
		SparseVector x = new SparseVector(100000000);
		x.addElement(0, 1.0);
		x.addElement(10000000, 3.0);
		x.addElement(10000001, -2.0);
		SparseVector y = new SparseVector(100000000);
		y.addElement(0, 2.0);
		y.addElement(10000001, -4.0);

		y.removeElement(0);
		double result = dot(x, y);
		System.out.println(result);
		
//		SparseVector vec = new SparseVector(6);
//		vec.addElement(0, 10.0);
//		vec.addElement(3, -1.1);
//		vec.addElement(5, 32.0);
//		System.out.println(vec);
	}
		
}
