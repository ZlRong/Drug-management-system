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

import cn.bean.MedicineInfo;
import cn.util.PageResult;

@Repository("MedicineInfoDao")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class MedicineInfoDao extends HibernateDaoSupport{
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
	
	@SuppressWarnings("unchecked")
	public List<MedicineInfo> query(MedicineInfo vo,PageResult page) {
		Session session = this.getSessionFactory().getCurrentSession();
		Map<String,Object> properties = new HashMap<>();
		StringBuffer hql = new StringBuffer();
		hql.append("from MedicineInfo");
		hql.append(" where 1=1");
		if(vo.getMedicineName()!=null&&!"".equals(vo.getMedicineName())){
			hql.append(" and medicineName like :medicineName");
			properties.put("medicineName", "%"+vo.getMedicineName()+"%");
		}
		int items = getPageCount(session, hql.toString(), properties);
		page.setItems(items);
		Query query = session.createQuery(hql.toString());
		query.setProperties(properties);
		if(page!=null){
			query.setFirstResult(page.getFirstResult());
			query.setMaxResults(page.getMaxResult());
		}
		return query.list();
	}
	
	public MedicineInfo queryById(MedicineInfo info){
		Session session = this.getSessionFactory().getCurrentSession();
		return session.get(MedicineInfo.class, info.getId());
	}

	public List<MedicineInfo> queryFuzzy(String search) {
		Session session = this.getSessionFactory().getCurrentSession();
		StringBuffer hql = new StringBuffer();
		hql.append("from MedicineInfo");
		hql.append(" where licenseNumber like :search");
		hql.append(" or medicineName like :search");
		hql.append(" or medicineENName like :search");
		Query query = session.createQuery(hql.toString());
		query.setString("search", "%"+search+"%");
		query.setMaxResults(10);
		return query.list();
	}
}
