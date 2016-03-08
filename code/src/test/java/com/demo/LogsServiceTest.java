package com.demo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.Const;
import com.model.po.Logs;
import com.service.LogsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml"})
@TransactionConfiguration(transactionManager = "hibernateTransactionManager")	//配置defaulRollback，默认是true直接回滚, 如果想直接提交设置成false
@Transactional
public class LogsServiceTest {
	@Resource 
	private LogsService logsService;
	@Test
	public void test() {
		Logs logs = logsService.getById(5L);
//		logs.setId(1L);
		logs.setDoing("asdfa");
		logs.setTime(Const.getCurrentTimestamp());
		logs.setIp("adfa");
		logs.setUserId(1L);
		logs.setUserRealName("zcvzxc");
		logsService.update(logs);
//		logsService.delete(logs.getId());
	}
	
}
