package com.demo;

import org.junit.Test;

import com.Const;
import com.commons.Dom4jUtils;

public class Dom4jTest {
	@Test
	public void colorTest() {
		String str = "我的中";
		for (int i = 0; i < str.length(); i ++) {
			System.out.println(str.codePointAt(i));
		}
	}
}
