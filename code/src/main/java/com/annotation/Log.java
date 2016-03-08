package com.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Action的日志记录信息<br/>
 * 可以是OGNL
 * @author J.L.Zhou
 *
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Log {

	/**
	 * Action的日志记录信息
	 * 可以是OGNL
	 * @return
	 */
	String value();
	
	/**
	 * 不记录的参数<br/>
	 * 登陆密码等敏感数据不记录
	 * @return
	 */
	String[] exclude() default "";
	
	/**
	 * 是否不记录所有参数<br/>
	 * 文件上传的时候做日志记录就不能记录参数
	 * @return
	 */
	boolean excludeAll() default false;
}
