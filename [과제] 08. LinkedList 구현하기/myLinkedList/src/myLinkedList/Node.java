package myLinkedList;

public class Node<E> {
	E data;
	Node next;
	Node prev;
	
	public Node(E data) {
		this.data = data;
		next = null;
		prev = null;
				
	}
	
}
