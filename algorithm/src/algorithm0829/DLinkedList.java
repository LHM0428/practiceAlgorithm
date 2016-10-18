package algorithm0829;

public class DLinkedList {
	
	static class Node{
		private Integer data;
		private Node next;
		private Node previous;
		public int getData() {
			return data;
		}
		public void setData(Integer data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public Node getPrevious() {
			return previous;
		}
		public void setPrevious(Node previous) {
			this.previous = previous;
		}
		
	}

	Node head;
	Node tail;
	Node cur;
	int numOfData;
	
	public DLinkedList() {
		head = new Node();
		tail = new Node();
		cur = new Node();
		numOfData=0;
	}
	
	void listInit(){
		tail.setData(null);
		head.setData(null);
		head.setNext(tail);
		head.setPrevious(null);
		tail.setNext(null);
		tail.setPrevious(head);
		cur = null;
		numOfData = 0;
	}
	
	void listInsert(int a){
		Node newNode = new Node();
		newNode.setData(a);
		
		newNode.setPrevious(tail.getPrevious());
		tail.getPrevious().setNext(newNode);
		
		tail.setPrevious(newNode);
		newNode.setNext(tail);
		numOfData++;
	}
	
	int listFirst(){
		if(head.getNext()==null){
			return -1;
		}
		cur = head.getNext();
		return cur.getData();
	}
	
	int listNext(){
		if(cur.getNext()==null){
			return -1;
		}
		
		cur = cur.getNext();
		return cur.getData();
	}
	
	int listPrevious(){
		if(cur.getPrevious()==null){
			return -1;
		}
		cur = cur.getPrevious();
		return cur.getData();
	}
	
	int listRemove(){
		Node pre = cur.getPrevious();
		Node next = cur.getNext();
		Node remove = cur;
		pre.setNext(next);
		next.setPrevious(pre);
		cur = pre;
		numOfData--;
		return remove.getData();
	}
	
	int listCount(){
		return numOfData;
	}

}
