package algorithm0829;

public class CircleQueue {
	
	int front;
	int rear;
	Integer queArr[];
	int maxSize;

	public CircleQueue(int maxSize) {
		this.maxSize = maxSize;
		queArr = new Integer[maxSize];
		front = 0;
		rear = 0;
	}
	
	public boolean isEmpty(){
		return (rear==front);
	}
	public boolean isFull(){
		return (nextIdx(rear)==front);
	}
	
	public void enQueue(int a){
		if(isFull())throw new ArrayIndexOutOfBoundsException("Queue is Full");
		queArr[++rear]=a;
	}
	public int nextIdx(int a){
		if((a+1)==maxSize-1)
			return 0;
		else
			return a+1;
	}
	
	public int peek(){
		if(isEmpty()) throw new ArrayIndexOutOfBoundsException("Queue is Empty");
		return queArr[nextIdx(front)];
	}
	
	public int deQueue(){
		int a = peek();
		queArr[nextIdx(front)] = null;
		front++;
		return a;
	}
}
