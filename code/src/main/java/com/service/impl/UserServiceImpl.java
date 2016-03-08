package com.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Const;
import com.model.po.User;
import com.service.UserService;
import com.service.base.BaseDaoImpl;

@Service
@SuppressWarnings("unchecked")
public class UserServiceImpl extends BaseDaoImpl<User> implements UserService{

	@Override
	public List<User> hasRoleUser() {
		return getSession().createQuery(
				"from User u where u.roles.size != 0 and u.id != ?")
				.setParameter(0, Const.SUPER_USER_ID)
				.list();
	}
	
	@Override
	public List<User> search(String key) {		
		return getSession().createQuery(
				"from User u where u.name like ? and u.id != ?")
				.setParameter(0, "%" + key + "%")
				.setParameter(1, Const.SUPER_USER_ID)
				.list();
	}
	
	@Override
	public User getByName(String name) {
		return (User) getSession().createQuery(
				"from User u where u.name = ? and u.id != ?")
				.setParameter(0, name)
				.setParameter(1, Const.SUPER_USER_ID)
				.uniqueResult();
	}

	@Override
	public User login(String name, String password) {
		return (User) getSession().createQuery(
					"from User u where u.name=? and u.password=?")
					.setParameter(0, name)
					.setParameter(1, password)
					.uniqueResult();
	}
}
