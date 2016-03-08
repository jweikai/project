package com.commons;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import com.annotation.Mapping;
import com.annotation.PO2VO;

public class MyBeanUtils {
	
	static {
		ConvertUtils.register(new Converter() {
			@Override
			public Object convert(Class type, Object value) {
				if (value == null) {
					return null;
				}				
				String val = (String) value;
				String[] vals = val.split("[^0-9]");
				int[] times = new int[6];
				for (int i = 0; i < vals.length; i++) {
					times[i] = Integer.parseInt(vals[i]);
				}
				Calendar c = Calendar.getInstance();
				c.set(times[0], times[1], times[2], times[3], times[4], times[5]);				
				return c.getTime();
			}
		}, Date.class);
		ConvertUtils.register(new Converter() {
			@Override
			public Object convert(Class type, Object value) {
				if (value == null) {
					return null;
				}
				if (!(value instanceof Date)) {
					return value.toString();
				}
				Date date = (Date) value;				
				return TimeUtil.transTime(date);
			}
		}, String.class);
	}
	
	/**
	 * 对列表进行排序
	 * @param list
	 * @param columnName 需要排序的字段名称，必须为数字类型，默认为 "sortNumber"
	 * @param isAsc 是否按升序排列 默认为 true
	 */
	public static void sort(List<? extends Object> list,String columnName,boolean isAsc){
		java.util.Collections.sort(list,new Sort(columnName,isAsc));
	}
	
	public static void sort(List<? extends Object> list,boolean isAsc){
		java.util.Collections.sort(list,new Sort(isAsc));
	}
	
	public static void sort(List<? extends Object> list,String columnName){
		java.util.Collections.sort(list,new Sort(columnName));
	}
	public static void sort(List<? extends Object> list){
		java.util.Collections.sort(list,new Sort());
	}
	
	/**
	 * 随机排列
	 * @param list
	 */
	public static void sortRandom(List<? extends Object> list){
		java.util.Collections.sort(list,new SortRandom());
	}
	/**
	 * 全部转换json
	 */
	public static final int DEEPALL = 10000;
	public static<E, T> void copy(E dest, T src) {
		copy(dest, src, DEEPALL);
	}
	/**
	 * 
	 * @param dest 目标
	 * @param src 源
	 * @param deep 转换深度
	 */
	public static<E, T> void copy(E dest, T src, int deep) {
		try {
			BeanUtils.copyProperties(dest, src);
			if ( deep > 0 && dest.getClass().isAnnotationPresent(PO2VO.class) ) {
				-- deep;
				PO2VO po2vo = dest.getClass().getAnnotation(PO2VO.class);
				for (String fieldName : po2vo.value()) {
					try {
						Object sTemp = PropertyUtils.getProperty(src, fieldName);												
						String cvoName = fieldName + "VO";											
						Class dclass = PropertyUtils.getPropertyType(dest, cvoName);
						if ( dclass.getInterfaces()[0].equals(Collection.class) ) {	//list								
							Mapping m = (Mapping)dest.getClass().getDeclaredField(cvoName).getAnnotation(Mapping.class);
							if ( m != null )
							copyList((Collection)PropertyUtils.getProperty(dest, cvoName), (Collection)sTemp, m.value(), deep);
						}else {	//object
							Object dTemp = dclass.newInstance();
							BeanUtils.copyProperties(dTemp, sTemp);
							BeanUtils.setProperty(dest, cvoName, dTemp);
						}
					} catch (Exception e) {						
						e.printStackTrace();
					}
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	public static<E, T> void copyList(Collection<E> dests, Collection<T> srcs, Class<E> destType) {
		copyList(dests, srcs, destType, DEEPALL);
	}
	/**
	 * 
	 * @param dests  目标对象
	 * @param srcs  源对象
	 * @param destType  目标对象类型
	 */
	public static<E, T> void copyList(Collection<E> dests, Collection<T> srcs, Class<E> destType, int deep) {			
		for (T src : srcs) {			
			try {				
				E dest = destType.newInstance();
				copy(dest, src, deep);
				dests.add(dest);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}	
}
