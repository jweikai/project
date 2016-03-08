package com.listener;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.Const;
import com.commons.MyBeanUtils;
import com.model.po.Authority;
import com.model.vo.AuthorityVO;
import com.service.AuthorityService;

public class InitDataListener implements ServletContextListener{
	private static final Logger logger = Logger.getLogger(InitDataListener.class);
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 获取容器与相关的Service对象
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		AuthorityService authorityService = (AuthorityService) ac.getBean("authorityServiceImpl");
		logger.info("------------> 已准备数据allPrivilegeUrls <------------");
		Collection<String> allAuthorityList = authorityService.getAllPrivilegeUrls();
		sce.getServletContext().setAttribute("allAuthorityList", allAuthorityList);
		
		logger.info("------------> 已准备数据TopList <------------");
		List<Authority> authoritiesTop = authorityService.findTopByShowList(Const.DO_NOT_SHOW_MENU_IDS);
		sce.getServletContext().setAttribute("authoritiesTop", authoritiesTop);
		
		Map<String, AuthorityVO> map = new HashMap<>(); 
		for (Authority p : authoritiesTop) {
			Set<Authority> list = p.getAuthorities();
			for (Authority c : list) {
				AuthorityVO acvo = new AuthorityVO();
				MyBeanUtils.copy(acvo, c, 0);
				for (Authority cc : c.getAuthorities()) {
					AuthorityVO accvo = new AuthorityVO();
					MyBeanUtils.copy(accvo, cc, 0);
					accvo.setParent(acvo);
					map.put(cc.getUrl(), accvo);
				}
			}
		}
		sce.getServletContext().setAttribute("authoritiesMap", map);
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
