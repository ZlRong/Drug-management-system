package cn.service;

import cn.bean.UserLogin;

public interface UserService extends BaseService{

	public UserLogin login(UserLogin vo);
	
	public UserLogin queryByNumber(UserLogin vo);
}
