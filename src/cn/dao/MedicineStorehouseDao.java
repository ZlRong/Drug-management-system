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
import cn.bean.MedicineStorehouse;
import cn.util.PageResult;

@Repository("MedicineStorehouseDao")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class MedicineStorehouseDao extends HibernateDaoSupport{
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
	public List<Object> query(MedicineStorehouse vo,PageResult page) {
		Session session = this.getSessionFactory().getCurrentSession();
		Map<String,Object> properties = new HashMap<>();
		StringBuffer hql = new StringBuffer();
		hql.append("select t.id,t.medicine_id,j.medicine_name,t.mfg,t.exp,");
		hql.append("t.number,t.price,t.purchase_id,k.cost_price");
		hql.append(" from medicine_storehouse t");
		hql.append(" left join medicine_info j");
		hql.append(" on t.medicine_id = j.id");
		hql.append(" left join medicine_purchase k");
		hql.append(" on t.purchase_id = k.id");
		hql.append(" where 1=1");
		hql.append(" and t.price>=0");
		if(vo.getMedicineName()!=null&&!"".equals(vo.getMedicineName())){
			hql.append(" and j.medicine_name like :medicineName");
			properties.put("medicineName", "%"+vo.getMedicineName()+"%");
		}
		hql.append(" order by t.exp");

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
	
	@SuppressWarnings("unchecked")
	public List<Object> queryExpired(MedicineStorehouse vo,PageResult page) {
		Session session = this.getSessionFactory().getCurrentSession();
		Map<String,Object> properties = new HashMap<>();
		StringBuffer hql = new StringBuffer();
		hql.append("select t.id,t.medicine_id,j.medicine_name,t.mfg,t.exp,");
		hql.append("t.number,t.price,t.purchase_id");
		hql.append(" from medicine_storehouse t");
		hql.append(" left join medicine_info j");
		hql.append(" on t.medicine_id = j.id");
		hql.append(" where 1=1");
		hql.append(" and t.exp<curdate()");
		hql.append(" and t.price>=0");
		if(vo.getMedicineName()!=null&&!"".equals(vo.getMedicineName())){
			hql.append(" and j.medicine_name like :medicineName");
			properties.put("medicineName", "%"+vo.getMedicineName()+"%");
		}
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
	
	@SuppressWarnings("unchecked")
	public List<Object> queryNotExpired(MedicineStorehouse vo,PageResult page) {
		Session session = this.getSessionFactory().getCurrentSession();
		Map<String,Object> properties = new HashMap<>();
		StringBuffer hql = new StringBuffer();
		hql.append("select t.id,t.medicine_id,j.medicine_name,t.mfg,t.exp,");
		hql.append("t.number,t.price,t.purchase_id");
		hql.append(" from medicine_storehouse t");
		hql.append(" left join medicine_info j");
		hql.append(" on t.medicine_id = j.id");
		hql.append(" where 1=1");
		hql.append(" and t.exp>curdate()");
		if(vo.getMedicineName()!=null&&!"".equals(vo.getMedicineName())){
			hql.append(" and j.medicine_name like :medicineName");
			properties.put("medicineName", "%"+vo.getMedicineName()+"%");
		}
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
	
	public MedicineStorehouse queryById(MedicineStorehouse info){
		Session session = this.getSessionFactory().getCurrentSession();
		return session.get(MedicineStorehouse.class, info.getId());
	}
}
