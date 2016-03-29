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

import cn.bean.MedicinePurchase;
import cn.util.PageResult;

@Repository("MedicinePurchaseDao")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class MedicinePurchaseDao extends HibernateDaoSupport{
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
		countHql.append("select count(1) from(");
		countHql.append(hql);
		countHql.append(") c");
		Query query = session.createSQLQuery(countHql.toString());
		if(properties!=null){
			query.setProperties(properties);
		}
		return Integer.parseInt(query.uniqueResult().toString());
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> query(MedicinePurchase vo,PageResult page) {
		Session session = this.getSessionFactory().getCurrentSession();
		Map<String,Object> properties = new HashMap<>();
		StringBuffer hql = new StringBuffer();
		hql.append("select t.batch_number,t.purchase_date,u.name");
		hql.append(" from medicine_purchase t");
		hql.append(" left join user_info u");
		hql.append(" on t.user_id = u.id");
		hql.append(" group by t.batch_number,t.purchase_date,u.name");
		hql.append(" order by t.purchase_date desc");
		Query query = session.createSQLQuery(hql.toString());
		query.setProperties(properties);
		if(page!=null){
			int items = getPageCount(session, hql.toString(), properties);
			page.setItems(items);
			query.setFirstResult(page.getFirstResult());
			query.setMaxResults(page.getMaxResult());
		}
		return query.list();
	}
	
	public List<Object> queryInfo(MedicinePurchase vo, PageResult page) {
		Session session = this.getSessionFactory().getCurrentSession();
		Map<String,Object> properties = new HashMap<>();
		StringBuffer hql = new StringBuffer();
		hql.append("select t.batch_number,t.purchase_date,u.name");
		hql.append(" from medicine_purchase t");
		hql.append(" left join user_info u");
		hql.append(" on t.user_id = u.id");
		hql.append(" group by t.batch_number,t.purchase_date,u.name");
		hql.append(" order by t.purchase_date desc");
		Query query = session.createSQLQuery(hql.toString());
		if(page!=null){
			int items = getPageCount(session, hql.toString(), properties);
			page.setItems(items);
			query.setFirstResult(page.getFirstResult());
			query.setMaxResults(page.getMaxResult());
		}
		return query.list();
	}
	
	public List<Object> queryByBatchNumber(MedicinePurchase vo, PageResult page){
		Session session = this.getSessionFactory().getCurrentSession();
		Map<String,Object> properties = new HashMap<>();
		StringBuffer hql = new StringBuffer();
		hql.append("select u.license_number,u.medicine_name,t.cost_price,t.number");
		hql.append(" from medicine_purchase t");
		hql.append(" left join medicine_info u");
		hql.append(" on t.medicine_id = u.id");
		hql.append(" where t.batch_number = :batchNumber");
		hql.append(" order by t.purchase_date desc");
		Query query = session.createSQLQuery(hql.toString());
		properties.put("batchNumber", vo.getBatchNumber());
		query.setProperties(properties);
		if(page!=null){
			int items = getPageCount(session, hql.toString(), properties);
			page.setItems(items);
			query.setFirstResult(page.getFirstResult());
			query.setMaxResults(page.getMaxResult());
		}
		return query.list();
	}
	
	public MedicinePurchase queryById(MedicinePurchase info){
		Session session = this.getSessionFactory().getCurrentSession();
		return session.get(MedicinePurchase.class, info.getId());
	}
}
