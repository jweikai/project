package com.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.po.Logs;
import com.service.LogsService;
import com.service.base.BaseDaoImpl;

@Service
public class LogsServiceImpl extends BaseDaoImpl<Logs> implements LogsService{

}
