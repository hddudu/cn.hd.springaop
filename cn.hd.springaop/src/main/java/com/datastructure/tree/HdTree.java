package com.datastructure.tree;

public class HdTree {
	
	public int val;
	public HdTree left;//相当于nextLeft
	public HdTree right;//相当于nextRight
	public HdTree(int val) {
		this.val = val;
	}
	public HdTree(int val, HdTree left, HdTree right) {
		super();
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	
	
}
