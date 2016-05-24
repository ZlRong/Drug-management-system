package cn.bean;

import java.io.Serializable;
import java.util.Date;

public class MedicineSales implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3016701986155265462L;
	private Long id;
	/**
	 * 库存id
	 */
	private Long medicineStoreHouseId;
	/**
	 * 销售单价
	 */
	private double salePrice;
	/**
	 * 数量
	 */
	private int saleNumber;
	/**
	 * 销售日期
	 */
	private Date saleDate;
	/**
	 * 销售批号
	 */
	private String saleBatchNumber;
	/**
	 * 用户id
	 */
	private Long userId;
	
	private String name;	//用户名
	private String licenseNumber;
	private String medicineName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMedicineStoreHouseId() {
		return medicineStoreHouseId;
	}
	public void setMedicineStoreHouseId(Long medicineStoreHouseId) {
		this.medicineStoreHouseId = medicineStoreHouseId;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public int getSaleNumber() {
		return saleNumber;
	}
	public void setSaleNumber(int saleNumber) {
		this.saleNumber = saleNumber;
	}
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	public String getSaleBatchNumber() {
		return saleBatchNumber;
	}
	public void setSaleBatchNumber(String saleBatchNumber) {
		this.saleBatchNumber = saleBatchNumber;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	
}
