package com.service.impl;

import java.util.HashSet;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.model.po.Authority;
import com.model.po.Role;
import com.service.RoleService;
import com.service.base.BaseDaoImpl;

@Service
@SuppressWarnings("unchecked")
public class RoleServiceImpl extends BaseDaoImpl<Role> implements RoleService{
	@Override
	@Cacheable(value="c02",key="'RoleService:findAll'")
	public List<Role> findAll() {
		List<Role> roles = super.findAll();
		for (Role r : roles) {
			r.setAuthorities(new HashSet<>(findAuthoirtyByRole(r)));
		}
		return roles;
	}
	
	private List<Authority> findAuthoirtyByRole(Role r) {
		return getSession().createQuery(
				"select r.authorities from Role r where r = ?")
				.setParameter(0, r)
				.list();
	}
}
