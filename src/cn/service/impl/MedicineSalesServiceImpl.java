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
import com.opensymphony.xwork2.ActionContext;

import cn.bean.MedicineSales;
import cn.bean.MedicineStorehouse;
import cn.bean.UserInfo;
import cn.dao.MedicineSalesDao;
import cn.dao.MedicineStorehouseDao;
import cn.service.MedicineSalesService;
import cn.util.PageResult;

@Repository("MedicineSalesServiceImpl")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class MedicineSalesServiceImpl implements MedicineSalesService {

	@Resource(name = "MedicineSalesDao")
	private MedicineSalesDao dao;
	@Resource(name = "MedicineStorehouseDao")
	private MedicineStorehouseDao storehouseDao;
	
	
		
	public MedicineStorehouseDao getStorehouseDao() {
		return storehouseDao;
	}

	public void setStorehouseDao(MedicineStorehouseDao storehouseDao) {
		this.storehouseDao = storehouseDao;
	}

	public MedicineSalesDao getDao() {
		return dao;
	}

	public void setDao(MedicineSalesDao dao) {
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
	public List<MedicineSales> query(MedicineSales vo,PageResult page) {
		List<Object> objList= dao.query(vo,page);
		List<MedicineSales> list = new ArrayList<MedicineSales>();
		MedicineSales m = null;
//		for(Object obj:objList){
//			m = new MedicineSales();
//			Object[] o = (Object[])obj;
//			Long id = MathUtil.valueToLong(o[0]);
//			Long medicineId = MathUtil.valueToLong(o[1]);
//			String medicineName = (String)o[2];
//			Date mfg = (Date)o[3];
//			Date exp = (Date)o[4];
//			int number = (int)o[5];
//			double price = (double)o[6];
//			Long salesId = MathUtil.valueToLong(o[7]);
//			m.setId(id);
//			m.setMedicineId(medicineId);
//			m.setMfg(mfg);
//			m.setExp(exp);
//			m.setNumber(number);
//			m.setPrice(price);
//			m.setSaleId(salesId);
//			m.setMedicineName(medicineName);
//			list.add(m);
//		}
		return list;
	}

	@Override
	public MedicineSales queryById(MedicineSales info) {
		return dao.queryById(info);
	}

	@Override
	public List<MedicineSales> queryInfo(MedicineSales vo, PageResult page) {
		List<Object> objList= dao.query(vo,page);
		List<MedicineSales> list = new ArrayList<MedicineSales>();
		MedicineSales m = null;
		for(Object obj:objList){
			m = new MedicineSales();
			Object[] o = (Object[])obj;
			String saleBatchNumber = (String)o[0];
			Date saleDate = (Date)o[1];
			String name = (String)o[2];
			m.setSaleBatchNumber(saleBatchNumber);
			m.setSaleDate(saleDate);
			m.setName(name);
			list.add(m);
		}
		return list;
	}

	@Override
	public List<MedicineSales> queryByBatchNumber(MedicineSales vo, PageResult page) {
		List<Object> objList = dao.queryByBatchNumber(vo, page);
		List<MedicineSales> list = new ArrayList<MedicineSales>();
		MedicineSales m = null;
		for(Object obj:objList){
			m = new MedicineSales();
			Object[] o = (Object[])obj;
			String licenseNumber = (String)o[0];
			String medicineName = (String)o[1];
			double salePrice = (double)o[2];
			int saleNumber = (int)o[3];
			m.setLicenseNumber(licenseNumber);
			m.setMedicineName(medicineName);
			m.setSalePrice(salePrice);
			m.setSaleNumber(saleNumber);
			list.add(m);
		}
		return list;
	}

	@Override
	public boolean sale(Long[] medicineStoreHouseId, int[] saleNumber) {
		boolean isFlag = false;
		MedicineSales salesObj = null;
		MedicineStorehouse storehouseObj = null;
		Date saleDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String saleBatchNumber = sdf.format(saleDate);
		UserInfo user = (UserInfo)ActionContext.getContext().getSession().get("userinfo");
		for(int i=0;i<medicineStoreHouseId.length;i++){
			storehouseObj = new MedicineStorehouse();
			salesObj = new MedicineSales();
			storehouseObj.setId(medicineStoreHouseId[i]);
			storehouseObj = storehouseDao.queryById(storehouseObj);
			try{
				if(storehouseObj==null){
					throw new Exception();
				}
				else if(storehouseObj.getPrice()<=0){
					throw new Exception();
				}
				else if(storehouseObj.getNumber()<saleNumber[i]){
						throw new Exception();
				}
			}catch(Exception e){
				throw new RuntimeException();
			}
			storehouseObj.setNumber(storehouseObj.getNumber()-saleNumber[i]);
			storehouseDao.update(storehouseObj);
			
			salesObj.setMedicineStoreHouseId(medicineStoreHouseId[i]);
			salesObj.setSalePrice(storehouseObj.getPrice());
			salesObj.setSaleNumber(saleNumber[i]);
			salesObj.setSaleDate(saleDate);
			salesObj.setSaleBatchNumber(saleBatchNumber);
			salesObj.setUserId(user.getId());
			dao.add(salesObj);
		}
		isFlag=true;
		return isFlag;
	}

	@Override
	public String JSONQuery(MedicineSales vo, PageResult page) {
		List<Object> objList= dao.query(vo,page);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		JSONArray ja = new JSONArray();
		JSONObject jo = null;
		for(Object obj:objList){
			jo = new JSONObject();
			Object[] o = (Object[])obj;
			String saleBatchNumber = (String)o[0];
			Date saleDate = (Date)o[1];
			String name = (String)o[2];
			jo.put("saleBatchNumber", saleBatchNumber);
			jo.put("saleDate", sdf.format(saleDate));
			jo.put("name", name);
			ja.add(jo);
		}
		return ja.toJSONString();
	}

}
