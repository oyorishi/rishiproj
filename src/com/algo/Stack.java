package com.algo;

public class Stack {

	private int[] arr = new int[100];
	private int[] minArr = new int[100];
	int top = 0;
	int minTop = 0;

	public void push(int n) {
		arr[++top] = n;
		if (minTop == 0) {
			minArr[++minTop] = n;
		} else {
			int prev = minArr[minTop];
			if (n < prev) {
				minArr[++minTop] = n;
			} else {
				minArr[++minTop] = prev;
			}
		}
	}

	public int pop() {
		if (top == 0) {
			System.out.println("stack under flow");
			return -1;
		}
		if (minTop == 0) {
			System.out.println("stack under flow");
			return -1;
		}
		minTop--;
		return arr[top--];
	}

	public boolean stackEmpty() {
		if (top == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int min() {
		return minArr[minTop];
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(2);
		System.out.println("min:" + stack.min());
		stack.push(3);
		System.out.println("min:" + stack.min());
		stack.push(1);
		System.out.println("min:" + stack.min());
		stack.push(2);
		System.out.println("min:" + stack.min());

		System.out.println("popped:" + stack.pop());
		System.out.println("min:" + stack.min());
		System.out.println("popped:" + stack.pop());
		System.out.println("min:" + stack.min());
		System.out.println("popped:" + stack.pop());
		System.out.println("min:" + stack.min());
	}

}
