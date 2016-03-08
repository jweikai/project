package com.service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.model.po.Authority;
import com.model.po.Role;
import com.service.base.BaseDao;

public interface AuthorityService extends BaseDao<Authority>{
	List<Authority> findTopList();
	Collection<String> getAllPrivilegeUrls();
	Set<Authority> findByRole(Role role);
	List<Authority> findTopByShowList(Long[] ids);
}
