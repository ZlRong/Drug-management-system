package cn.dao;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.bean.UserLogin;

@Repository("UserDao")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class UserDao extends HibernateDaoSupport{
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	public void add(Object o){
		getHibernateTemplate().saveOrUpdate(o);
	}
	public void del(Object o){
		getHibernateTemplate().delete(o);
	}
	public void update(Object o){
		getHibernateTemplate().merge(o);
	}
	
	public UserLogin login(UserLogin vo) {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from UserLogin where username = ? and password = ?";
		Query query = session.createQuery(hql);
		query.setString(0, vo.getUsername().trim());
		query.setString(1, vo.getPassword().trim());
		UserLogin ul = (UserLogin)query.uniqueResult();
		return ul;
	}
}
