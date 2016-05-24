package cn.service.impl;

import java.math.BigInteger;
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
import cn.dao.MedicinePurchaseDao;
import cn.service.MedicinePurchaseService;
import cn.util.MathUtil;
import cn.util.PageResult;

@Repository("MedicinePurchaseServiceImpl")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class MedicinePurchaseServiceImpl implements MedicinePurchaseService {

	@Resource(name = "MedicinePurchaseDao")
	private MedicinePurchaseDao dao;
		
	public MedicinePurchaseDao getDao() {
		return dao;
	}

	public void setDao(MedicinePurchaseDao dao) {
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
	public List<MedicinePurchase> query(MedicinePurchase vo,PageResult page) {
		List<Object> objList= dao.query(vo,page);
		List<MedicinePurchase> list = new ArrayList<MedicinePurchase>();
		MedicinePurchase m = null;
//		for(Object obj:objList){
//			m = new MedicinePurchase();
//			Object[] o = (Object[])obj;
//			Long id = MathUtil.valueToLong(o[0]);
//			Long medicineId = MathUtil.valueToLong(o[1]);
//			String medicineName = (String)o[2];
//			Date mfg = (Date)o[3];
//			Date exp = (Date)o[4];
//			int number = (int)o[5];
//			double price = (double)o[6];
//			Long purchaseId = MathUtil.valueToLong(o[7]);
//			m.setId(id);
//			m.setMedicineId(medicineId);
//			m.setMfg(mfg);
//			m.setExp(exp);
//			m.setNumber(number);
//			m.setPrice(price);
//			m.setPurchaseId(purchaseId);
//			m.setMedicineName(medicineName);
//			list.add(m);
//		}
		return list;
	}

	@Override
	public MedicinePurchase queryById(MedicinePurchase info) {
		return dao.queryById(info);
	}

	@Override
	public List<MedicinePurchase> queryInfo(MedicinePurchase vo, PageResult page) {
		List<Object> objList= dao.query(vo,page);
		List<MedicinePurchase> list = new ArrayList<MedicinePurchase>();
		MedicinePurchase m = null;
		for(Object obj:objList){
			m = new MedicinePurchase();
			Object[] o = (Object[])obj;
			String batchNumber = (String)o[0];
			Date purchaseDate = (Date)o[1];
			String name = (String)o[2];
			m.setBatchNumber(batchNumber);
			m.setPurchaseDate(purchaseDate);
			m.setName(name);
			list.add(m);
		}
		return list;
	}

	@Override
	public List<MedicinePurchase> queryByBatchNumber(MedicinePurchase vo, PageResult page) {
		List<Object> objList = dao.queryByBatchNumber(vo, page);
		List<MedicinePurchase> list = new ArrayList<MedicinePurchase>();
		MedicinePurchase m = null;
		for(Object obj:objList){
			m = new MedicinePurchase();
			Object[] o = (Object[])obj;
			String licenseNumber = (String)o[0];
			String medicineName = (String)o[1];
			double costPrice = (double)o[2];
			int number = (int)o[3];
			m.setLicenseNumber(licenseNumber);
			m.setMedicineName(medicineName);
			m.setCostPrice(costPrice);
			m.setNumber(number);
			list.add(m);
		}
		return list;
	}

	@Override
	public String JSONQuery(MedicinePurchase vo, PageResult page) {
		List<Object> objList= dao.query(vo,page);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		JSONArray ja = new JSONArray();
		JSONObject jo = null;
		for(Object obj:objList){
			jo = new JSONObject();
			Object[] o = (Object[])obj;
			String batchNumber = (String)o[0];
			Date purchaseDate = (Date)o[1];
			String name = (String)o[2];
			jo.put("batchNumber", batchNumber);
			jo.put("purchaseDate", sdf.format(purchaseDate));
			jo.put("name", name);
			ja.add(jo);
		}
		return ja.toJSONString();
	}

}
