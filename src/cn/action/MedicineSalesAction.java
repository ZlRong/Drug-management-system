package cn.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.bean.MedicineSales;
import cn.bean.MedicineStorehouse;
import cn.service.MedicineSalesService;
import cn.service.MedicineStorehouseService;
import cn.util.Constants;
import cn.util.PageResult;

@Controller("MedicineSalesAction")
@Scope("prototype")
public class MedicineSalesAction extends ActionSupport {
	
	@Resource(name = "MedicineSalesServiceImpl")
	private MedicineSalesService service;
	@Resource(name = "MedicineStorehouseServiceImpl")
	private MedicineStorehouseService storehouseService;

	private MedicineSales vo = new MedicineSales();
	private PageResult page = new PageResult();
	private List<MedicineSales> list;
	
	private Long[] medicineStoreHouseId;
	private int[] saleNumber;
	
	public MedicineStorehouseService getStorehouseService() {
		return storehouseService;
	}

	public void setStorehouseService(MedicineStorehouseService storehouseService) {
		this.storehouseService = storehouseService;
	}

	public MedicineSales getVo() {
		return vo;
	}

	public void setVo(MedicineSales vo) {
		this.vo = vo;
	}

	public PageResult getPage() {
		return page;
	}

	public void setPage(PageResult page) {
		this.page = page;
	}

	public List<MedicineSales> getList() {
		return list;
	}

	public void setList(List<MedicineSales> list) {
		this.list = list;
	}

	@JSON(serialize=false)
	public MedicineSalesService getService() {
		return service;
	}

	public void setService(MedicineSalesService service) {
		this.service = service;
	}
	
	public Long[] getMedicineStoreHouseId() {
		return medicineStoreHouseId;
	}

	public void setMedicineStoreHouseId(Long[] medicineStoreHouseId) {
		this.medicineStoreHouseId = medicineStoreHouseId;
	}

	public int[] getSaleNumber() {
		return saleNumber;
	}

	public void setSaleNumber(int[] saleNumber) {
		this.saleNumber = saleNumber;
	}

	public String toAdd(){
		return "add";
	}
	
	public String add(){
		boolean isFlag = false;
		try {
			isFlag = service.sale(medicineStoreHouseId, saleNumber);
		} catch (Exception e) {
			isFlag = false;
		}
		if(isFlag){
			ActionContext.getContext().put(Constants.MSG, "销售成功");
		}
		else{
			ActionContext.getContext().put(Constants.MSG, "销售失败");
		}
		return query();
	}
	
	public String query(){
		List<MedicineSales> list = service.queryInfo(vo,page);
		ActionContext.getContext().put(Constants.QUERY, list);
		return "query";
	}
	
	public String detail(){
		List<MedicineSales> list = service.queryByBatchNumber(vo, page);
		ActionContext.getContext().put("saleBatchNumber", vo.getSaleBatchNumber());
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
