package com.datastructure.tree.hdlist;

import java.io.Serializable;
import java.util.ListIterator;
import java.util.RandomAccess;

/**
 * @author dudu
 * 实现冗余,添加中间抽象类HdAbstractArrayList<T>
 *
 * @param <T>
 */
public class HdArrayList<T> 
	implements 	HdList<T>, Serializable, RandomAccess, Cloneable{

	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean add(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsAll(HdCollection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(HdCollection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(int index, HdCollection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeAll(HdCollection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean retainAll(HdCollection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public T set(int index, T element) {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(int index, T element) {
		// TODO Auto-generated method stub
		
	}

	public boolean remove(int index) {
		// TODO Auto-generated method stub
		return false;
	}

	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
