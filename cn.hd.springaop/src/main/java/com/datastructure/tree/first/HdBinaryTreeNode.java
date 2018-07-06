package com.datastructure.tree.first;

/**
 * @author dudu
 *
 * @param <T>
 */
public class HdBinaryTreeNode<T> {
	
	public T data;//数据域
	public HdBinaryTreeNode<T> left, right;//链域，分别指向左右孩子结点
	//构造指定的叶子结点
	public HdBinaryTreeNode() {
		this(null,null,null);
	}
	public HdBinaryTreeNode(T data) {
		this(data,null,null);
	}
	public HdBinaryTreeNode(T data, HdBinaryTreeNode<T> left, HdBinaryTreeNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
