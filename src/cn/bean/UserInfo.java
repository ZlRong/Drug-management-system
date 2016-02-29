package cn.bean;

import java.io.Serializable;
/**
 * 员工基本信息表
 * @author Zrong
 *
 */
public class UserInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6334933348559011841L;
	private Long id;		//id
	private String name;	//姓名
	private String number;	//工号
	private String address;	//地址
	private String phone;	//联系方式
	private String job;		//职位
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
}
