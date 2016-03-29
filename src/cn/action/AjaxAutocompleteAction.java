package cn.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.bean.MedicineInfo;
import cn.service.MedicineInfoService;

@Controller("AjaxAutocompleteAction")
@Scope("prototype")
public class AjaxAutocompleteAction extends ActionSupport{

	@Resource(name = "MedicineInfoServiceImpl")
	private MedicineInfoService service;

	private String search;
	private List<MedicineInfo> list;
	
	@JSON(serialize=false)
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
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
	
	public String ajaxQuery(){
		list = service.queryFuzzy(search);
		return "medicineinfo";
	}
}
