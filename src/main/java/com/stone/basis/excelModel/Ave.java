package com.kpap.basis.excelModel;

import java.math.BigDecimal;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * IQ_16_可比公司会计报表-利润表_分类统计     第几年平均
 * @author huo
 *
 */
public class Ave {
	//当年
	public Double ave;
	//前两年平均
	public Double ave2;
	//前三年平均
	public Double ave3;
	//前四年平均
	public Double ave4;
	//前五年平均
	public Double ave5;
	
	public Double getAve() {
		return ave;
	}
	public void setAve(Double ave) {
		this.ave = ave;
	}
	public Double getAve2() {
		return ave2;
	}
	public void setAve2(Double ave2) {
		this.ave2 = ave2;
	}
	public Double getAve3() {
		return ave3;
	}
	public void setAve3(Double ave3) {
		this.ave3 = ave3;
	}
	public Double getAve4() {
		return ave4;
	}
	public void setAve4(Double ave4) {
		this.ave4 = ave4;
	}
	public Double getAve5() {
		return ave5;
	}
	public void setAve5(Double ave5) {
		this.ave5 = ave5;
	}
	@JSONField(serialize = false)
	public Double getAveFormat() {
		BigDecimal bigDecimal=BigDecimal.valueOf(ave*100);
		return bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	@JSONField(serialize = false)
	public Double getAve2Format() {
		BigDecimal bigDecimal=BigDecimal.valueOf(ave2*100);
		return bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	@JSONField(serialize = false)
	public Double getAve3Format() {
		BigDecimal bigDecimal=BigDecimal.valueOf(ave3*100);
		return bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	@JSONField(serialize = false)
	public Double getAve4Format() {
		BigDecimal bigDecimal=BigDecimal.valueOf(ave4*100);
		return bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}	
	@JSONField(serialize = false)
	public Double getAve5Format() {
		BigDecimal bigDecimal=BigDecimal.valueOf(ave5*100);
		return bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
