package com.kpap.basis.excelModel;

import java.util.List;

public class ComProductInfo {
	public List<Product> products;
	public List<ProductAve> productAves;
	
	//专利使用后数据(企业当前) --销售收入增长率
	public Ave r31_ave;
	//专利使用后数据(企业当前) --销售量增长率
	public Ave r29_ave;
	//专利使用后数据(企业当前) --销售单价增长率
	public Ave r30_ave;
	//专利使用前数据--销售单价增长率
	public Ave r21_ave;
	//专利使用前数据--销售量增长率
	public Ave r20_ave;
	//专利使用前数据--单位成本
	public Ave r24_ave;
	//专利使用前数据--单位成本
	public Ave r33_ave;
	
	
	public Ave getR24_ave() {
		return r24_ave;
	}
	public void setR24_ave(Ave r24_ave) {
		this.r24_ave = r24_ave;
	}
	public Ave getR33_ave() {
		return r33_ave;
	}
	public void setR33_ave(Ave r33_ave) {
		this.r33_ave = r33_ave;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public List<ProductAve> getProductAves() {
		return productAves;
	}
	public void setProductAves(List<ProductAve> productAves) {
		this.productAves = productAves;
	}
	public Ave getR31_ave() {
		return r31_ave;
	}
	public void setR31_ave(Ave r31_ave) {
		this.r31_ave = r31_ave;
	}
	public Ave getR29_ave() {
		return r29_ave;
	}
	public void setR29_ave(Ave r29_ave) {
		this.r29_ave = r29_ave;
	}
	public Ave getR30_ave() {
		return r30_ave;
	}
	public void setR30_ave(Ave r30_ave) {
		this.r30_ave = r30_ave;
	}
	public Ave getR21_ave() {
		return r21_ave;
	}
	public void setR21_ave(Ave r21_ave) {
		this.r21_ave = r21_ave;
	}
	public Ave getR20_ave() {
		return r20_ave;
	}
	public void setR20_ave(Ave r20_ave) {
		this.r20_ave = r20_ave;
	}
}
