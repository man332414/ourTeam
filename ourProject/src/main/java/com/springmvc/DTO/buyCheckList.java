package com.springmvc.DTO;

import org.springframework.web.multipart.MultipartFile;

public class buyCheckList
{
	private int num;
	private String useCategory;
	private String gradeCategory;
	private String productName;
	private int productPrice;
	private int quantity;
	private String acquisitionPath;
	private String acquisitionMethod;
	private String fileName;    //파일이름
	private MultipartFile listImage; //사진이미지

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUseCategory() {
		return useCategory;
	}
	public void setUseCategory(String useCategory) {
		this.useCategory = useCategory;
	}
	public String getGradeCategory() {
		return gradeCategory;
	}
	public void setGradeCategory(String gradeCategory) {
		this.gradeCategory = gradeCategory;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getAcquisitionPath() {
		return acquisitionPath;
	}
	public void setAcquisitionPath(String acquisitionPath) {
		this.acquisitionPath = acquisitionPath;
	}
	public String getAcquisitionMethod() {
		return acquisitionMethod;
	}
	public void setAcquisitionMethod(String acquisitionMethod) {
		this.acquisitionMethod = acquisitionMethod;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public MultipartFile getListImage() {
		return listImage;
	}
	public void setListImage(MultipartFile listImage) {
		this.listImage = listImage;
	}
	
	
}
