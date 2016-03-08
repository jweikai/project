package com.service;

import java.util.List;

import com.model.po.User;
import com.service.base.BaseDao;

public interface UserService extends BaseDao<User>{
	List<User> hasRoleUser();
	List<User> search(String key);
	User getByName(String name);
	User login(String name, String password);
}
