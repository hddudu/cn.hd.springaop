package com.datastructure.tree.first;

import java.util.List;

/**
 * @author dudu
 *
 * @param <T> 泛型接口参数化
 */
public interface IHdBinaryTreeNode<T> {
	boolean isEmpty();//判断二叉树是否为空
	
	int count();//判断结点个数
	
	int height();//返回二叉树的高度
	
	void preOrder();//前序遍历
	
	void inOrder();//中序遍历
	
	void postOrder();//后序遍历
	
	void levelOrder();//层次遍历
	
	List<T> preOrderResult();//遍历返回到结结果到list中
	
	List<T> inOrderResult();//遍历返回到结结果到list中
	
	List<T> postOrderResult();//遍历返回到结结果到list中
	
	List<T> levelOrderResult();//遍历返回到结结果到list中
	
	HdBinaryTreeNode<T> search(T key);//查找并返回首次出现key的值
	
	HdBinaryTreeNode<T> getParent(HdBinaryTreeNode<T> node);//返回父母结点
	
	void insertRoot(T x);//插入x作为根节点
	
	HdBinaryTreeNode<T> insertChild(HdBinaryTreeNode<T> node, T x, boolean leftChild);//插入孩子节点
	
	void removeChild(HdBinaryTreeNode<T> p, boolean leftChild);//删除p的左或者右子树
	
	void removeAll();//删除二叉树
	
}
