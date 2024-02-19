package myLinkedList;

public class MyQueue<T> {
	private MyLinkedList<T> list;
	
	//생성자
	public MyQueue() {
		list = new MyLinkedList<>();
	}
	
	// 삽입 성공시 true 실패시 Exception
	public boolean add(T data) {
		list.add(data);
		return true;
	}
	
	
	//큐의 해당 data가 존재하면 삭제 후 true 잰재하지 않으면 flase
	public boolean remove(T data) {
		if(list.size() == 0) return false;
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals(data)) {
				list.delete(i);
				return true;
			}
		}
		
		return false;
	}
	
	//제일 앞에 있는 값을 반환 후 삭제 공백이라면 null
	public T poll() {
		if(list.size() == 0) return null;
		T data = list.get(0);
		list.delete(0);
		return data;
	}
	
	public int size() {
		return list.size();
	}
	public boolean isEmpty() {
		return list.size() == 0;
	}
	
}
