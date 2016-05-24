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

import cn.bean.MedicinePurchase;
import cn.bean.MedicineStorehouse;
import cn.service.MedicineStorehouseService;
import cn.util.Constants;
import cn.util.PageResult;

@Controller("MedicineStorehouseAction")
@Scope("prototype")
public class MedicineStorehouseAction extends ActionSupport {
	
	@Resource(name = "MedicineStorehouseServiceImpl")
	private MedicineStorehouseService service;
	private MedicineStorehouse vo = new MedicineStorehouse();
	private PageResult page = new PageResult();
	private List<MedicineStorehouse> list;
	private double price;
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public MedicineStorehouse getVo() {
		return vo;
	}

	public void setVo(MedicineStorehouse vo) {
		this.vo = vo;
	}

	public PageResult getPage() {
		return page;
	}

	public void setPage(PageResult page) {
		this.page = page;
	}

	public List<MedicineStorehouse> getList() {
		return list;
	}

	public void setList(List<MedicineStorehouse> list) {
		this.list = list;
	}

	@JSON(serialize=false)
	public MedicineStorehouseService getService() {
		return service;
	}

	public void setService(MedicineStorehouseService service) {
		this.service = service;
	}

	public String query(){
		List<MedicineStorehouse> list = service.query(vo, page);
//		List<MedicineStorehouse> listExpired = service.queryExpired(vo, page);
//		List<MedicineStorehouse> listNotExpired = service.queryNotExpired(vo,page);
		ActionContext.getContext().put(Constants.QUERY, list);
//		ActionContext.getContext().put(Constants.EXPIRED, listExpired);
//		ActionContext.getContext().put(Constants.NOTEXPIRED, listNotExpired);
		return "query";
	}
	
	public String detail(){
		MedicineStorehouse medicineStorehouse = service.queryById(vo);
		ActionContext.getContext().put(Constants.DETAIL, medicineStorehouse);
		return "detail";
	}
	
	public String dealWith(){
		boolean isFlag =  service.dealWith(vo);
		if(isFlag){
			ActionContext.getContext().put(Constants.MSG, "处理成功。");			
		}
		else{
			ActionContext.getContext().put(Constants.MSG, "处理失败。");
		}
		return query();
	}
	public String upMedicine(){
		MedicineStorehouse ms = service.queryById(vo);
		ms.setPrice(price);
		service.update(ms);
		ActionContext.getContext().put(Constants.MSG, "上架成功。");
		return query();
	}
	
	public String downMedicine(){
		MedicineStorehouse ms = service.queryById(vo);
		ms.setPrice(0);
		service.update(ms);
		ActionContext.getContext().put(Constants.MSG, "下架成功。");
		return query();
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
