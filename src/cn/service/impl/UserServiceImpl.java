package cn.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.bean.UserLogin;
import cn.dao.UserDao;
import cn.service.UserService;

@Repository("UserServiceImpl")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

	@Resource(name = "UserDao")
	private UserDao dao;
	
	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
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
	public UserLogin login(UserLogin vo) {
		return dao.login(vo);
	}

	@Override
	public UserLogin queryByNumber(UserLogin vo) {
		return dao.queryByNumber(vo);
	}

}
