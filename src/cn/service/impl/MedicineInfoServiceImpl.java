package cn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.bean.MedicineInfo;
import cn.dao.MedicineInfoDao;
import cn.service.MedicineInfoService;
import cn.util.PageResult;

@Repository("MedicineInfoServiceImpl")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class MedicineInfoServiceImpl implements MedicineInfoService {

	@Resource(name = "MedicineInfoDao")
	private MedicineInfoDao dao;
	
	public MedicineInfoDao getDao() {
		return dao;
	}

	public void setDao(MedicineInfoDao dao) {
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
	public List<MedicineInfo> query(MedicineInfo vo,PageResult page) {
		return dao.query(vo,page);
	}

	@Override
	public MedicineInfo queryById(MedicineInfo info) {
		return dao.queryById(info);
	}

	@Override
	public List<MedicineInfo> queryFuzzy(String search) {
		return dao.queryFuzzy(search);
	}

	@Override
	public List<MedicineInfo> queryByDrugStandardCode(String drugStandardCode) {
		return dao.queryByDrugStandardCode(drugStandardCode);
	}
}
