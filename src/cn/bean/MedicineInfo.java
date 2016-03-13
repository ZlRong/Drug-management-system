package cn.bean;

import java.io.Serializable;

/**
 * 药品基本信息表
 * @author Zrong
 *
 */
public class MedicineInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6822105731905619631L;
	private Long id;
	/**
	 * 批准文号
	 */
	private String licenseNumber;
	/**
	 * 产品名称
	 */
	private String medicineName;
	/**
	 * 英文名称
	 */
	private String medicineENName;
	/**
	 * 商品名
	 */
	private String productName;
	/**
	 * 剂型
	 */
	private String dosageForm;
	/**
	 * 规格
	 */
	private String spec;
	/**
	 * 生产单位
	 */
	private String productionUnit;
	/**
	 * 生产地址
	 */
	private String productionAddress;
	/**
	 *产品类别
	 */
	private String medicineType;
	/**
	 * 原批准文号
	 */
	private String originalLicenseNumber;
	/**
	 * 批准日期
	 */
	private String licenseDate;
	/**
	 * 药品本位码
	 */
	private String drugStandardCode;
	/**
	 * 药品本位码备注
	 */
	private String drugStandardCodeRemark;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getMedicineENName() {
		return medicineENName;
	}
	public void setMedicineENName(String medicineENName) {
		this.medicineENName = medicineENName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDosageForm() {
		return dosageForm;
	}
	public void setDosageForm(String dosageForm) {
		this.dosageForm = dosageForm;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getProductionUnit() {
		return productionUnit;
	}
	public void setProductionUnit(String productionUnit) {
		this.productionUnit = productionUnit;
	}
	public String getProductionAddress() {
		return productionAddress;
	}
	public void setProductionAddress(String productionAddress) {
		this.productionAddress = productionAddress;
	}
	public String getMedicineType() {
		return medicineType;
	}
	public void setMedicineType(String medicineType) {
		this.medicineType = medicineType;
	}
	public String getOriginalLicenseNumber() {
		return originalLicenseNumber;
	}
	public void setOriginalLicenseNumber(String originalLicenseNumber) {
		this.originalLicenseNumber = originalLicenseNumber;
	}
	public String getLicenseDate() {
		return licenseDate;
	}
	public void setLicenseDate(String licenseDate) {
		this.licenseDate = licenseDate;
	}
	public String getDrugStandardCode() {
		return drugStandardCode;
	}
	public void setDrugStandardCode(String drugStandardCode) {
		this.drugStandardCode = drugStandardCode;
	}
	public String getDrugStandardCodeRemark() {
		return drugStandardCodeRemark;
	}
	public void setDrugStandardCodeRemark(String drugStandardCodeRemark) {
		this.drugStandardCodeRemark = drugStandardCodeRemark;
	}
}
