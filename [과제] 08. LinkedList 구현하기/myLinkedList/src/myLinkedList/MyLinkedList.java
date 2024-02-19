package myLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;
	//생성자
	public MyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	
	//맨 뒤에 add
	public void add(T data) {
		Node<T> node = new Node<>(data);
		if(tail == null) {
			head = node;
			tail = node;
		}else {
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
		size++;
	}
	//앞에 add
	public void addFrist(T data) {
		Node<T> node = new Node<>(data);
		if(head == null) {
			head = node;
			tail = node;
		}else {
			head.prev = node;
			node.next = head;
			head = node;
		}
		size++;
	}
	//사이즈
	public int size() {
		return size;
	}
	
	//하나 지우기
	public void delete(int index) {
		if(index < 0 || size<=index || head == null ) {
			throw new IndexOutOfBoundsException();
		}else {
			Node<T> current = head;
			for(int i=0; i<index; i++) {
				current = current.next;
			}
			if(current.prev == null) {
				head = current.next;
			}else {
				current.prev.next = current.next;
			}
			
			if(current.next == null) {
				tail = current.prev;
			}else{
				current.next.prev = current.prev;
			}
		}
		size--;
	}

	public T get(int index) {
		Node<T> current = head;
		if(index<0 || index >= size) throw new IndexOutOfBoundsException();
		
		for(int i=0; i<index; i++) {
			current = current.next;
		}
		
		return current.data;
	}


	@Override
	public Iterator<T> iterator() {
		
		return new Iterator<T>() {
			private Node<T> current =head;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public T next() {
				if(!hasNext()) throw new NoSuchElementException();
				T data = current.data;
				current = current.next; //다음값 꺼내기
				return data;
			}
		};
	}
	
	
	
	
	
	
	
	
	
}
