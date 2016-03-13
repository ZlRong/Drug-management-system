package cn.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.bean.UserInfo;
import cn.bean.UserLogin;
import cn.service.UserInfoService;
import cn.service.UserService;
import cn.util.Constants;
@Controller("LoginAction")
@Scope("prototype")
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = -6343033204510625187L;

	@Resource(name = "UserServiceImpl")
	private UserService service;
	@Resource(name = "UserInfoServiceImpl")
	private UserInfoService userInfoService;
	private UserLogin vo;
	private String password;
	private String newPassword;
	
	public UserLogin getVo() {
		return vo;
	}

	public void setVo(UserLogin vo) {
		this.vo = vo;
	}

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}
	
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public void add(){
		UserLogin userLogin = new UserLogin();
		userLogin.setNumber("1001");
		userLogin.setUsername("admin");
		userLogin.setPassword("admin");
		service.add(userLogin);
		System.out.println("success.");
	}

	public String login(){
		UserLogin userLogin = service.login(vo);
		if(userLogin!=null){
			UserInfo u = new UserInfo();
			u.setNumber(userLogin.getNumber());
			UserInfo user = userInfoService.query(u,null).get(0);
			userLogin.setName(user.getName());
			ActionContext.getContext().getSession().put(Constants.USER, userLogin);
			return "index";
		}
		else{
			return "login";
		}
	}
	
	public String logout(){
		ActionContext.getContext().getSession().clear();
		return "login";
	}
	
	public String toChangePassword(){
		return "changepassword";
	}
	
	public String changePassword(){
		UserLogin userLogin =(UserLogin) ActionContext.getContext().getSession().get(Constants.USER);
		System.out.println(password+":"+newPassword);
		if(userLogin.getPassword().equals(password)){
			userLogin.setPassword(newPassword);
			service.update(userLogin);
			return "login";
		}
		else{
			ActionContext.getContext().put(Constants.ERROR, "原密码错误。");
			return "changepassword";
		}
	}
}
