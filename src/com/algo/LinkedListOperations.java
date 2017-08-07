package com.algo;

import com.base.MyLinkedList;

public class LinkedListOperations {

    public static MyLinkedList reverse(MyLinkedList head) {
	MyLinkedList prev = null;
	MyLinkedList current = head;
	MyLinkedList next = null;
	while (current != null) {
	    next = current.getNext();
	    current.setNext(prev);
	    prev = current;
	    current = next;
	}
	head = prev;
	return head;
    }

    public static void main(String[] args) {
	MyLinkedList head = MyLinkedList.getBasicLinkedList();
	printLinkedList(head);
	System.out.println();
	head = reverse(head);
	printLinkedList(head);
    }

    private static void printLinkedList(MyLinkedList head) {
	MyLinkedList curr = head;
	while (curr != null) {
	    System.out.print(curr.getData() + " ");
	    curr = curr.getNext();
	}
    }

}
