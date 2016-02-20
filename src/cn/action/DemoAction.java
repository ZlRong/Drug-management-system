package cn.action;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
@Component("demo")
public class DemoAction extends ActionSupport {
@Override
public String execute() throws Exception {
	System.out.println("hello~");
	return super.execute();
}
}
