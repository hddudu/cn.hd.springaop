package com.datastructure.queue;

import java.util.Stack;

public class TwoStackQueue {

	public Stack<Integer> stackPush;
	public Stack<Integer> stackPop;
	
	public TwoStackQueue(){
		stackPush = new Stack<Integer>();
		stackPop = new Stack<Integer>();
	}
	
	public void push(int item) {
		stackPush.push(item);
	}
	
	public int pop() {
		if(stackPop.empty() && stackPush.empty()) {
			throw new RuntimeException("Queue is empty");
		} else if(stackPop.empty()) {
			while(!stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.pop();
	}
	
	public int peek() {
		if(stackPop.empty() && stackPush.empty()) {
			throw new RuntimeException("Queue is empty");
		} else if(stackPop.empty()) {
			while(!stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.peek();
	}
	public static void main(String[] args) {
		TwoStackQueue mq = new TwoStackQueue();
		mq.push(3);
		
		int p2=mq.peek();
//    boolean boo=mq.empty();
        int p1=mq.pop();
	}
	
}
