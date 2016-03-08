package com.action;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.Const;
import com.commons.MD5;
import com.model.po.Authority;
import com.model.po.User;

@Component
public class Installer {

	@Resource
	private SessionFactory sessionFactory;	
	
	/**
	 * 执行安装
	 */
	@Transactional
	public void install() {
		Session session = sessionFactory.getCurrentSession();
//		createAdmin(session);
		
		Authority menu1 = new Authority();
		menu1.setIcon("desktop");
		menu1.setName("系统管理");		
		menu1.setUrl(null);
		
		Authority menu11 = new Authority();
		menu11.setIcon("user");
		menu11.setName("用户管理");		
		menu11.setUrl("user_list");		
			Authority menu111 = new Authority();
			menu111.setIcon("list-ol");
			menu111.setName("用户列表");		
			menu111.setUrl("user_list");
			Authority menu113 = new Authority();
			menu113.setIcon("lock");
			menu113.setName("用户锁定");		
			menu113.setUrl("user_lock");
			Authority menu114 = new Authority();
			menu114.setIcon("trash-o");
			menu114.setName("用户删除");		
			menu114.setUrl("user_delete");
		Authority menu12 = new Authority();
		menu12.setIcon("key");
		menu12.setName("权限管理");		
		menu12.setUrl("authority_list");		
			Authority menu121 = new Authority();
			menu121.setIcon("list-ol");
			menu121.setName("权限列表");		
			menu121.setUrl("authority_list");
			Authority menu122 = new Authority();
			menu122.setIcon("plus");
			menu122.setName("权限添加");		
			menu122.setUrl("authority_add");
			Authority menu123 = new Authority();
			menu123.setIcon("trash-o");
			menu123.setName("权限删除");		
			menu123.setUrl("authority_delete");
		Authority menu13 = new Authority();
		menu13.setIcon("male");
		menu13.setName("角色管理");		
		menu13.setUrl("role_list");		
			Authority menu131 = new Authority();
			menu131.setIcon("list-ol");
			menu131.setName("角色列表");		
			menu131.setUrl("role_list");
			Authority menu132 = new Authority();
			menu132.setIcon("plus");
			menu132.setName("角色添加");		
			menu132.setUrl("role_add");
			Authority menu133 = new Authority();
			menu133.setIcon("trash-o");
			menu133.setName("角色删除");		
			menu133.setUrl("role_delete");
			Authority menu134 = new Authority();
			menu134.setIcon("pencil-square-o");
			menu134.setName("角色修改");		
			menu134.setUrl("role_update");		
			Authority menu135 = new Authority();
			menu135.setIcon("key");
			menu135.setName("设置角色权限");		
			menu135.setUrl("role_set");
		menu11.setAuthority(menu1);
		menu12.setAuthority(menu1);
		menu13.setAuthority(menu1);
		menu111.setAuthority(menu11);
		menu113.setAuthority(menu11);
		menu114.setAuthority(menu11);
		menu121.setAuthority(menu12);
		menu122.setAuthority(menu12);
		menu123.setAuthority(menu12);	
		menu131.setAuthority(menu13);
		menu132.setAuthority(menu13);
		menu133.setAuthority(menu13);
		menu134.setAuthority(menu13);
		menu135.setAuthority(menu13);
			
		Authority menu2 = new Authority();
		menu2.setIcon("send-o");
		menu2.setName("消息发送");		
		menu2.setUrl(null);		
		Authority menu21 = new Authority();
		menu21.setIcon("info-circle");
		menu21.setName("公告管理");		
		menu21.setUrl("notice_list");
			Authority menu211 = new Authority();
			menu211.setIcon("list-ol");
			menu211.setName("公告列表");		
			menu211.setUrl("notice_list");
			Authority menu212 = new Authority();
			menu212.setIcon("plus");
			menu212.setName("公告添加");		
			menu212.setUrl("notice_add");
			Authority menu213 = new Authority();
			menu213.setIcon("trash-o");
			menu213.setName("公告删除");		
			menu213.setUrl("notice_delte");
			Authority menu214 = new Authority();
			menu214.setIcon("pencil-square-o");
			menu214.setName("公告修改");		
			menu214.setUrl("notice_update");
			
		Authority menu22 = new Authority();
		menu22.setIcon("volume-up");
		menu22.setName("广播管理");		
		menu22.setUrl("broadcast_list");
			Authority menu221 = new Authority();
			menu221.setIcon("list-ol");
			menu221.setName("广播列表");		
			menu221.setUrl("broadcast_list");
			Authority menu222 = new Authority();
			menu222.setIcon("plus");
			menu222.setName("广播添加");		
			menu222.setUrl("broadcast_add");
			Authority menu223 = new Authority();
			menu223.setIcon("trash-o");
			menu223.setName("广播删除");		
			menu223.setUrl("broadcast_delte");
			Authority menu224 = new Authority();
			menu224.setIcon("pencil-square-o");
			menu224.setName("广播修改");		
			menu224.setUrl("broadcast_update");
				
		menu21.setAuthority(menu2);
		menu22.setAuthority(menu2);
		menu211.setAuthority(menu21);
		menu212.setAuthority(menu21);
		menu213.setAuthority(menu21);
		menu214.setAuthority(menu21);
		menu221.setAuthority(menu22);
		menu222.setAuthority(menu22);
		menu223.setAuthority(menu22);
		menu224.setAuthority(menu22);		
		
		Authority menu3 = new Authority();
		menu3.setIcon(null);
		menu3.setName("题目编辑");		
		menu3.setUrl(null);
		Authority menu31 = new Authority();
		menu31.setIcon("file");
		menu31.setName("题目管理");		
		menu31.setUrl("problem_list");
			Authority menu311 = new Authority();
			menu311.setIcon("list-ol");
			menu311.setName("题目列表");		
			menu311.setUrl("problem_list");
			Authority menu312 = new Authority();
			menu312.setIcon("plus");
			menu312.setName("题目添加");		
			menu312.setUrl("problem_add");
			Authority menu313 = new Authority();
			menu313.setIcon("trash-o");
			menu313.setName("题目删除");		
			menu313.setUrl("problem_delte");
			Authority menu314 = new Authority();
			menu314.setIcon("pencil-square-o");
			menu314.setName("题目修改");		
			menu314.setUrl("problem_update");
			Authority menu315 = new Authority();
			menu315.setIcon("list-ol");
			menu315.setName("题目数据列表");		
			menu315.setUrl("data_list");
			Authority menu316 = new Authority();
			menu316.setIcon("plus");
			menu316.setName("题目数据添加");		
			menu316.setUrl("data_add");
			Authority menu317 = new Authority();
			menu317.setIcon("pencil-square-o");
			menu317.setName("题目数据修改");		
			menu317.setUrl("date_update");
			Authority menu318 = new Authority();
			menu318.setIcon("trash-o");
			menu318.setName("题目数据删除");		
			menu318.setUrl("data_delete");
			
		
		Authority menu32 = new Authority();
		menu32.setIcon("sitemap");
		menu32.setName("竞赛管理");		
		menu32.setUrl("competition_list");
			Authority menu321 = new Authority();
			menu321.setIcon("list-ol");
			menu321.setName("竞赛列表");		
			menu321.setUrl("competition_list");
			Authority menu322 = new Authority();
			menu322.setIcon("plus");
			menu322.setName("竞赛添加");		
			menu322.setUrl("competition_add");
			Authority menu323 = new Authority();
			menu323.setIcon("trash-o");
			menu323.setName("竞赛删除");		
			menu323.setUrl("competition_delte");
			Authority menu324 = new Authority();
			menu324.setIcon("pencil-square-o");
			menu324.setName("竞赛修改");		
			menu324.setUrl("competition_update");
		menu31.setAuthority(menu3);
		menu32.setAuthority(menu3);
		menu311.setAuthority(menu31);
		menu312.setAuthority(menu31);
		menu313.setAuthority(menu31);
		menu314.setAuthority(menu31);
		menu315.setAuthority(menu31);
		menu316.setAuthority(menu31);
		menu317.setAuthority(menu31);
		menu318.setAuthority(menu31);
		menu321.setAuthority(menu32);
		menu322.setAuthority(menu32);
		menu323.setAuthority(menu32);
		menu324.setAuthority(menu32);		
		
		Authority menu4 = new Authority();
		menu4.setIcon(null);
		menu4.setName("资源浏览");		
		menu4.setUrl(null);
			Authority menu41 = new Authority();
			menu41.setIcon("file-code-o");
			menu41.setName("代码查看");		
			menu41.setUrl("code_browse");
		menu41.setAuthority(menu4);
		
		session.save(menu1);
		session.save(menu11);
		session.save(menu111);
		session.save(menu113);
		session.save(menu114);
		session.save(menu12);
		session.save(menu121);
		session.save(menu122);
		session.save(menu123);
		session.save(menu13);
		session.save(menu131);
		session.save(menu132);
		session.save(menu133);
		session.save(menu134);
		session.save(menu135);
		
		session.save(menu2);
		session.save(menu21);
		session.save(menu211);
		session.save(menu212);
		session.save(menu213);
		session.save(menu214);
		session.save(menu22);
		session.save(menu221);
		session.save(menu222);
		session.save(menu223);
		session.save(menu224);
		
		session.save(menu3);
		session.save(menu31);
		session.save(menu311);
		session.save(menu312);
		session.save(menu313);
		session.save(menu314);
		session.save(menu315);
		session.save(menu316);
		session.save(menu317);
		session.save(menu318);
		session.save(menu32);
		session.save(menu321);
		session.save(menu322);
		session.save(menu323);
		session.save(menu324);
		
		session.save(menu4);
		session.save(menu41);
	}

	private void createAdmin(Session session) {		
		User user = new User();
		user.setName("SuperAdmin");		
		user.setPassword(MD5.MD5Encode("admin"));
		user.setIsEmail(true);
		user.setCreateTime(Const.getCurrentTimestamp());
		session.save(user);
	}

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		Installer installer = (Installer) ac.getBean("installer");
		installer.install();		
	}
}


