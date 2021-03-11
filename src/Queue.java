
public class Queue {
	private Object[] elements;
	private int rear,front;
	
	public Queue(int capacity) {
		elements=new Object[capacity];
		rear=-1;
		front=0;
	}
	
	public boolean isEmpty() {
		return rear<front;
	}
	
	public boolean isFull() {
		return rear+1==elements.length;
	}
	
	public void enqueu(Object data) {
		if(isFull()) {
			System.out.println("Queue is full");
		}
		else {
			rear++;
			elements[rear]=data;
		}
		
	}
	
	public Object dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		}
		else {
			Object data=elements[front];
			elements[front]=null;
			front++;
			return data;
		}
	}
	
	public Object peek() {
		return elements[front];
	}
	
	public int size() {
		return rear-front+1;
	}
	
	
}
