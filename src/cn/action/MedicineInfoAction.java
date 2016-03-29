package cn.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.bean.MedicineInfo;
import cn.service.MedicineInfoService;
import cn.util.Constants;
import cn.util.PageResult;

@Controller("MedicineInfoAction")
@Scope("prototype")
public class MedicineInfoAction extends ActionSupport {
	
	private static final long serialVersionUID = 7197632120603898587L;
	
	@Resource(name = "MedicineInfoServiceImpl")
	private MedicineInfoService service;
	private MedicineInfo vo = new MedicineInfo();
	private PageResult page = new PageResult();
	private List<MedicineInfo> list;
	public MedicineInfo getVo() {
		return vo;
	}

	public void setVo(MedicineInfo vo) {
		this.vo = vo;
	}

	public PageResult getPage() {
		return page;
	}

	public void setPage(PageResult page) {
		this.page = page;
	}

	public List<MedicineInfo> getList() {
		return list;
	}

	public void setList(List<MedicineInfo> list) {
		this.list = list;
	}

	@JSON(serialize=false)
	public MedicineInfoService getService() {
		return service;
	}

	public void setService(MedicineInfoService service) {
		this.service = service;
	}

	public String query(){
		List<MedicineInfo> list = service.query(vo,page);
		ActionContext.getContext().put(Constants.QUERY, list);
		return "index";
	}
	
	public String toAdd(){
		return "add";
	}
	
	public String add(){
		service.add(vo);
		return "index";
	}
	
	public String detail(){
		MedicineInfo medicineInfo = service.queryById(vo);
		ActionContext.getContext().put(Constants.DETAIL, medicineInfo);
		return "detail";
	}
	
	public String ajaxQuery(){
		list = service.query(vo,page);
		return "ajaxquery";
	}
}
