package cn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.bean.UserInfo;
import cn.bean.UserLogin;
import cn.dao.UserDao;
import cn.dao.UserInfoDao;
import cn.service.UserInfoService;
import cn.util.PageResult;

@Repository("UserInfoServiceImpl")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class UserInfoServiceImpl implements UserInfoService {

	@Resource(name = "UserInfoDao")
	private UserInfoDao dao;
	@Resource(name = "UserDao")
	private UserDao loginDao;
	
	public UserInfoDao getDao() {
		return dao;
	}

	public void setDao(UserInfoDao dao) {
		this.dao = dao;
	}

	public UserDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(UserDao loginDao) {
		this.loginDao = loginDao;
	}

	@Override
	public void add(Object o) {
		dao.add(o);
	}

	@Override
	public void del(Object o) {
		dao.del(o);
	}

	@Override
	public void update(Object o) {
		dao.update(o);
	}
	
	@Override
	public List<UserInfo> query(UserInfo vo, PageResult page) {
		return dao.query(vo, page);
	}

	@Override
	public UserInfo queryById(UserInfo vo) {
		return dao.queryById(vo);
	}

	@Override
	public void add(UserInfo vo,UserLogin login){
		dao.add(vo);
		loginDao.add(login);
	}

	@Override
	public String JSONQuery(UserInfo vo, PageResult page) {
		List<UserInfo> users = dao.query(vo, page);
		JSONArray ja = new JSONArray();
		JSONObject jo = null;
		for(UserInfo u :users){
			jo = new JSONObject();
			jo.put("id", u.getId());
			jo.put("number", u.getNumber());
			jo.put("name", u.getName());
			jo.put("phone", u.getPhone());
			jo.put("address", u.getAddress());
			jo.put("job", u.getJob());
			ja.add(jo);
		}
		return ja.toJSONString();
	}
}
