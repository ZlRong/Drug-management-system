package cn.service;

import java.util.List;

import cn.bean.MedicinePurchase;
import cn.util.PageResult;

public interface MedicinePurchaseService extends BaseService{

	public List<MedicinePurchase> query(MedicinePurchase vo,PageResult page);
	
	public List<MedicinePurchase> queryInfo(MedicinePurchase vo,PageResult page);
	
	public String JSONQuery(MedicinePurchase vo,PageResult page);

	public List<MedicinePurchase> queryByBatchNumber(MedicinePurchase vo,PageResult page);
	
	public MedicinePurchase queryById(MedicinePurchase info);
}
