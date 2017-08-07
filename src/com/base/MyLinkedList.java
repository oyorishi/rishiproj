package com.base;

public class MyLinkedList {
    private int data;
    private MyLinkedList next;

    public MyLinkedList(int data) {
	this.data = data;
	this.next = null;
    }

    /**
     * @return the data
     */
    public int getData() {
	return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(int data) {
	this.data = data;
    }

    /**
     * @return the next
     */
    public MyLinkedList getNext() {
	return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(MyLinkedList next) {
	this.next = next;
    }

    public static MyLinkedList getBasicLinkedList() {
	MyLinkedList head = new MyLinkedList(1);
	head.next = new MyLinkedList(2);
	head.next.next = new MyLinkedList(3);
	head.next.next.next = new MyLinkedList(4);
	head.next.next.next.next = new MyLinkedList(5);
	return head;
    }

}
