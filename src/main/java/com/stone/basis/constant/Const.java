package com.kpap.basis.constant;

/**
 * 系统常量定义
 * 
 * @author haiwenshen
 *
 */
public class Const {
	
	/**
	 * 专利汇总类型常量
	 * 
	 * @author haiwenshen
	 *
	 */
	public enum PatentSumCost{
		
		SUM("0","合计"),AVG("1","平均数u"),VAR("2","方差σ2"),STA("3","标准差σ"),TAKE("4","取分"),SCORE("5","得分");
		
		
		private String value;
		
		private String desc;
		
		PatentSumCost(String value,String desc){
			this.value = value;
			this.desc = desc;
		}
		
		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}
	}
	
	/**
	 * 专利评分等级常量
	 * 
	 * @author haiwenshen
	 *
	 */
	public enum PatentAvgGradeCost{
		LESSAVGSUB3("<u-3σ"),EQAVGSUB3("u-3σ"),EQAVGSUB2("<u-2σ"),EQAVGSUB1("<u-σ"),EQAVG("u"),EQAVGADD1("u+σ"),
		EQAVGADD2("<u+2σ"),EQAVGADD3("u+3σ"),MOREAVGADD2(">u+3σ");
		
		private String desc;
		
		PatentAvgGradeCost(String desc){
			desc = this.desc;
		}
		
		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}
		
	}
	
	/**
	 * 专利汇总类型常量
	 * 
	 * @author haiwenshen
	 *
	 */
	public enum InComeYearNameCost{
		
		FY_5("FY-5","前5年"),FY_4("FY-4","前4年"),FY_3("FY-3","前3年"),FY_2("FY-2","前2年"),FY_1("FY-1","前1年"),CurrentFY("Current FY","当年");
		
		
		private String value;
		
		private String desc;
		
		InComeYearNameCost(String value,String desc){
			this.value = value;
			this.desc = desc;
		}
		
		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}
		
		@Override
		public String toString(){
			return value;
		}
		
		public static InComeYearNameCost valueOf_1(String value){
			if(FY_5.getValue().equals(value)){
				return InComeYearNameCost.FY_5;
			}
			if(FY_4.getValue().equals(value)){
				return InComeYearNameCost.FY_4;
			}
			if(FY_3.getValue().equals(value)){
				return InComeYearNameCost.FY_3;
			}
			if(FY_2.getValue().equals(value)){
				return InComeYearNameCost.FY_2;
			}
			return InComeYearNameCost.CurrentFY;
		}
	}
	


}
