package com.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 是否使用错误的页面输出错误信息
 * 默认情况使用JSON输出错误信息
 * @author J.L.Zhou
 *
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface PO2VO {
	/**
	 * 需要复制的属性对象
	 * @return
	 */
	String[] value();
}
