package cn.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.bean.MedicineStorehouse;
import cn.dao.MedicineStorehouseDao;
import cn.service.MedicineStorehouseService;
import cn.util.MathUtil;
import cn.util.PageResult;

@Repository("MedicineStorehouseServiceImpl")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class MedicineStorehouseServiceImpl implements MedicineStorehouseService {

	@Resource(name = "MedicineStorehouseDao")
	private MedicineStorehouseDao dao;
		
	public MedicineStorehouseDao getDao() {
		return dao;
	}

	public void setDao(MedicineStorehouseDao dao) {
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
	public List<MedicineStorehouse> query(MedicineStorehouse vo,PageResult page) {
		List<Object> objList= dao.query(vo,page);
		List<MedicineStorehouse> list = new ArrayList<MedicineStorehouse>();
		MedicineStorehouse m = null;
		for(Object obj:objList){
			m = new MedicineStorehouse();
			Object[] o = (Object[])obj;
			Long id = MathUtil.valueToLong(o[0]);
			Long medicineId = MathUtil.valueToLong(o[1]);
			String medicineName = (String)o[2];
			Date mfg = (Date)o[3];
			Date exp = (Date)o[4];
			int number = (int)o[5];
			double price = (double)o[6];
			Long purchaseId = MathUtil.valueToLong(o[7]);
			m.setId(id);
			m.setMedicineId(medicineId);
			m.setMfg(mfg);
			m.setExp(exp);
			m.setNumber(number);
			m.setPrice(price);
			m.setPurchaseId(purchaseId);
			m.setMedicineName(medicineName);
			list.add(m);
		}
		return list;
	}

	@Override
	public MedicineStorehouse queryById(MedicineStorehouse info) {
		return dao.queryById(info);
	}

}
