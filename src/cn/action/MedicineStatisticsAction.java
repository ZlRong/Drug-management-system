package cn.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("MedicineStatisticsAction")
@Scope("prototype")
public class MedicineStatisticsAction extends ActionSupport {
	
	private static final long serialVersionUID = 7197632120603898587L;
	
	private Date date=new Date();
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String query(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(date);
		ActionContext.getContext().put("dateStr", dateStr);
		return "query";
	}
}
