package cn.service;

import java.util.List;

import cn.bean.UserInfo;
import cn.bean.UserLogin;
import cn.util.PageResult;

public interface UserInfoService extends BaseService{

	public List<UserInfo> query(UserInfo vo, PageResult page);
	
	public UserInfo queryById(UserInfo vo);

	public void add(UserInfo vo, UserLogin login);
}
