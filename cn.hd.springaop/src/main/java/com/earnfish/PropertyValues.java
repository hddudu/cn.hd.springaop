package com.earnfish;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dudu
 *
 */
public class PropertyValues {
	private final List<PropertyValue> propertyValues = new ArrayList<PropertyValue>();
	
	public PropertyValues() {}
	
	public void addPropertyValue(PropertyValue pv) {
		this.propertyValues.add(pv);
	}
	public List<PropertyValue> getPropertyValues() {
		return propertyValues;
	}
}
