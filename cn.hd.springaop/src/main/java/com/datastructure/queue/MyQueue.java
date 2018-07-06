package com.datastructure.queue;

import java.util.Stack;

/**
 * 基本的结构：
 *  结构体（数据域+指针（地址）域）==》链表
 *  链表==》队列==》栈==》完成栈操作
 *  链表==》栈
 *  栈==》队列
 *  队列==》栈
 * 
 * @author dudu
 *
 */
public class MyQueue {

	private Stack<Object> stack1;
	private Stack<Object> stack2;
	
	/**
	 * initialize your data structure here
	 */
	public MyQueue(){
		this.stack1 = new Stack<Object>();
		this.stack2 = new Stack<Object>();
	}
	
	/**
	 * Push Element x onto stack
	 * @param x
	 */
	public void push(int x) {
		stack1.push(x);
	}
	
	/**
	 * Removes the element on top of the stack 
	 * and returns that element
	 * @return
	 */
	public Object pop() {
		//先判断是否为空
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				Object obj = stack1.pop();
				stack1.push(obj);
			}
		}
		Object o = stack2.pop();
		return o;
	}
	
	/**
	 * @return
	 */
	public Object pop2() {
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}
	
	/**
	 * get the top element
	 * @return
	 */
	public Object top() {
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.peek();
		
	}
	
	/**
	 * return whether the stack is empty
	 * @return
	 */
	public boolean empty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
	public static void main(String[] args) {
		MyQueue mq = new MyQueue();
		mq.push(3);
	}
}
