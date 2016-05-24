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

import cn.bean.MedicineSales;
import cn.util.PageResult;

@Repository("MedicineSalesDao")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class MedicineSalesDao extends HibernateDaoSupport{
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
	public List<Object> query(MedicineSales vo,PageResult page) {
		Session session = this.getSessionFactory().getCurrentSession();
		Map<String,Object> properties = new HashMap<>();
		StringBuffer hql = new StringBuffer();
		hql.append("select t.sale_batch_number,t.sale_date,u.name");
		hql.append(" from medicine_sales t");
		hql.append(" left join user_info u");
		hql.append(" on t.user_id = u.id");
		hql.append(" group by t.sale_batch_number,t.sale_date,u.name");
		hql.append(" order by t.sale_date desc");
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
	
	public List<Object> queryByBatchNumber(MedicineSales vo, PageResult page){
		Session session = this.getSessionFactory().getCurrentSession();
		Map<String,Object> properties = new HashMap<>();
		StringBuffer hql = new StringBuffer();
		hql.append("select u.license_number,u.medicine_name,t.sale_price,t.sale_number");
		hql.append(" from medicine_sales t");
		hql.append(" left join medicine_storehouse s");
		hql.append(" on t.medicine_store_house_id = s.id");
		hql.append(" left join medicine_info u");
		hql.append(" on s.medicine_id = u.id");
		hql.append(" where t.sale_batch_number = :batchNumber");
		hql.append(" order by t.sale_date desc");
		Query query = session.createSQLQuery(hql.toString());
		properties.put("batchNumber", vo.getSaleBatchNumber());
		query.setProperties(properties);
		if(page!=null){
			int items = getPageCount(session, hql.toString(), properties);
			page.setItems(items);
			query.setFirstResult(page.getFirstResult());
			query.setMaxResults(page.getMaxResult());
		}
		return query.list();
	}
	
	public MedicineSales queryById(MedicineSales info){
		Session session = this.getSessionFactory().getCurrentSession();
		return session.get(MedicineSales.class, info.getId());
	}
}
