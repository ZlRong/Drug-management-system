package cn.service;

import java.util.Date;

import org.jfree.data.category.DefaultCategoryDataset;

public interface MedicineStatisticsService extends BaseService{

	public DefaultCategoryDataset queryNumberAllMedicine(Date date);
	
	public DefaultCategoryDataset queryNumberAllMedicineYear(Date date);
	
	public DefaultCategoryDataset querySalesAllMedicine(Date date);
	
	public DefaultCategoryDataset querySalesAllMedicineYear(Date date);
	
	public DefaultCategoryDataset queryPA(Date date);
}
