package com.algo;

public class Queue {
    private int[] arr = new int[100];
    private int head = 0;
    private int tail = 0;

    public void enqueue(int n) {
	arr[++tail] = n;
    }

    public int dequeue() {
	if (head == tail) {
	    System.out.println("queue is empty");
	    return -1;
	}
	return arr[++head];
    }

    public boolean queueEmpty() {
	if (head == 0 && tail == 0) {
	    return true;
	} else {
	    return false;
	}
    }

    public static void main(String[] args) {
	Queue queue = new Queue();
	queue.enqueue(1);
	queue.enqueue(2);
	System.out.println(queue.dequeue());
	System.out.println(queue.queueEmpty());
	queue.enqueue(3);
	System.out.println(queue.dequeue());
	System.out.println(queue.dequeue());
	System.out.println(queue.dequeue());

    }

}
