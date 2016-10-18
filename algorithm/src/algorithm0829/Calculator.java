package algorithm0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Calculator {

	private static class Stack {
		private int top;
		private int maxSize;
		private Object[] stackArray;

		public Stack(int maxSize) {
			this.maxSize = maxSize;
			stackArray = new Object[maxSize];
			top = -1;
		}

		public boolean isEmpty() {
			return (top == -1);
		}

		public boolean isFull() {
			return (top == maxSize - 1);
		}

		public void push(Object item) {
			if (isFull())
				throw new ArrayIndexOutOfBoundsException((top + 1) + ">=" + maxSize);

			stackArray[++top] = item;
		}

		public Object peek() {
			if (isEmpty())
				throw new ArrayIndexOutOfBoundsException("Stack is Empty");
			return stackArray[top];
		}

		public Object pop() {
			Object item = peek();
			top--;
			return item;
		}
	}

	private static class Scan {
		BufferedReader bf;
		StringTokenizer st;

		public Scan() {
			bf = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(bf.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
	
	
	public static void main(String[] args){
		Scan sc = new Scan();
		
		System.out.println("계산할 식을 입력하세요.");
		char[] calChar = sc.next().toCharArray();
		Stack oper = new Stack(calChar.length);
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<calChar.length;i++){
			if(isInt(calChar[i])){
			}
		}
		
	}
	
	public static int compOper(String a){
		
		switch(a){
		case "+" :
		case "-" :
			return 3;
		case "*":
		case "/":
			return 5;
		case "(":
			return 1;
		
		}
		return 1;
	}
	
	public static boolean isInt(char a){
		if(0<=a && a<=9)
			return true;
		else
			return false;
	}

}
