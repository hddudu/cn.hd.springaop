package com.datastructure.queue.javaqueue;

import com.datastructure.tree.hdlist.HdCollection;

/**
 * @author dudu
 *
 * @param <T>
 */
public interface HdQueue<T> extends HdCollection<T>{
//	Queue<E>
	boolean add(T t);
	boolean offer(T t);
	T remove();
	T poll();
	T peek();
	T element();
}
