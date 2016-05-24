package cn.service;

import java.util.List;

import cn.bean.MedicineInfo;
import cn.util.PageResult;

public interface MedicineInfoService extends BaseService{

	public List<MedicineInfo> query(MedicineInfo vo,PageResult page);
	
	public MedicineInfo queryById(MedicineInfo info);

	public List<MedicineInfo> queryFuzzy(String search);
	
	public List<MedicineInfo> queryByDrugStandardCode(String drugStandardCode);
}
