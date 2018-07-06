package com.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 结构： 链表 + 数组 + hash函数
 * @author dudu
 * https://2cto.com/kf/201801/715942.html
 * @param <K>
 * @param <V>
 */
public class MyHashMap<K, V> implements MyMap<K, V> {
	
	/*设置默认值*/
	private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;//2的4次方等于16
	
	/*设置阈值: 到了一定大小自动扩容*/
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;
	
	//默认初始化值
	private int defaultInitSize;
	
	//
	private float defaultLoadFactor;
	
	//map中用了多少元素
	private int entryUseSize;
	
	//zai O(1) 时间内娶到数据 = 数组
	Entry<K, V>[] table = null;
	
	//无参构造
	public MyHashMap(){
		this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
	}
	
	/*构造函数*/
	public MyHashMap(int size, float factor) {
		if(size < 0) {
			throw new IllegalArgumentException("size < 0");//大于0
		}
		if(factor < 0) {
			throw new IllegalArgumentException("factor < 0");//取值： 0~1
		}
		this.defaultInitSize = size;//默认初始化值
		this.defaultLoadFactor = factor;//默认初始化值
		/**初始化一个数组出来*/
		table = new Entry[this.defaultInitSize];//完成创建初始化数组
	}
	
	/**继承内部接口*/
	class Entry<K, V> implements MyMap.Entry<K, V> {

		private K key;
		private V value;
		private Entry<K, V> next;
		
		public Entry() {
		}
		
		public Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}
	}
	/**
	 * 重要的get方法
	 */
	public V get(K k) {
		int index = hash(k) & (defaultInitSize - 1);
		if(table[index] == null) {
			return null;
		} else {
			Entry<K, V> entry = table[index];
			do{
				if(k == entry.getKey() || k.equals(entry.getKey())) {
					return entry.value;
				}
				entry = entry.next;
			} while(entry != null);
		}
		return null;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyHashMap<String, String> myMap = new MyHashMap<String, String>();
		myMap.put("hello", "world");
		System.out.println(myMap.get("hello"));
		for(int i = 0; i < 32; i++) {//自动完成了扩容
			myMap.put("key_" + i, "value_" + i);
		}
		for(int i = 0; i < 32; i++) {
			System.out.println(myMap.get("key_" + i));
		}
	}
	
	private int hash(K k) {
		int h;
		//将对象的hash值右移16位与起源hash值做异或运算
		//扰动函数
		return (k==null)?0:(h=k.hashCode())^(h>>>16);
	}
	
	/**
	 * 重要的put方法
	 * 拿到hash值做下标
第一，要考虑是否扩容？
HashMap中的Entry的数量（数组以及单链表中的所有Entry）是否达到阀值？
第二，如果扩容，意味着新生成一个Entry[]，不仅如此还得重新散列。
第三，要根据Key计算出在Entry[]中的位置，定位后，如果Entry[]中的元素为null，
那么可以放入其中，如果不为空，那么得遍历单链表，要么更新value，要么形成一个新
的Entry“挤压”单链表！
	 * 
	 */
	public V put(K k, V v) {
		//把key value对放到数组中去
		V oldValue = null;//defaultInitSize : 当前的size
		if(entryUseSize >= defaultInitSize * defaultLoadFactor) {
			//TODO:扩容方法
			resize(defaultInitSize * 2); 
		}
//		HashMap<K, V>
//		String ： 得到hash值,计算出数组中的位置: 通过与控制范围
		int index = hash(k) & (defaultInitSize - 1);
		if(table[index] == null) {
			table[index] = new Entry<K, V>(k, v, null);
			++entryUseSize;//就是占用了数组一个新位置
		} else {
			/**否则链表给串联起来**/
			//遍历链表 + 插入头或者插入到链表尾
			Entry<K, V> entry = table[index];
			Entry<K, V> e = entry;//辅助变量
			while(e != null) {
				if(k == e.getKey() || k.equals(e.getKey())) {//判断键值是否重复
					//地址引用相同 或者 值一样
					oldValue = e.value;
					e.value = v;
					return oldValue;
				}
				e = e.next;
			}
			//更新table[index]
			table[index] = new Entry<K, V>(k, v, entry);
			++entryUseSize;
		}
		return oldValue;
	}

	/**
	 * @param i
	 */
	private void resize(int i) {
		Entry[] newTable = new Entry[i];
		//改变了数组的大小
		this.defaultInitSize = i;//当前大小改成2倍
		this.entryUseSize = 0;//默认使用为0
		rehash(newTable);//重新放一次->重新hash
	}
	
	/**
	 * @param newTable
	 */
	private void rehash(Entry<K, V>[] newTable) {
		//java 8 已经没有rehash操作了
		List<Entry<K, V>> entryList = new ArrayList<Entry<K,V>>();
		for(Entry<K, V> entry : table) {
			if(entry != null) {
				//链式结构新加入结点
				do{
					entryList.add(entry);
					entry = entry.next;
				}while(entry != null);
			}
		}
		//覆盖旧引用
		if(newTable.length > 0) {
			table = newTable;
		}
		//重新hash: 这里可以看出，对于HashMap而言，如果频繁进行resize/rehash操作，是会影响性能的。
		//resize/rehash的过程，就是数组变大，原来数组中的entry元素一个个的put到新数组的过程，
		//需要注意的是一些状态变量的改变。
		for(Entry<K, V> entry : entryList) {//重新放一次值
			put(entry.getKey(), entry.getValue());
		}
	}
	

}
