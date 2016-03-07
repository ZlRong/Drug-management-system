package cn.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 药品库存表
 * @author Zrong
 *
 */
public class MedicineStorehouse implements Serializable{

	private Long id;
	/**
	 * 药品信息id
	 */
	private String medicineId;
	/**
	 * 生产日期
	 */
	private String mfg;
	/**
	 * 保质期
	 */
	private Date exp;
	/**
	 * 库存
	 */
	private int number;
	/**
	 * 售价
	 */
	private double price;
	/**
	 * 采购id
	 */
	private Long purchaseId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(String medicineId) {
		this.medicineId = medicineId;
	}
	public String getMfg() {
		return mfg;
	}
	public void setMfg(String mfg) {
		this.mfg = mfg;
	}
	public Date getExp() {
		return exp;
	}
	public void setExp(Date exp) {
		this.exp = exp;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Long getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}
	
	
}
