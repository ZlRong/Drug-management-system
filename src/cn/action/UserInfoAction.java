package cn.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.bean.UserInfo;
import cn.bean.UserLogin;
import cn.service.UserInfoService;
import cn.service.UserService;
import cn.util.Constants;
import cn.util.PageResult;

@Controller("UserInfoAction")
@Scope("prototype")
public class UserInfoAction extends ActionSupport {
	
	private static final long serialVersionUID = 7197632120603898587L;
	
	@Resource(name = "UserInfoServiceImpl")
	private UserInfoService service;
	@Resource(name = "UserServiceImpl")
	private UserService loginService;
	
	private UserInfo vo = new UserInfo();
	private UserLogin login = new UserLogin();
	private PageResult page = new PageResult();
	private List<UserInfo> list;
	public UserInfo getVo() {
		return vo;
	}

	public void setVo(UserInfo vo) {
		this.vo = vo;
	}

	public UserLogin getLogin() {
		return login;
	}

	public void setLogin(UserLogin login) {
		this.login = login;
	}

	public PageResult getPage() {
		return page;
	}

	public void setPage(PageResult page) {
		this.page = page;
	}

	public List<UserInfo> getList() {
		return list;
	}

	public void setList(List<UserInfo> list) {
		this.list = list;
	}

	@JSON(serialize=false)
	public UserInfoService getService() {
		return service;
	}

	public void setService(UserInfoService service) {
		this.service = service;
	}

	public String query(){
		List<UserInfo> list = service.query(vo,page);
		ActionContext.getContext().put(Constants.QUERY, list);
		return "query";
	}
	
	public void JSONQuery(){
		String list = service.JSONQuery(vo, page);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		try {
			PrintWriter  out = response.getWriter();
			out.write(list);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String toAdd(){
		return "add";
	}
	
	public String toEdit(){
		UserInfo edit = service.queryById(vo);
		ActionContext.getContext().put(Constants.EDIT, edit);
		return "edit";
	}
	
	public String add(){
		login.setNumber(vo.getNumber());
		service.add(vo,login);
		return "requery";
	}
	
	public String update(){
		service.update(vo);
		ActionContext.getContext().put(Constants.EDIT, vo);
		return "edit";
	}
	
	public String delete(){
		UserLogin ul = new UserLogin();
		ul.setNumber(vo.getNumber());
		ul = loginService.queryByNumber(ul);
		service.del(vo);
		loginService.del(ul);
		return query();
	}
	
	public String detail(){
		UserInfo UserInfo = service.queryById(vo);
		ActionContext.getContext().put(Constants.DETAIL, UserInfo);
		return "detail";
	}
	
}
