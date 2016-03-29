package cn.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.bean.MedicinePurchase;
import cn.service.MedicinePurchaseService;
import cn.util.Constants;
import cn.util.PageResult;

@Controller("MedicinePurchaseAction")
@Scope("prototype")
public class MedicinePurchaseAction extends ActionSupport {
	
	@Resource(name = "MedicinePurchaseServiceImpl")
	private MedicinePurchaseService service;
	private MedicinePurchase vo = new MedicinePurchase();
	private PageResult page = new PageResult();
	private List<MedicinePurchase> list;
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
}
