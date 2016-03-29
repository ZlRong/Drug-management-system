package cn.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

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
		List<MedicineStorehouse> list = service.query(vo,page);
		ActionContext.getContext().put(Constants.QUERY, list);
		return "query";
	}
	
	public String detail(){
		MedicineStorehouse medicineStorehouse = service.queryById(vo);
		ActionContext.getContext().put(Constants.DETAIL, medicineStorehouse);
		return "detail";
	}
}
