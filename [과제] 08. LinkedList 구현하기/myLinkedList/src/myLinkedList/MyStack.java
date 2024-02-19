package myLinkedList;

public class MyStack<T>  {
	private MyLinkedList<T> list;
	
	public MyStack() {
		list = new MyLinkedList<>();
	}
	
	// 스택 맨 위에 요소를 추가하고, 추가된 요소를 반환
	public T push(T data) {
		list.add(data);
		return data;
	}
	
	//스택에 요소를 추가하고, 성공적으로 추가되었음을 나타내는 true를 반환.
	public boolean add (T data) {
		list.add(data);
		return true;
	}
	//스택의 맨 위(리스트의 끝)에 있는 요소를 제거하고 반환
	public T pop() {
		T data = list.get(list.size()-1);
		list.delete(list.size()-1);
		return data;
	}
	//스택의 맨 위에 있는 요소를 반환
	public T peek() {
		return list.get(list.size()-1);
	}
	//
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.size() == 0;
	}
	public boolean empty() {
		return list.size() == 0;
	}
	public T elementAt(int index) {
		return list.get(index);
	}
}
