package cn.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import cn.bean.UserLogin;
import cn.util.Constants;

public class MedicineInfoInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		Object obj = ActionContext.getContext().getSession().get(Constants.USER);
		if(obj==null){
			return "login";
		}
		else {
			UserLogin user = (UserLogin)obj;
			if(user.getJob().equals("系统管理员")||user.getJob().equals("药品库存管理员")){
				return arg0.invoke();
			}
			else {
				return "nopermission";
			}
		}
	}

}
