package cn.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.bean.UserInfo;
import cn.util.PageResult;

@Repository("UserInfoDao")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class UserInfoDao extends HibernateDaoSupport{
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
	
	public int getPageCount(Session session,String hql,Map properties){
		StringBuffer countHql = new StringBuffer();
		countHql.append("select count(1) ");
		countHql.append(hql);
		Query query = session.createQuery(countHql.toString());
		if(properties!=null){
			query.setProperties(properties);
		}
		return Integer.parseInt(query.uniqueResult().toString());
	}
	
	public List<UserInfo> query(UserInfo vo,PageResult page){
		Session session = this.getSessionFactory().getCurrentSession();
		Map<String,Object> properties = new HashMap<>();
		StringBuffer hql = new StringBuffer();
		hql.append("from UserInfo");
		hql.append(" where 1=1");
		if(vo.getNumber()!=null&&!"".equals(vo.getNumber().trim())){
			hql.append(" and number = :number");
			properties.put("number", vo.getNumber().trim());
		}
		if(vo.getName()!=null&&!"".equals(vo.getName().trim())){
			hql.append(" and name = :name");
			properties.put("name",vo.getName().trim());
		}
		if(vo.getJob()!=null&&!"".equals(vo.getJob().trim())){
			hql.append(" and job = :job");
			properties.put("job",vo.getJob().trim());
		}
		hql.append(" order by number");
		Query query = session.createQuery(hql.toString());
		query.setProperties(properties);
		if(page!=null){
			int items = getPageCount(session, hql.toString(), properties);
			page.setItems(items);
			query.setFirstResult(page.getFirstResult());
			query.setMaxResults(page.getMaxResult());
		}
		return query.list();
	}
	
	public UserInfo queryById(UserInfo vo) {
		Session session = this.getSessionFactory().getCurrentSession();
		return session.get(UserInfo.class, vo.getId());
	}
}
