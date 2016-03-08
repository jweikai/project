package com.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.commons.CacheUtil;
import com.model.po.Authority;
import com.model.po.Role;
import com.service.AuthorityService;
import com.service.RoleService;
import com.service.base.BaseDaoImpl;

@Service
@SuppressWarnings("unchecked")
public class AuthorityServiceImpl extends BaseDaoImpl<Authority> implements AuthorityService{
	public List<Authority> findTopList() {
		Object obj = CacheUtil.cacheGetObj("Authority:topList", "c99");
		if ( obj == null ) {
			findAll();
			obj = CacheUtil.cacheGetObj("Authority:topList", "c99");
		}		
		return (List<Authority>)obj;
	}
	public Collection<String> getAllPrivilegeUrls() {
		Object obj = CacheUtil.cacheGetObj("Authority:privilegeUrls", "c99");
		if ( obj == null ) {
			findAll();
			obj = CacheUtil.cacheGetObj("Authority:privilegeUrls", "c99");
		}
		return (Collection<String>) obj;
	}
	
	public Set<Authority> findByRole(Role role) {
		for (Role r : roleService.findAll()) {
			if ( r.getId() == role.getId() ) {
				return r.getAuthorities();
			}
		}
		return null;
	}
	@Resource
	private RoleService roleService;
	
	@Cacheable(value="c99",key="#root.targetClass+':'+#root.methodName")
	@Override
	public List<Authority> findAll() {
		List<Authority> authorities = super.findAll();
		Set<String> urls = new HashSet<String>();
		List<Authority> tops = new ArrayList<Authority>();
		for (Authority a : authorities) {
			if ( a.getUrl() == null ) {
				tops.add(a);
			}else {
				if ( urls.contains(a.getUrl()) ) {
					continue ;
				}
				urls.add(a.getUrl());
			}
		}
		CacheUtil.cacheSetObj("Authority:topList", tops, CacheUtil.LEVEL99);
		CacheUtil.cacheSetObj("Authority:privilegeUrls", urls, CacheUtil.LEVEL99);
		return authorities;
	}
	
	public List<Authority> findTopByShowList(Long[] ids) {
		List<Authority> topList = new ArrayList<Authority>(findTopList());
		for (Long id : ids) {
			int k = -1;
			for (int i = 0; i < topList.size(); i ++) {				
				if ( topList.get(i).getId() == id ) {
					k = i;
					break;
				}
			}
			if ( k != -1 ) topList.remove(k);
		}		
		return topList;
	}
}
