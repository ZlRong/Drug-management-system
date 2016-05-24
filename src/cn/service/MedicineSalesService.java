package cn.service;

import java.util.List;

import cn.bean.MedicineSales;
import cn.util.PageResult;

public interface MedicineSalesService extends BaseService{

	public List<MedicineSales> query(MedicineSales vo,PageResult page);
	
	public List<MedicineSales> queryInfo(MedicineSales vo,PageResult page);
	
	public String JSONQuery(MedicineSales vo,PageResult page);
	
	public List<MedicineSales> queryByBatchNumber(MedicineSales vo,PageResult page);
	
	public MedicineSales queryById(MedicineSales info);
	
	public boolean sale(Long[] medicineStoreHouseId ,int[] saleNumber);
}
