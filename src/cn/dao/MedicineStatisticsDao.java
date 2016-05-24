package cn.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
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

@Repository("MedicineStatisticsDao")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class MedicineStatisticsDao extends HibernateDaoSupport{
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
	
	//统计指定月份前10名销量最高的药品
	public List<Object> queryNumberAllMedicine(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Session session = this.getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append("select sum(t.sale_number),m.medicine_name");
		sql.append(" from medicine_sales t");
		sql.append(" left join medicine_storehouse h");
		sql.append(" on t.medicine_store_house_id = h.id");
		sql.append(" left join medicine_info m");
		sql.append(" on h.medicine_id=m.id");
		sql.append(" where date_format(t.sale_date,'%Y-%m')=:date");
		sql.append(" group by m.medicine_name");
		sql.append(" order by sum(t.sale_number) desc");
		Query query = session.createSQLQuery(sql.toString());
		query.setString("date", sdf.format(date));
		query.setMaxResults(10);
		return query.list();
	}
	
	//统计指定年份前10名销量最高的药品
	public List<Object> queryNumberAllMedicineYear(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Session session = this.getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append("select sum(t.sale_number),m.medicine_name");
		sql.append(" from medicine_sales t");
		sql.append(" left join medicine_storehouse h");
		sql.append(" on t.medicine_store_house_id = h.id");
		sql.append(" left join medicine_info m");
		sql.append(" on h.medicine_id=m.id");
		sql.append(" where date_format(t.sale_date,'%Y')=:date");
		sql.append(" group by m.medicine_name");
		sql.append(" order by sum(t.sale_number) desc");
		Query query = session.createSQLQuery(sql.toString());
		query.setString("date", sdf.format(date));
		query.setMaxResults(10);
		return query.list();
	}
	
	//统计指定月份前10名销售额最高的药品
	public List<Object> querySalesAllMedicine(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Session session = this.getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append("select sum(t.sale_number*t.sale_price),m.medicine_name");
		sql.append(" from medicine_sales t");
		sql.append(" left join medicine_storehouse h");
		sql.append(" on t.medicine_store_house_id = h.id");
		sql.append(" left join medicine_info m");
		sql.append(" on h.medicine_id=m.id");
		sql.append(" where date_format(t.sale_date,'%Y-%m')=:date");
		sql.append(" group by m.medicine_name");
		sql.append(" order by sum(t.sale_number*t.sale_price) desc");
		Query query = session.createSQLQuery(sql.toString());
		query.setString("date", sdf.format(date));
		query.setMaxResults(10);
		return query.list();
	}
	
	//统计指定年份前10名销售额最高的药品
	public List<Object> querySalesAllMedicineYear(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Session session = this.getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append("select sum(t.sale_number*t.sale_price),m.medicine_name");
		sql.append(" from medicine_sales t");
		sql.append(" left join medicine_storehouse h");
		sql.append(" on t.medicine_store_house_id = h.id");
		sql.append(" left join medicine_info m");
		sql.append(" on h.medicine_id=m.id");
		sql.append(" where date_format(t.sale_date,'%Y')=:date");
		sql.append(" group by m.medicine_name");
		sql.append(" order by sum(t.sale_number*t.sale_price) desc");
		Query query = session.createSQLQuery(sql.toString());
		query.setString("date", sdf.format(date));
		query.setMaxResults(10);
		return query.list();
	}
	
	//统计指定年份的盈利分析
	public List<Object> queryPA(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Session session = this.getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append("select sum(t.sale_number*(t.sale_price-p.cost_price)),date_format(t.sale_date,'%m')");
		sql.append(" from medicine_sales t");
		sql.append(" left join medicine_storehouse h");
		sql.append(" on t.medicine_store_house_id = h.id");
		sql.append(" left join medicine_purchase p");
		sql.append(" on h.purchase_id=p.id");
		sql.append(" where date_format(t.sale_date,'%Y')=:date");
		sql.append(" group by date_format(t.sale_date,'%m')");
		sql.append(" order by sum(t.sale_number*t.sale_price) desc");
		Query query = session.createSQLQuery(sql.toString());
		query.setString("date", sdf.format(date));
		return query.list();
	}
	
}
