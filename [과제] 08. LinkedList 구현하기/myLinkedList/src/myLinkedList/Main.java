package myLinkedList;

import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("========================== MyLinkedList =========================");
		MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
		myLinkedList.add(1);
		myLinkedList.add(2);
		myLinkedList.add(3);
		myLinkedList.add(4);
		myLinkedList.add(5);
		
		for(Integer tmp : myLinkedList) {
			System.out.println("for-each : "+tmp);
		}
		
		myLinkedList.addFrist(6);
		System.out.println("addFrist = " + myLinkedList.get(0));
		
		System.out.println("size = " + myLinkedList.size());
		
		myLinkedList.delete(0);
		
		System.out.println("delete(0)");
		for(Integer tmp : myLinkedList) {
			System.out.println("for-each : "+tmp);
		}
		System.out.println();
		System.out.println("========================== MyStack =========================");
		
		MyStack<Integer> myStack = new MyStack<>();
		
		System.out.println("myStack.add(1) : "+myStack.add(1));
		System.out.println("myStack.add(2) : "+myStack.add(2));
		System.out.println("myStack.push(3) : "+myStack.push(3));
		System.out.println("myStack.push(4) : "+myStack.push(4));
		System.out.println("myStack.peek() : " + myStack.peek());
		System.out.println("myStack.size() : "+myStack.size());
		System.out.println("myStack.isEmpty() : " + myStack.isEmpty());
		System.out.println("myStack.empty() : " + myStack.empty());
		System.out.println("myStack.elementAt(1) : " + myStack.elementAt(1));
		System.out.println("myStack.pop() : " + myStack.pop());
		System.out.println("myStack.pop() : " + myStack.pop());
		System.out.println("myStack.pop() : " + myStack.pop());
		System.out.println();
		System.out.println("========================== MyQueue =========================");
		MyQueue<Integer> myQueue = new MyQueue<Integer>();
		System.out.println("myQueue.add(1) : " + myQueue.add(1));
		System.out.println("myQueue.add(2) : " + myQueue.add(2));
		System.out.println("myQueue.add(3) : " + myQueue.add(3));
		System.out.println("myQueue.add(4) : " + myQueue.add(4));
		System.out.println("myQueue.remove(3) : "+myQueue.remove(3));
		System.out.println("myQueue.size() : " + myQueue.size());
		System.out.println("myQueue.isEmpty() : " + myQueue.isEmpty());
		System.out.println("myQueue.poll() : " + myQueue.poll());
		System.out.println("myQueue.poll() : " + myQueue.poll());
		System.out.println("myQueue.poll() : " + myQueue.poll());
		System.out.println("myQueue.poll() : " + myQueue.poll());
	}
}
