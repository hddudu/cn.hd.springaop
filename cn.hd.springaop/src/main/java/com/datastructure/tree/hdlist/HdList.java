package com.datastructure.tree.hdlist;

import java.util.ListIterator;

/**
 * @author dudu
 *
 * @param <T>
 */
public interface HdList<T> extends HdCollection<T> {

//		List<E>
	
	// Query Operations
	int size();
	boolean isEmpty();
	boolean contains(Object o);
	Object[] toArray();
	
	// Modification Operations==>单个修改操作
	boolean add(T t);
	boolean remove(Object o);
	
	// Bulk Modification Operations==>批量修改操作
	boolean containsAll(HdCollection<?> c);
	boolean addAll(HdCollection<? extends T> c);
	boolean addAll(int index, HdCollection<? extends T> c);
	boolean removeAll(HdCollection<?> c);
	boolean retainAll(HdCollection<?> c);//移除不在集合中的元素
	void clear();//全部清除
	
	// Comparison and hashing
	int hashCode();
	boolean equals(Object o);
	
	// Positional Access Operations
	T get(int index);
	T set(int index, T element);
	void add(int index, T element);
	boolean remove(int index);
	
	// Search Operations
	int indexOf(Object o);//查找某元素的位置
	int lastIndexOf(Object o);//
	
	// List Iterators
	ListIterator<T> listIterator();
	
	// View
	
}
