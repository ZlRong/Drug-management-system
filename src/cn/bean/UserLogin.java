package cn.bean;

import java.io.Serializable;
/**
 * 员工登录表
 * @author Zrong
 *
 */
public class UserLogin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4505385491620085902L;
	private Long id;			//id
	private String number;		//工号
	private String username;	//用户名
	private String password;	//密码
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
