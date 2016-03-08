package com.commons;

import java.lang.reflect.Field;
import java.util.Comparator;

/**
 * 
 * 通用含数字排序列的比较类
 * @author J.L.Zhou
 *
 */
public class Sort implements Comparator<Object>{
	private String columnName="sortNumber";
	private boolean isAsc=true;
	
	public Sort(){}
	
	
	public Sort(boolean isAsc) {
		this.isAsc = isAsc;
	}


	/**
	 * @param columnName 需要排序的字段名称，必须为数字类型，默认为 "sortNumber"
	 * @param isAsc 是否按升序排列 默认为 true
	 */
	public Sort(String columnName,boolean isAsc){
		this.columnName=columnName;
		this.isAsc=isAsc;
	}
	public Sort(String columnName){
		this.columnName=columnName;
	}
	@Override
	public int compare(Object o1, Object o2) {
		try{
			Field field = o1.getClass().getDeclaredField(columnName);
			boolean accessible = field.isAccessible();
			field.setAccessible(true);
			Number n1 = (Number) field.get(o1);
			Number n2 = (Number) field.get(o2);
			field.setAccessible(accessible);
			if(isAsc){
				return (int)(n1.longValue()-n2.longValue());
			}else{
				return (int)(n2.longValue()-n1.longValue());	
			}
		}catch (Exception e) {
		}
		return 0;
		
	}
	
}
