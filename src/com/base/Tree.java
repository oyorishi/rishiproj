package com.base;

public class Tree {
	private int data;
	private Tree left;
	private Tree right;
	private int level;

	public Tree() {

	}

	public Tree(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
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
	 * @return the left
	 */
	public Tree getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(Tree left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public Tree getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(Tree right) {
		this.right = right;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	public static Tree getBasicTree() {
		 Tree root = new Tree(1);
		 root.setLeft(new Tree(2));
		 root.setRight(new Tree(3));
		 root.getLeft().setLeft(new Tree(4));
		 root.getLeft().setRight(new Tree(5));
		 root.getRight().setLeft(new Tree(6));
		 root.getRight().setRight(new Tree(7));

//		Tree root = new Tree(1);
//		root.setLeft(new Tree(2));
//		root.setRight(new Tree(3));
//		 root.getLeft().setLeft(new Tree(5));
//		root.getLeft().setRight(new Tree(4));
//		 root.getRight().setLeft(new Tree(4));
//		 root.getRight().setRight(new Tree(25));
//		 root.getLeft().getRight().setLeft(new Tree(10));
//		root.getLeft().getRight().setRight(new Tree(5));
//		root.getLeft().getRight().getRight().setRight(new Tree(6));
		return root;
	}

}
