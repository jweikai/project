package com.demo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.Const;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.annotation.PO2VO;
import com.commons.MyBeanUtils;
import com.model.po.Authority;
import com.model.po.History;
import com.model.po.Logs;
import com.model.po.Role;
import com.model.po.User;
import com.model.vo.HistoryVO;
import com.model.vo.Json;
import com.model.vo.LogsVO;
import com.model.vo.UserVO;
import com.service.UserService;

public class BeanUtilTest {
	@Test
	public void test1() {
		LogsVO logs = new LogsVO();
		PO2VO po2vo = logs.getClass().getAnnotation(PO2VO.class);				
		System.out.println(po2vo.value()[0]);
	}
	
	@Test
	public void test() {
		Logs logs = new Logs();
		logs.setDoing("doing");
		logs.setId(1L);		
//		logs.setTime(new Timestamp(new Date().getTime()-3600000*24*2));
		User user = new User();
		user.setName("123");
		logs.setUserId(1L);		
		
		LogsVO logsVO = new LogsVO();
		try {
			MyBeanUtils.copy(logsVO, logs);
			System.out.println(JSONUtils.toJSONString(logs));
		} catch(Exception e ) {
			e.printStackTrace();
		}
	}
	@Test
	public void test2() {
		History history = new History();
		history.setId(1L);
		history.setIp("123123");
		history.setLoginTime(Const.getCurrentTimestamp());
		User user = new User();
		user.setName("jwk");
		user.setId(3L);
		history.setUser(user);
		HistoryVO historyVO = new HistoryVO();
		MyBeanUtils.copy(historyVO, history);
		System.out.println(JSON.toJSONString(historyVO));		
	}
	
	@Test
	public void testList() {
		User user = new User();
		user.setName("dsa");
		user.setId(1L);
		Role role = new Role();
		role.setId(2L);
		role.setName("role");
		role.setContent("zcvz");
		Authority authority = new Authority();
		authority.setName("权限");
		authority.setId(1L);
		role.getAuthorities().add(authority);
		user.getRoles().add(role);
		UserVO userVO = new UserVO();
		MyBeanUtils.copy(userVO, user, 2);		
		System.out.println(JSON.toJSONString(userVO));
	}
	
	@Test
	public void testlist() {
		List<Logs> logs = new ArrayList<Logs>();
		logs.add(new Logs());
		List<LogsVO> logsVOs = new ArrayList<LogsVO>();
		MyBeanUtils.copyList(logsVOs, logs, LogsVO.class);
	}
	@Test
	public void testObj() {
		User user = new User();
		Role role = new Role();
		role.setId(2L);
		role.setName("role");
		role.setContent("zcvz");
		user.getRoles().add(role);		
		try {
			Field f = user.getClass().getDeclaredField("roles");
			f.setAccessible(true);
			System.out.println(f.get(user));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void  aaa() {
		String a = "index";
		System.out.println(a.split("_")[0]);
	}
}
