package com.demo;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.Const;
import com.alibaba.fastjson.JSON;
import com.commons.MD5;
import com.commons.MyBeanUtils;
import com.model.po.User;
import com.model.vo.UserVO;
import com.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml"})
@TransactionConfiguration(transactionManager = "hibernateTransactionManager", defaultRollback=false)
@Transactional
public class UserServiceTest {
	@Resource
	private UserService service;
	@Test
	public void test() {
		User user = service.getById(Const.TEST_USER_ID);
		UserVO vo = new UserVO();
		MyBeanUtils.copy(vo, user);
		System.out.println(JSON.toJSONString(vo));
	}
	
	@Test
	public void addTestUser() {		
		for (int i = 0; i < 12; i ++) {
			User user = new User();
			user.setName("test" + i);
			user.setPassword(MD5.MD5Encode("123"));
			user.setSchool("中国大学");
			user.setIsEmail(true);
			user.setCreateTime(Const.getCurrentTimestamp());
			service.save(user);
		}
	}
	
	@Test
	public void testAdmin() {
		User admin = service.getById(Const.ADMIN_ID);
//		System.out.println(admin.getAuthorities().size());
	}
	
	@Test
	public void testRole() {
		List<User> users = service.hasRoleUser();
		System.out.println(users.size());
	}
}
