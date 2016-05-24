package cn.action;

import java.awt.Font;
import java.util.Date;

import javax.annotation.Resource;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.service.MedicineStatisticsService;

@Controller("BarChartAction")
@Scope("prototype")
public class BarChartAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3907860944273816402L;

	@Resource(name = "MedicineStatisticsServiceImpl")
	private MedicineStatisticsService service;

	private JFreeChart chart;
	
	private Date date = new Date();
	
	public JFreeChart getChart() {
		return chart;
	}

	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}
	
	public MedicineStatisticsService getService() {
		return service;
	}

	public void setService(MedicineStatisticsService service) {
		this.service = service;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String barChart(){
//		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		 double[][] data = new double[][] 
                 { 
                 { 1000, 1100, 1500, 900, 1000, 1010, 2100, 1800, 1000, 1100, 1500, 900 }
                }; 

                String[] rowKeys = { "药品"}; 

        String[] columnKeys = { "1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月" }; 
        CategoryDataset dataset = DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data); 
	     chart = ChartFactory.createBarChart3D("柱状图", "x轴", "y轴", dataset, PlotOrientation.VERTICAL, true, true, false);      
	     //重新设置图标标题，改变字体 
	     chart.setTitle(new TextTitle("药品营利性分析", new Font("黑体", Font.ITALIC , 22))); 
	     setting(chart);
	      
	     return "chart";
	}

	public String queryNumberAllMedicine(){
		DefaultCategoryDataset dataset = service.queryNumberAllMedicine(date);
			 
	    chart = ChartFactory.createBarChart3D("柱状图", "", "销售量", dataset, PlotOrientation.VERTICAL, true, true, false);      
	     //重新设置图标标题，改变字体 
	    chart.setTitle(new TextTitle("药品销售量分析", new Font("黑体", Font.ITALIC , 22))); 
	    setting(chart);
	    return "chart";
	}
	
	public String queryNumberAllMedicineYear(){
		DefaultCategoryDataset dataset = service.queryNumberAllMedicineYear(date);
			 
	    chart = ChartFactory.createBarChart3D("柱状图", "", "销售量", dataset, PlotOrientation.VERTICAL, true, true, false);      
	     //重新设置图标标题，改变字体 
	    chart.setTitle(new TextTitle("药品销售量分析", new Font("黑体", Font.ITALIC , 22))); 
	    setting(chart);
	    return "chart";
	}
	
	public String querySalesAllMedicine(){
		DefaultCategoryDataset dataset = service.querySalesAllMedicine(date);
			 
	    chart = ChartFactory.createBarChart3D("柱状图", "", "销售额", dataset, PlotOrientation.VERTICAL, true, true, false);      
	     //重新设置图标标题，改变字体 
	    chart.setTitle(new TextTitle("药品销售额分析", new Font("黑体", Font.ITALIC , 22))); 
	    setting(chart);
	    return "chart";
	}
	
	public String querySalesAllMedicineYear(){
		DefaultCategoryDataset dataset = service.querySalesAllMedicineYear(date);
			 
	    chart = ChartFactory.createBarChart3D("柱状图", "", "销售额", dataset, PlotOrientation.VERTICAL, true, true, false);      
	     //重新设置图标标题，改变字体 
	    chart.setTitle(new TextTitle("药品销售额分析", new Font("黑体", Font.ITALIC , 22))); 
	    setting(chart);
	    return "chart";
	}
	
	public String queryPA(){
		DefaultCategoryDataset dataset = service.queryPA(date);
			 
	    chart = ChartFactory.createBarChart3D("柱状图", "月份", "利润", dataset, PlotOrientation.VERTICAL, true, true, false);      
	     //重新设置图标标题，改变字体 
	    chart.setTitle(new TextTitle("药品盈利性分析", new Font("黑体", Font.ITALIC , 22))); 
	    setting(chart);
	    return "chart";
	}
	
	

	
	private void setting(JFreeChart c){
		CategoryPlot plot = (CategoryPlot)c.getPlot(); 
	     //取得横轴 
	     CategoryAxis categoryAxis = plot.getDomainAxis(); 
	     //设置横轴显示标签的字体 
	     categoryAxis.setLabelFont(new Font("宋体" , Font.BOLD , 18)); 
	     //分类标签以45度角倾斜 
	     categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); 
	     categoryAxis.setTickLabelFont(new Font("宋体" , Font.ITALIC , 15));

	     CategoryAxis domainAxis = plot.getDomainAxis();
	     //设置距离图片左端距离
	     domainAxis.setLowerMargin(0.1);
	     //设置距离图片右端距离
	     domainAxis.setUpperMargin(0.1);
	     
	    BarRenderer3D renderer = new BarRenderer3D();
	     renderer.setItemMargin(0.1);//组内柱子间隔为组宽的10%  
	     renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());//显示柱子上的数值
	     renderer.setBaseItemLabelsVisible(true);
	     plot.setRenderer(renderer);//使用我们设计的效果
	     
	     //取得纵轴 
	     NumberAxis numberAxis = (NumberAxis)plot.getRangeAxis(); 
	     //设置纵轴显示标签的字体 
	     numberAxis.setLabelFont(new Font("宋体" , Font.BOLD , 18));

	  // 设置最高的一个   Item   与图片顶端的距离   
	     numberAxis.setUpperMargin(0.15);   
//	     // 设置最低的一个   Item   与图片底端的距离   
//	     numberAxis.setLowerMargin(0.15);   
	     plot.setRangeAxis(numberAxis);  

	        Font font00 = new Font("宋体",Font.BOLD,18); 
	  LegendTitle legend = c.getLegend(); 
	  legend.setItemFont(font00);//设置注释字体
	}


}
