package cn.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 药品采购表
 * @author Zrong
 *
 */
public class MedicinePurchase implements Serializable{

	private Long id;
	/**
	 * 药品id
	 */
	private Long medicineId;
	/**
	 * 单价成本
	 */
	private double costPrice;
	/**
	 * 采购数量
	 */
	private int number;
	/**
	 * 采购日期
	 */
	private Date purchaseDate;
	
	/**
	 * 采购批次
	 */
	private String batchNumber;
	/**
	 * 用户id
	 */
	private String userId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(Long medicineId) {
		this.medicineId = medicineId;
	}
	public double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
