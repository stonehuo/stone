package com.kpap.website.dto;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class IncomeShareRate {
	public Long proValId;
	public String category;
	
	//法律因素得分--法律状态
	public Double sr_0;
	//法律因素得分--保护范围
	public Double sr_1;
	//法律因素得分--侵权判定
	public Double sr_2;
	
	//技术因素得分--技术所属领域
	public Double sr_3;
	//技术因素得分--替代技术
	public Double sr_4;
	//技术因素得分--先进性
	public Double sr_5;
	//技术因素得分--创新性
	public Double sr_6;
	//技术因素得分--成熟度
	public Double sr_7;
	//技术因素得分--应用范围
	public Double sr_8;
	//技术因素得分--技术防御力
	public Double sr_9;
	
	//经济因素得分
	public Double sr_10;
	
	//分成系数上下限 类型  0--行业数据；1--人工录入
	public String shareRatioType;
	//分成系数上下限  行业数据
	public String shareRatioIndustry;
	//分成系数上下限  人工录入  下限
	public Double shareRatioDown;
	//分成系数上下限  人工录入   上限
	public Double shareRatioUp;
	
	//初始分成率类型  0--公式计算  1--人工录入
	public String initScoreType;
	//方法类型：0--区间法；1--三分法；2--四分法
	public Double methodType;
	
	//初始分成率
	public Double initScore;
	//分成率递减率
	public String scoreDJ;
	//分成率结果
	public String scoreResult;

	public Double getSr_0() {
		return sr_0;
	}

	public void setSr_0(Double sr_0) {
		this.sr_0 = sr_0;
	}

	public Double getSr_1() {
		return sr_1;
	}

	public void setSr_1(Double sr_1) {
		this.sr_1 = sr_1;
	}

	public Double getSr_2() {
		return sr_2;
	}

	public void setSr_2(Double sr_2) {
		this.sr_2 = sr_2;
	}

	public Double getSr_3() {
		return sr_3;
	}

	public void setSr_3(Double sr_3) {
		this.sr_3 = sr_3;
	}

	public Double getSr_4() {
		return sr_4;
	}

	public void setSr_4(Double sr_4) {
		this.sr_4 = sr_4;
	}

	public Double getSr_5() {
		return sr_5;
	}

	public void setSr_5(Double sr_5) {
		this.sr_5 = sr_5;
	}

	public Double getSr_6() {
		return sr_6;
	}

	public void setSr_6(Double sr_6) {
		this.sr_6 = sr_6;
	}

	public Double getSr_7() {
		return sr_7;
	}

	public void setSr_7(Double sr_7) {
		this.sr_7 = sr_7;
	}

	public Double getSr_8() {
		return sr_8;
	}

	public void setSr_8(Double sr_8) {
		this.sr_8 = sr_8;
	}

	public Double getSr_9() {
		return sr_9;
	}

	public void setSr_9(Double sr_9) {
		this.sr_9 = sr_9;
	}

	public Double getSr_10() {
		return sr_10;
	}

	public void setSr_10(Double sr_10) {
		this.sr_10 = sr_10;
	}

	public String getShareRatioType() {
		return shareRatioType;
	}

	public void setShareRatioType(String shareRatioType) {
		this.shareRatioType = shareRatioType;
	}

	public String getShareRatioIndustry() {
		return shareRatioIndustry;
	}

	public void setShareRatioIndustry(String shareRatioIndustry) {
		this.shareRatioIndustry = shareRatioIndustry;
	}

	public Double getShareRatioDown() {
		return shareRatioDown;
	}

	public void setShareRatioDown(Double shareRatioDown) {
		this.shareRatioDown = shareRatioDown;
	}

	public Double getShareRatioUp() {
		return shareRatioUp;
	}

	public void setShareRatioUp(Double shareRatioUp) {
		this.shareRatioUp = shareRatioUp;
	}

	public Double getInitScore() {
		return initScore;
	}

	public void setInitScore(Double initScore) {
		this.initScore = initScore;
	}

	public String getScoreDJ() {
		return scoreDJ;
	}

	public void setScoreDJ(String scoreDJ) {
		this.scoreDJ = scoreDJ;
	}

	public Long getProValId() {
		return proValId;
	}

	public void setProValId(Long proValId) {
		this.proValId = proValId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getScoreResult() {
		return scoreResult;
	}

	public void setScoreResult(String scoreResult) {
		this.scoreResult = scoreResult;
	}

	public String getInitScoreType() {
		return initScoreType;
	}

	public void setInitScoreType(String initScoreType) {
		this.initScoreType = initScoreType;
	}

	public Double getMethodType() {
		return methodType;
	}

	public void setMethodType(Double methodType) {
		this.methodType = methodType;
	}
	@JsonIgnore
	@JSONField(serialize = false)
	public List<KeyValue> getScoreDJList(){
		return KeyValue.getKeyValueList(scoreDJ);
	}
}
