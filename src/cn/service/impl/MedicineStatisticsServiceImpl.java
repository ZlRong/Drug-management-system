package cn.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.dao.MedicineStatisticsDao;
import cn.service.MedicineStatisticsService;

@Repository("MedicineStatisticsServiceImpl")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class MedicineStatisticsServiceImpl implements MedicineStatisticsService {

	@Resource(name = "MedicineStatisticsDao")
	private MedicineStatisticsDao dao;
		
	public MedicineStatisticsDao getDao() {
		return dao;
	}

	public void setDao(MedicineStatisticsDao dao) {
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
	public DefaultCategoryDataset queryNumberAllMedicine(Date date) {
		List<Object> objList = dao.queryNumberAllMedicine(date);
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(Object obj : objList){
			Object[] o = (Object[])obj;
			BigDecimal number = (BigDecimal)o[0];
			dataset.addValue(number.intValue(), "药品", (String)o[1]);
		}
		return dataset;
	}

	@Override
	public DefaultCategoryDataset queryNumberAllMedicineYear(Date date) {
		List<Object> objList = dao.queryNumberAllMedicineYear(date);
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(Object obj : objList){
			Object[] o = (Object[])obj;
			BigDecimal number = (BigDecimal)o[0];
			dataset.addValue(number.intValue(), "药品", (String)o[1]);
		}
		return dataset;
	}

	@Override
	public DefaultCategoryDataset querySalesAllMedicine(Date date) {
		List<Object> objList = dao.querySalesAllMedicine(date);
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(Object obj : objList){
			Object[] o = (Object[])obj;
			double number = (double)o[0];
			dataset.addValue(number, "药品", (String)o[1]);
		}
		return dataset;
	}

	@Override
	public DefaultCategoryDataset querySalesAllMedicineYear(Date date) {
		List<Object> objList = dao.querySalesAllMedicineYear(date);
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(Object obj : objList){
			Object[] o = (Object[])obj;
			double number = (double)o[0];
			dataset.addValue(number, "药品", (String)o[1]);
		}
		return dataset;
	}

	@Override
	public DefaultCategoryDataset queryPA(Date date) {
		List<Object> objList = dao.queryPA(date);
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(int i=1,j=0;i<=12;i++){
			Object[] o = (Object[])objList.get(j);
			double number = (double)o[0];
			String moonStr = (String)o[1];
			int moon = Integer.parseInt(moonStr);
			if(moon==i){
				dataset.addValue(number, "药品", String.valueOf(i));
				j++;
			}
			else{
				dataset.addValue(0, "药品", String.valueOf(i));
			}
		}
		return dataset;
	}


}
