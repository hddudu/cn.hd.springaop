package com.datastructure.dataobject.datatransmitobject;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import com.sun.xml.internal.txw2.IllegalAnnotationException;

/**
 * @author dudu
 *
 * @param <V>
 */
public class DataMap<V extends DataElement> extends DataElement<DataMap<V>> implements
		Map<String, V> {

	/**
	 * 哈希链表：结构分析
	 * 
	 */
	private Map<String, V> dataMap = new LinkedHashMap<String, V>();
	private DataMap defineMap;
	private String desc;
	
	public DataMap() {
		setChange(false);
	}
	
	public DataMap(String name) {
		setName(name);
		setChange(false);
	}
	
	public DataMap(String name, boolean isChange){
		setName(name);
		setChange(isChange);
	}

	public DataMap(boolean isChange) {
		setChange(isChange);
	}
	
	public DataMap(Map<String, V> dataMap) {
		this.dataMap = dataMap;
	}
	
	public DataMap(String name, Map<String, V> dataMap) {
		setName(name);
		this.dataMap = dataMap;
	}
	
	public void check() {
		if(!(isChange())) {
			throw new IllegalAnnotationException("改变");
		}
	}
	
//	public 
	
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	public V get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	public V put(String key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	public void putAll(Map<? extends String, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public Set<String> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<java.util.Map.Entry<String, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataMap<V> clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataMap<V> cloneWithOutData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void copy(DataMap<V> paramT) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean equals(DataMap<V> paramT) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toJSON() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toXML() {
		// TODO Auto-generated method stub
		return null;
	}

}
