package baekjoon1697;

import java.util.Scanner;

public class Main {
	static int N, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		move(N);
		sc.close();
	}

	public static void move(int X) {
		Queue queue = new Queue(200001);
		int[] visit = new int[200001];
		visit[X] = 1;
		queue.push(X);

		while (!queue.isEmpty()) {
			int x = queue.pop();
			if (x == K) {
				System.out.println(visit[x] - 1);
			} else {
				if (x - 1 >= 0 && visit[x - 1] == 0) {
					visit[x - 1] = visit[x] + 1;
					queue.push(x - 1);
				}
				if (x + 1 <= 100000 && visit[x + 1] == 0) {
					visit[x + 1] = visit[x] + 1;
					queue.push(x + 1);
				}
				if (x * 2 <= 100000 && visit[x * 2] == 0) {
					visit[x * 2] = visit[x] + 1;
					queue.push(x * 2);
				}
			}
		}
	}
}

class Queue {
	private int front;
	private int rear;
	private int[] storage;

	public Queue(int size) {
		front = -1;
		rear = -1;
		storage = new int[size];
	}

	public void push(int item) {
		storage[++rear] = item;
	}

	public int pop() {
		return storage[++front];
	}

	public boolean isEmpty() {
		return front == rear;
	}
}
