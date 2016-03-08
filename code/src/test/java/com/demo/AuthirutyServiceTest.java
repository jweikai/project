package com.demo;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.commons.CacheUtil;
import com.model.po.Authority;
import com.model.po.Role;
import com.service.AuthorityService;
import com.service.RoleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml"})
@TransactionConfiguration(transactionManager = "hibernateTransactionManager")	//配置defaulRollback，默认是true直接回滚, 如果想直接提交设置成false
@Transactional
public class AuthirutyServiceTest {
	@Resource
	private AuthorityService service;
	@Test
	public void test() {
		List<Authority> authorities = service.findTopList();
		System.out.println(authorities.size());
		
		List<Authority> authorities1 = service.findTopList();
		System.out.println(authorities1.size());
		
	}
	
	@Resource
	private RoleService roleService;
	@Test
	public void test1() {
		Role role = roleService.getById(1L);
		System.out.println(service.findByRole(role).size() + ":---------------");
//		System.out.println(role.getAuthorities().size());
	}
	@Test
	public void testcache() {
//		service.findTopList();
//		System.out.println(service.getAllPrivilegeUrls().size());
//		CacheUtil.cacheRemoveObj("Authority:privilegeUrls", CacheUtil.LEVEL99);
//		System.out.println(service.getAllPrivilegeUrls().size());
		Role r = roleService.getById(1L);
		service.findByRole(r);
		System.out.println("===========");
		CacheUtil.cacheRemoveObj("'Authority:findRoleAll'", CacheUtil.LEVEL02);
		r = roleService.getById(3L);
		System.out.println(r.getAuthorities().size());
	}
}
