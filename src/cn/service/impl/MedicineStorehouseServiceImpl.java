package cn.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.bean.MedicinePurchase;
import cn.bean.MedicineStorehouse;
import cn.dao.MedicinePurchaseDao;
import cn.dao.MedicineStorehouseDao;
import cn.service.MedicineStorehouseService;
import cn.util.MathUtil;
import cn.util.PageResult;

@Repository("MedicineStorehouseServiceImpl")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class MedicineStorehouseServiceImpl implements MedicineStorehouseService {

	@Resource(name = "MedicineStorehouseDao")
	private MedicineStorehouseDao dao;
	@Resource(name = "MedicinePurchaseDao")
	private MedicinePurchaseDao purchaseDao;
		
	public MedicineStorehouseDao getDao() {
		return dao;
	}

	public void setDao(MedicineStorehouseDao dao) {
		this.dao = dao;
	}

	public MedicinePurchaseDao getPurchaseDao() {
		return purchaseDao;
	}

	public void setPurchaseDao(MedicinePurchaseDao purchaseDao) {
		this.purchaseDao = purchaseDao;
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
			double costPrice = (double)o[8];
			m.setId(id);
			m.setMedicineId(medicineId);
			m.setMfg(mfg);
			m.setExp(exp);
			m.setNumber(number);
			m.setPrice(price);
			m.setPurchaseId(purchaseId);
			m.setMedicineName(medicineName);
			m.setCostPrice(costPrice);
			list.add(m);
			if(exp.getTime()<new Date().getTime()){
				m.setStatus("已过期");
			}
			else if(price>0){
				m.setStatus("已上架");
			}
			else{
				m.setStatus("未上架");
			}
		}
		return list;
	}

	@Override
	public MedicineStorehouse queryById(MedicineStorehouse info) {
		return dao.queryById(info);
	}

	@Override
	public List<MedicineStorehouse> queryExpired(MedicineStorehouse vo, PageResult page) {
		List<Object> objList= dao.queryExpired(vo, page);
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
			double costPrice = (double)o[8];
			m.setId(id);
			m.setMedicineId(medicineId);
			m.setMfg(mfg);
			m.setExp(exp);
			m.setNumber(number);
			m.setPrice(price);
			m.setPurchaseId(purchaseId);
			m.setMedicineName(medicineName);
			m.setCostPrice(costPrice);
			list.add(m);
		}
		return list;
	}

	@Override
	public List<MedicineStorehouse> queryNotExpired(MedicineStorehouse vo, PageResult page) {
		List<Object> objList= dao.queryNotExpired(vo, page);
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
			double costPrice = (double)o[8];
			m.setId(id);
			m.setMedicineId(medicineId);
			m.setMfg(mfg);
			m.setExp(exp);
			m.setNumber(number);
			m.setPrice(price);
			m.setPurchaseId(purchaseId);
			m.setMedicineName(medicineName);
			m.setCostPrice(costPrice);
			list.add(m);
		}
		return list;
	}

	@Override
	public boolean dealWith(MedicineStorehouse vo) {
		boolean isFlag = false;
		MedicineStorehouse m = dao.queryById(vo);
		MedicinePurchase p = new MedicinePurchase();
		p.setId(m.getPurchaseId());
		p = purchaseDao.queryById(p);
		m.setPrice(0-p.getCostPrice());
		dao.update(m);
		isFlag = true;
		return isFlag;
	}

	@Override
	public String JSONQuery(MedicineStorehouse vo, PageResult page) {
		List<Object> objList= dao.query(vo,page);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		JSONArray ja = new JSONArray();
		JSONObject jo = null;
		for(Object obj:objList){
			jo = new JSONObject();
			Object[] o = (Object[])obj;
			Long id = MathUtil.valueToLong(o[0]);
			Long medicineId = MathUtil.valueToLong(o[1]);
			String medicineName = (String)o[2];
			Date mfg = (Date)o[3];
			Date exp = (Date)o[4];
			int number = (int)o[5];
			double price = (double)o[6];
			Long purchaseId = MathUtil.valueToLong(o[7]);
			double costPrice = (double)o[8];
			jo.put("id", id);
			jo.put("medicineId", medicineId);
			jo.put("mfg", sdf.format(mfg));
			jo.put("exp", sdf.format(exp));
			jo.put("number", number);
			jo.put("price", price);
			jo.put("purchaseId", purchaseId);
			jo.put("medicineName", medicineName);
			jo.put("costPrice", costPrice);
			if(exp.getTime()<new Date().getTime()){
				jo.put("status", "已过期");
			}
			else if(price>0){
				jo.put("status", "已上架");
			}
			else{
				jo.put("status", "未上架");
			}
			ja.add(jo);
		}
		return ja.toJSONString();
	}

}
