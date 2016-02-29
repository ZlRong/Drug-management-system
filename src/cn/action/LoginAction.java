package cn.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.bean.UserLogin;
import cn.service.UserService;
@Controller("LoginAction")
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = -6343033204510625187L;

	@Resource(name = "UserServiceImpl")
	private UserService service;
	private UserLogin vo;
	
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

	public String login(){
		UserLogin userLogin = service.login(vo);
		if(userLogin!=null){
		return "index";
		}
		else{
			return "login";
		}
	}
}
