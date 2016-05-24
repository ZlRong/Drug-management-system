package cn.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.bean.MedicineInfo;
import cn.bean.MedicinePurchase;
import cn.bean.MedicineStorehouse;
import cn.bean.UserInfo;
import cn.service.MedicineInfoService;
import cn.service.MedicinePurchaseService;
import cn.service.MedicineStorehouseService;
import cn.util.Constants;
import cn.util.PageResult;

@Controller("MedicinePurchaseAction")
@Scope("prototype")
public class MedicinePurchaseAction extends ActionSupport {
	
	@Resource(name = "MedicinePurchaseServiceImpl")
	private MedicinePurchaseService service;
	@Resource(name = "MedicineInfoServiceImpl")
	private MedicineInfoService medicineInfoService;
	@Resource(name = "MedicineStorehouseServiceImpl")
	private MedicineStorehouseService MedicineStorehouseService;
	
	private MedicinePurchase vo = new MedicinePurchase();
	private PageResult page = new PageResult();
	private List<MedicinePurchase> list;
	private String[] drugStandardCode;
	private double[] costPrice;
	private int[] number;
	private String[] mfg;
	private String[] exp;
	
	public MedicineStorehouseService getMedicineStorehouseService() {
		return MedicineStorehouseService;
	}

	public void setMedicineStorehouseService(MedicineStorehouseService medicineStorehouseService) {
		MedicineStorehouseService = medicineStorehouseService;
	}

	public MedicineInfoService getMedicineInfoService() {
		return medicineInfoService;
	}

	public void setMedicineInfoService(MedicineInfoService medicineInfoService) {
		this.medicineInfoService = medicineInfoService;
	}

	public MedicinePurchase getVo() {
		return vo;
	}

	public void setVo(MedicinePurchase vo) {
		this.vo = vo;
	}

	public PageResult getPage() {
		return page;
	}

	public void setPage(PageResult page) {
		this.page = page;
	}

	public List<MedicinePurchase> getList() {
		return list;
	}

	public void setList(List<MedicinePurchase> list) {
		this.list = list;
	}

	public String[] getDrugStandardCode() {
		return drugStandardCode;
	}

	public void setDrugStandardCode(String[] drugStandardCode) {
		this.drugStandardCode = drugStandardCode;
	}

	public double[] getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double[] costPrice) {
		this.costPrice = costPrice;
	}

	public int[] getNumber() {
		return number;
	}

	public void setNumber(int[] number) {
		this.number = number;
	}

	public String[] getMfg() {
		return mfg;
	}

	public void setMfg(String[] mfg) {
		this.mfg = mfg;
	}

	public String[] getExp() {
		return exp;
	}

	public void setExp(String[] exp) {
		this.exp = exp;
	}

	@JSON(serialize=false)
	public MedicinePurchaseService getService() {
		return service;
	}

	public void setService(MedicinePurchaseService service) {
		this.service = service;
	}

	public String toAdd(){
		return "add";
	}
	
	public String add(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		MedicinePurchase purchaseObj = null;
		MedicineStorehouse storehouseObj = null;
		Date purchaseDate = new Date(); 
		String batchNumber = sdf.format(purchaseDate);
		UserInfo user = (UserInfo)ActionContext.getContext().getSession().get("userinfo");
		Long userId = user.getId(); 
		for(int i=0;i<drugStandardCode.length;i++){
			purchaseObj = new MedicinePurchase();
			storehouseObj = new MedicineStorehouse();
			List<MedicineInfo> list = medicineInfoService.queryByDrugStandardCode(drugStandardCode[i]);
			if(list.size()>0){
				MedicineInfo medicine = list.get(0);
				purchaseObj.setMedicineId(medicine.getId());
				storehouseObj.setMedicineId(medicine.getId());
			}
			purchaseObj.setCostPrice(costPrice[i]);
			purchaseObj.setNumber(number[i]);
			purchaseObj.setPurchaseDate(purchaseDate);
			purchaseObj.setBatchNumber(batchNumber);
			purchaseObj.setUserId(userId);
			
			service.add(purchaseObj);
			
			try {
				storehouseObj.setMfg(sdf2.parse(mfg[i]));
				storehouseObj.setExp(sdf2.parse(exp[i]));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			storehouseObj.setNumber(number[i]);
			storehouseObj.setPrice(0);
			storehouseObj.setPurchaseId(purchaseObj.getId());
			MedicineStorehouseService.add(storehouseObj);
		}
		return query();
	}
	
	public String query(){
		List<MedicinePurchase> list = service.queryInfo(vo,page);
		ActionContext.getContext().put(Constants.QUERY, list);
		return "query";
	}
	
	public String detail(){
		List<MedicinePurchase> list = service.queryByBatchNumber(vo, page);
		ActionContext.getContext().put("batchNumber", vo.getBatchNumber());
		ActionContext.getContext().put(Constants.QUERY, list);
		return "detail";
	}
	
	public void JSONQuery(){
		String list = service.JSONQuery(vo, page);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		try {
			PrintWriter  out = response.getWriter();
			out.write(list);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
