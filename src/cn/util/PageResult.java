package cn.util;

public class PageResult {
	
	private int items;			//总记录数
	private int itemsOnPage = 20;	//每页记录数
	private int currentPage = 1;	//当前页
	
	public int getItems() {
		return items;
	}
	public void setItems(int items) {
		this.items = items;
	}
	public int getItemsOnPage() {
		return itemsOnPage;
	}
	public void setItemsOnPage(int itemsOnPage) {
		this.itemsOnPage = itemsOnPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getFirstResult(){
		int ret = (this.getCurrentPage()-1)*this.getItemsOnPage();
		ret = (ret < 1)?0:ret;
		return ret;
	}
	
	public int getMaxResult(){
		int ret=this.getItems()-this.getFirstResult();
		ret = (ret < this.getItemsOnPage())?ret:this.getItemsOnPage();
		return ret;
	}
}
