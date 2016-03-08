package com.demo;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.commons.CMDUtils;
import com.commons.ConfigUtil;
import com.model.vo.CMDResult;

public class CMDTest {
	@Test
	public void test() {
//		CMDResult r = CMDUtils.infoCMD("mysql -uroot -ps");
//		System.out.println(JSON.toJSONString(r));
	}
	@Test
	public void testConfig() {
		String back = ConfigUtil.get("back");
		System.out.println(String.format(back, "user_role role_authority", "e:role.sql"));
	}
}
