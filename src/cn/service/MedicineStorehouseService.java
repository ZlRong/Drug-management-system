package cn.service;

import java.util.List;

import cn.bean.MedicineStorehouse;
import cn.util.PageResult;

public interface MedicineStorehouseService extends BaseService{

	public List<MedicineStorehouse> query(MedicineStorehouse vo,PageResult page);
	
	public String JSONQuery(MedicineStorehouse vo,PageResult page);
	
	public MedicineStorehouse queryById(MedicineStorehouse info);
	
	public List<MedicineStorehouse> queryExpired(MedicineStorehouse vo,PageResult page);
	
	List<MedicineStorehouse> queryNotExpired(MedicineStorehouse vo,PageResult page);

	public boolean dealWith(MedicineStorehouse vo);
}
