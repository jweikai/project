package com.action.admin;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.Const;
import com.action.base.BaseAction;
import com.annotation.Admin;
import com.annotation.Log;
import com.commons.QueryHelper;
import com.model.po.Problem;
import com.model.po.User;
import com.model.vo.Json;
import com.model.vo.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.service.ProblemService;

@Admin
@Controller
@Scope("prototype")
public class AdminProblemsAction extends BaseAction<Problem>{
	@Resource
	private ProblemService problemService;	
	private String key;
	public String list() {
		boolean isKey = true;
		if ( key == null || "".equals(key.trim()) ) isKey = false;
		QueryHelper queryHelper = new QueryHelper(Problem.class, "p")
					.addCondition(isKey, "name like ?", "%"+ key +"%");
		PageBean pageBean = problemService.getPageBean(pageNum, pageSize, queryHelper);
		ActionContext.getContext().getValueStack().push(pageBean); 
		return "list";
	}
	
	public String addUI() {
		return "saveUI";
	}
	
	@Log("问题添加")
	public String add() {
		problemService.save(model);
		return "toList";
	}
	
	public String updateUI() {
		ActionContext.getContext().getValueStack().push(problemService.getById(model.getId()));
		return "saveUI";
	}
	
	@Log("问题更新")
	public String update() {
		return "toList";
	}
	
	private Long[] ids;
	@Log("问题删除")
	public void delete() {
		Json json = new Json();
		try {
			problemService.delete(ids);
		}catch ( Exception e ) {
			json.setMsg(e.getMessage());
			json.setSuccess(false);
		}
		json.setSuccess(true);
		json.setMsg("删除成功");
		writeJson(json);
	}
	
	public Long[] getIds() {
		return ids;
	}
	public void setIds(Long[] ids) {
		this.ids = ids;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
}
