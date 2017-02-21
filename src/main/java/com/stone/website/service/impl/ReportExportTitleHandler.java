package com.kpap.website.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kpap.basis.model.ProVal;
import com.kpap.common.util.XlsCellVo;


/**
 * 
 * 报告导出下载<BR>
 *
 * @auther shenhaiwen
 * @date 2016-12-11 下午10:15:09
 */
@Service 
public class ReportExportTitleHandler {
    /**
     * 可比公司财务统计列标题
     * 
     * @param cellVoList
     * @param beginRow
     * @param beginCollumn
     */
    public static void getiqInfoFinaCollumnTitle(List<XlsCellVo> cellVoList,int beginRow,int beginCollumn){
  	 	 cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+2,beginCollumn,"项目",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+3,beginCollumn,"利润表(原始货币, 万元)",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+4,beginCollumn,"收入",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+5,beginCollumn,"财务部门收入",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+6,beginCollumn,"保险部门收入",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+7,beginCollumn,"出售资产收益或损失",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+8,beginCollumn,"出售投资收益或损失",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+9,beginCollumn,"利息及投资收入",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+10,beginCollumn,"其他收入",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+11,beginCollumn,"总收入",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+12,beginCollumn,"已售出商品成本",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+13,beginCollumn,"财务部门营运费用",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+14,beginCollumn,"保险部门营运费用",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+15,beginCollumn,"利息支出 - 财务部门",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+16,beginCollumn,"毛利润",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+17,beginCollumn,"销售、综合及管理费用",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+18,beginCollumn,"勘探/钻井成本",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+19,beginCollumn,"坏账准备",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+20,beginCollumn,"股权激励",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+21,beginCollumn,"开前费用",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+22,beginCollumn,"研发费用",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+23,beginCollumn,"折旧及摊销",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+24,beginCollumn,"商誉及无形资产摊销",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+25,beginCollumn,"石油、天然气和矿物资产减损",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+26,beginCollumn,"其他营业费用/（收入）",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+27,beginCollumn,"其他营业费用合计",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+28,beginCollumn,"营业收入",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+29,beginCollumn,"利息费用",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+30,beginCollumn,"利息及投资收入",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+31,beginCollumn,"净利息费用",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+32,beginCollumn,"附属公司收入/（损失）",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+33,beginCollumn,"货币兑换损益",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+34,beginCollumn,"其他非经营性损益",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+35,beginCollumn,"税前利润（不包括非经常项）",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+36,beginCollumn,"重组费用",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+37,beginCollumn,"合并及相关重组费用收费",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+38,beginCollumn,"商誉减值",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+39,beginCollumn,"出售投资损益",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+40,beginCollumn,"出售资产损益",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+41,beginCollumn,"资产减值",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+42,beginCollumn,"仍过程中的研发费用",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+43,beginCollumn,"保险结算",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+44,beginCollumn,"法律结算",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+45,beginCollumn,"其他非经常项",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+46,beginCollumn,"税前利润（包含非经常项）",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+47,beginCollumn,"所得税费用",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+48,beginCollumn,"持续性经营收入",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+49,beginCollumn,"非持续性经营收入",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+50,beginCollumn,"非经常项及会计变更",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+51,beginCollumn,"公司净收入",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+52,beginCollumn,"少数股东收益",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+53,beginCollumn,"少数股东收益",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
  }
    
    /**
     * 被评估公司近5年营业收入平均增长率统计列标题
     * 
     * @param cellVoList
     * @param beginRow
     * @param beginCollumn
     */
    public static void getComInfoProductAveCollumnTitle(List<XlsCellVo> cellVoList,int beginRow,int beginCollumn){
  	 	 cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+2,beginCollumn,"项目",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+3,beginCollumn,"营业收入增长率",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    }
    /**
     * 可比公司近5年财务比率指标统计列标题
     * 
     * @param cellVoList
     * @param beginRow
     * @param beginCollumn
     */
    public static void getIqInfoRationsCollumnTitle(List<XlsCellVo> cellVoList,int beginRow,int beginCollumn){
  	 	 cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+2,beginCollumn,"项目",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+3,beginCollumn,"每股指标",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+4,beginCollumn,"每股收益EPS-基本(元)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+5,beginCollumn,"每股收益EPS-稀释(元)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+6,beginCollumn,"每股收益EPS-期末股本摊薄(元)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+7,beginCollumn,"每股净资产BPS(元)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+8,beginCollumn,"每股经营活动产生的现金流量净额(元)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+9,beginCollumn,"每股营业总收入(元)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+10,beginCollumn,"每股营业收入(元)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+11,beginCollumn,"每股资本公积(元)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+12,beginCollumn,"每股盈余公积(元)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+13,beginCollumn,"每股未分配利润(元)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+14,beginCollumn,"每股留存收益(元)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+15,beginCollumn,"每股现金流量净额(元)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+16,beginCollumn,"每股息税前利润(元)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+17,beginCollumn,"每股企业自由现金流量(元)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+18,beginCollumn,"每股股东自由现金流量(元)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+19,beginCollumn,"盈利能力与收益质量",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+20,beginCollumn,"盈利能力",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+21,beginCollumn,"净资产收益率ROE(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+22,beginCollumn,"净资产收益率ROE-扣除非经常损益(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+23,beginCollumn,"总资产净利润ROA(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+24,beginCollumn,"总资产报酬率ROA(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+25,beginCollumn,"投入资本回报率ROIC(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+26,beginCollumn,"年化净资产收益率(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+27,beginCollumn,"年化总资产净利率(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+28,beginCollumn,"年化总资产报酬率(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+29,beginCollumn,"销售净利率(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+30,beginCollumn,"销售毛利率(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+31,beginCollumn,"销售成本率(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+32,beginCollumn,"销售期间费用率(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+33,beginCollumn,"净利润／营业总收入(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+34,beginCollumn,"主营业务利润／主营业务收入(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+35,beginCollumn,"营业利润／营业总收入(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+36,beginCollumn,"息税前利润／营业总收入(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+37,beginCollumn,"息税前利润／营业总收入(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+38,beginCollumn,"营业总成本／营业总收入(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+39,beginCollumn,"营业费用／营业总收入(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+40,beginCollumn,"管理费用／营业总收入(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+41,beginCollumn,"财务费用／营业总收入(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+42,beginCollumn,"资产减值损失／营业总收入(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+43,beginCollumn,"利润总额/成本费用总额（%）",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+44,beginCollumn,"收益质量",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+45,beginCollumn,"经营活动净收益／利润总额(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+46,beginCollumn,"价值变动净收益／利润总额(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+47,beginCollumn,"营业外收支净额／利润总额(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+48,beginCollumn,"所得税／利润总额(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+49,beginCollumn,"扣除非经常损益后的净利润／净利润(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+50,beginCollumn,"资本结构与偿债能力",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+51,beginCollumn,"资本结构",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+52,beginCollumn,"资产负债率(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+53,beginCollumn,"权益乘数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+54,beginCollumn,"流动资产／总资产(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+55,beginCollumn,"非流动资产／总资产(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+56,beginCollumn,"有形资产／总资产(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+57,beginCollumn,"归属母公司股东的权益／全部投入资本(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+58,beginCollumn,"带息债务／全部投入资本(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+59,beginCollumn,"流动负债／负债合计(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+60,beginCollumn,"非流动负债／负债合计(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+61,beginCollumn,"偿债能力",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+62,beginCollumn,"流动比率",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+63,beginCollumn,"速动比率",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+64,beginCollumn,"保守速动比率",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+65,beginCollumn,"产权比率(负债合计／归属母公司股东的权益)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+66,beginCollumn,"归属母公司股东的权益／负债合计",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+67,beginCollumn,"归属母公司股东的权益／带息债务",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+68,beginCollumn,"有形资产／负债合计",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+69,beginCollumn,"有形资产／带息债务",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+70,beginCollumn,"有形资产／净债务",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+71,beginCollumn,"息税折旧摊销前利润／负债合计",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+72,beginCollumn,"经营活动产生的现金流量净额／负债合计",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+73,beginCollumn,"经营活动产生的现金流量净额／带息债务",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+74,beginCollumn,"经营活动产生的现金流量净额／流动负债",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+75,beginCollumn,"经营活动产生的现金流量净额／净债务",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+76,beginCollumn,"已获利息倍数(EBIT／利息费用)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+77,beginCollumn,"长期债务与营运资金比率",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+78,beginCollumn,"营运能力",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+79,beginCollumn,"营业周期(天)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+80,beginCollumn,"存货周转天数(天)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+81,beginCollumn,"应收账款周转天数(天)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+82,beginCollumn,"存货周转率(次)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+83,beginCollumn,"应收账款周转率(次)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+84,beginCollumn,"流动资产周转率(次)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+85,beginCollumn,"固定资产周转率(次)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+86,beginCollumn,"总资产周转率(次)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+87,beginCollumn,"现金流量",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+88,beginCollumn,"销售商品提供劳务收到的现金／营业收入(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+89,beginCollumn,"经营活动产生的现金流量净额／营业收入(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+90,beginCollumn,"经营活动产生的现金流量净额／经营活动净收益",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+91,beginCollumn,"资本支出／折旧和摊销",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+92,beginCollumn,"成长能力",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+93,beginCollumn,"基本每股收益 (同比增长率)(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+94,beginCollumn,"稀释每股收益 (同比增长率)(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+95,beginCollumn,"每股经营活动产生的现金流量净额 (同比增长率)(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+96,beginCollumn,"营业利润 (同比增长率)(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+97,beginCollumn,"利润总额(同比增长率)(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+98,beginCollumn,"归属母公司股东的净利润(同比增长率)(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+99,beginCollumn,"归属母公司股东的净利润-扣除非经常损益 (同比增长率)(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+100,beginCollumn,"经营活动产生的现金流量净额 (同比增长率)(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+101,beginCollumn,"净资产收益率(摊薄) (同比增长率)(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+102,beginCollumn,"每股净资产(相对年初增长率)(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+103,beginCollumn,"资产总计(相对年初增长率)(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+104,beginCollumn,"归属母公司股东的权益(相对年初增长率)(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+105,beginCollumn,"营业总收入(同比增长率)(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+106,beginCollumn,"营业收入(同比增长率)(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    }
    
    public static void getIqComPatentTitle(List<XlsCellVo> cellVoList,int beginRow,int beginCollumn){
   	 cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn,"项目",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+2,beginCollumn,"独立权利要求数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+3,beginCollumn,"被引证次数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+4,beginCollumn,"从属权利要求数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+5,beginCollumn,"独立权利要求种类",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+6,beginCollumn,"方法和产品",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+7,beginCollumn,"方法",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+8,beginCollumn,"产品",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+9,beginCollumn,"分类号（小类）数量",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+10,beginCollumn,"剩余有效期",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+11,beginCollumn,"引证次数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+12,beginCollumn,"专利技术人员投入数量",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+13,beginCollumn,"专利类型及当前权利状态",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+14,beginCollumn,"发明",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+15,beginCollumn,"实用新型",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+16,beginCollumn,"专利诉讼次数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+17,beginCollumn,"专利许可次数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+18,beginCollumn,"专利质押次数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+19,beginCollumn,"专利转让次数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+20,beginCollumn,"说明书页数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+21,beginCollumn,"附图页数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+22,beginCollumn,"专利族地域种类和数量",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+23,beginCollumn,"地域数量",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+24,beginCollumn,"US、EP、WO",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+25,beginCollumn,"JP、KR",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+26,beginCollumn,"其他国家或地区",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
   }
    
    public static void getComPatentTitle(List<XlsCellVo> cellVoList,int beginRow,int beginCollumn){
  	 	 cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn,"项目",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
  	 	 cellVoList.add(new XlsCellVo(beginRow+2,beginCollumn,"专利申请日",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
  	     cellVoList.add(new XlsCellVo(beginRow+3,beginCollumn,"专利申请号",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
  	     cellVoList.add(new XlsCellVo(beginRow+4,beginCollumn,"专利公开号",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
  	     cellVoList.add(new XlsCellVo(beginRow+5,beginCollumn,"专利类型",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
  	     cellVoList.add(new XlsCellVo(beginRow+6,beginCollumn,"专利名称",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
  	     cellVoList.add(new XlsCellVo(beginRow+7,beginCollumn,"专利分类号",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+8,beginCollumn,"独立权利要求数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+9,beginCollumn,"被引证次数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+10,beginCollumn,"从属权利要求数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+11,beginCollumn,"独立权利要求种类",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+12,beginCollumn,"方法和产品",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+13,beginCollumn,"方法",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+14,beginCollumn,"产品",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+15,beginCollumn,"分类号（小类）数量",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+16,beginCollumn,"剩余有效期",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+17,beginCollumn,"引证次数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+18,beginCollumn,"专利技术人员投入数量",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+19,beginCollumn,"专利类型及当前权利状态",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+20,beginCollumn,"发明",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+21,beginCollumn,"实用新型",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+22,beginCollumn,"专利诉讼次数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+23,beginCollumn,"专利许可次数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+24,beginCollumn,"专利质押次数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+25,beginCollumn,"专利转让次数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+26,beginCollumn,"说明书页数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+27,beginCollumn,"附图页数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+28,beginCollumn,"专利族地域种类和数量",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+29,beginCollumn,"地域数量",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+30,beginCollumn,"US、EP、WO",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+31,beginCollumn,"JP、KR",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+32,beginCollumn,"其他国家或地区",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 /*cellVoList.add(new XlsCellVo(beginRow+33,beginCollumn,"专利评价得分",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));*/
    }
    /**
     * 收益法估值结果表统计列标题
     * 
     * @param cellVoList
     * @param beginRow
     * @param beginCollumn
     */
    public static void getProVal0CollumnTitle(List<XlsCellVo> cellVoList,int beginRow,int beginCollumn,String categroy){
  	 	 cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn,"项目",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+2,beginCollumn,"专利资产收益额",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 if(ProVal.category_2.equals(categroy)){//超额收益法
			 cellVoList.add(new XlsCellVo(beginRow+3,beginCollumn,"所得税率",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			 cellVoList.add(new XlsCellVo(beginRow+4,beginCollumn,"超额收益净额",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 }else{
			 cellVoList.add(new XlsCellVo(beginRow+3,beginCollumn,"分成率",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			 cellVoList.add(new XlsCellVo(beginRow+4,beginCollumn,"分成额",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 }
		 cellVoList.add(new XlsCellVo(beginRow+5,beginCollumn,"折现率",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+6,beginCollumn,"序列年期",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+7,beginCollumn,"折现系数",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+8,beginCollumn,"现值",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+9,beginCollumn,"现值合计",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+10,beginCollumn,"专利资产价值",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    }
    /**
     * 12.1.2收益法各专利估值列标题
     * 
     * @param cellVoList
     * @param beginRow
     * @param beginCollumn
     */
    public static void getProVal0PatentCollumnTitle(List<XlsCellVo> cellVoList,int beginRow,int beginCollumn){
  	 	 cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn,"序号",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn+1,"专利名称及专利公开号",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn+2,"权重",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn+3,"专利估值",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
  }
    
    /**
     * 被评估公司历史财务统计列标题
     * 
     * @param cellVoList
     * @param beginRow
     * @param beginCollumn
     */
    public static void getComInfoFinaCollumnTitle(List<XlsCellVo> cellVoList,int beginRow,int beginCollumn){
  	 	 cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+2,beginCollumn,"项目",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+3,beginCollumn,"资产负债表(原始货币, 万元)",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+4,beginCollumn,"流动资产：",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+5,beginCollumn,"货币资金",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+6,beginCollumn,"结算备付金",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+7,beginCollumn,"拆出资金",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+8,beginCollumn,"交易性金融资产",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+9,beginCollumn,"应收票据",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+10,beginCollumn,"应收账款",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+11,beginCollumn,"预付款项",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+12,beginCollumn,"应收保费",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+13,beginCollumn,"应收分保账款",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+14,beginCollumn,"应收分保合同准备金",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+15,beginCollumn,"应收利息",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+16,beginCollumn,"其他应收款",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+17,beginCollumn,"应收股利",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+18,beginCollumn,"买入返售金融资产",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+19,beginCollumn,"存货",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+20,beginCollumn,"其中：消耗性生物资产",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+21,beginCollumn,"一年内到期的非流动资产",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+22,beginCollumn,"待摊费用",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+23,beginCollumn,"其他流动资产",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+24,beginCollumn,"流动资产差额(特殊报表科目)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+25,beginCollumn,"流动资产差额(合计平衡项目)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+26,beginCollumn,"流动资产合计",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+27,beginCollumn,"非流动资产：",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+28,beginCollumn,"发放贷款及垫款",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+29,beginCollumn,"可供出售金融资产",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+30,beginCollumn,"持有至到期投资",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+31,beginCollumn,"长期应收款",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+32,beginCollumn,"长期股权投资",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+33,beginCollumn,"投资性房地产",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+34,beginCollumn,"固定资产",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+35,beginCollumn,"在建工程",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+36,beginCollumn,"工程物资",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+37,beginCollumn,"固定资产清理",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+38,beginCollumn,"生产性生物资产",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+39,beginCollumn,"油气资产",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+40,beginCollumn,"无形资产",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+41,beginCollumn,"开发支出",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+42,beginCollumn,"商誉",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+43,beginCollumn,"长期待摊费用",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+44,beginCollumn,"递延所得税资产",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+45,beginCollumn,"其他非流动资产",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+46,beginCollumn,"非流动资产差额(特殊报表科目)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+47,beginCollumn,"非流动资产差额(合计平衡项目)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+48,beginCollumn,"非流动资产合计",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+49,beginCollumn,"资产差额(特殊报表科目)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+50,beginCollumn,"资产差额(合计平衡项目)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+51,beginCollumn,"资产总计",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+52,beginCollumn,"流动负债：",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+53,beginCollumn,"短期借款",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+54,beginCollumn,"向中央银行借款",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+55,beginCollumn,"吸收存款及同业存放",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+56,beginCollumn,"拆入资金",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+57,beginCollumn,"交易性金融负债",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+58,beginCollumn,"应付票据",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+59,beginCollumn,"应付账款",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+60,beginCollumn,"预收款项",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+61,beginCollumn,"卖出回购金融资产款",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+62,beginCollumn,"应付手续费及佣金",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+63,beginCollumn,"应付职工薪酬",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+64,beginCollumn,"应交税费",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+65,beginCollumn,"应付利息",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+66,beginCollumn,"其他应付款",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+67,beginCollumn,"应付分保账款",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+68,beginCollumn,"保险合同准备金",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+69,beginCollumn,"代理买卖证券款",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+70,beginCollumn,"代理承销证券款",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+71,beginCollumn,"一年内到期的非流动负债",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+72,beginCollumn,"应付股利",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+73,beginCollumn,"预提费用",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+74,beginCollumn,"递延收益-流动负债",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+75,beginCollumn,"应付短期债券",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+76,beginCollumn,"其他流动负债",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+77,beginCollumn,"流动负债差额(特殊报表科目)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+78,beginCollumn,"流动负债差额(合计平衡项目)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+79,beginCollumn,"流动负债合计",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+80,beginCollumn,"非流动负债：",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+81,beginCollumn,"长期借款",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+82,beginCollumn,"应付债券",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+83,beginCollumn,"长期应付款",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+84,beginCollumn,"专项应付款",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+85,beginCollumn,"预计负债",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+86,beginCollumn,"递延所得税负债",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+87,beginCollumn,"递延收益-非流动负债",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+88,beginCollumn,"其他非流动负债",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+89,beginCollumn,"非流动负债差额(特殊报表科目)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+90,beginCollumn,"非流动负债差额(合计平衡项目)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+91,beginCollumn,"非流动负债合计",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+92,beginCollumn,"负债差额(特殊报表科目)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+93,beginCollumn,"负债差额(合计平衡项目)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+94,beginCollumn,"负债合计",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+95,beginCollumn,"所有者权益(或股东权益)：",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+96,beginCollumn,"实收资本(或股本)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+97,beginCollumn,"资本公积金",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+98,beginCollumn,"减：库存股",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+99,beginCollumn,"专项储备",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+100,beginCollumn,"盈余公积金",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+101,beginCollumn,"一般风险准备",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+102,beginCollumn,"未分配利润",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+103,beginCollumn,"外币报表折算差额",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+104,beginCollumn,"未确认的投资损失",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+105,beginCollumn,"少数股东权益",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+106,beginCollumn,"股东权益差额(特殊报表科目)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+107,beginCollumn,"股权权益差额(合计平衡项目)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+108,beginCollumn,"归属于母公司所有者权益合计",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+109,beginCollumn,"所有者权益合计",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+110,beginCollumn,"负债及股东权益差额(特殊报表项目)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+111,beginCollumn,"负债及股东权益差额(合计平衡项目)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+112,beginCollumn,"负债和所有者权益总计",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
  }
    
    /**
     * 被评估公司财务统计列标题
     * 
     * @param cellVoList
     * @param beginRow
     * @param beginCollumn
     */
    public static void getcomInfoFinaCollumnTitle(List<XlsCellVo> cellVoList,int beginRow,int beginCollumn){
  	 	 cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+2,beginCollumn,"项目",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+3,beginCollumn,"利润表(原始货币, 万元)",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+4,beginCollumn,"一、营业总收入",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+5,beginCollumn,"营业收入",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+6,beginCollumn,"利息收入",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+7,beginCollumn,"已赚保费",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+8,beginCollumn,"手续费及佣金收入",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+9,beginCollumn,"二、营业总成本",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+10,beginCollumn,"营业成本",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+11,beginCollumn,"利息支出",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+12,beginCollumn,"手续费及佣金支出",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+13,beginCollumn,"退保金",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+14,beginCollumn,"赔付支出净额",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+15,beginCollumn,"提取保险合同准备金净额",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+16,beginCollumn,"保单红利支出",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+17,beginCollumn,"分保费用",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+18,beginCollumn,"营业税金及附加",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+19,beginCollumn,"销售费用",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+20,beginCollumn,"管理费用",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+21,beginCollumn,"财务费用",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+22,beginCollumn,"资产减值损失",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+23,beginCollumn,"三、其他经营收益",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+24,beginCollumn,"公允价值变动净收益",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+25,beginCollumn,"投资净收益",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+26,beginCollumn,"其中：对联营企业和合营企业的投资收益",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+27,beginCollumn,"汇兑净收益",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+28,beginCollumn,"加：营业利润差额(特殊报表科目)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+29,beginCollumn,"加：营业利润差额(合计平衡项目)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+30,beginCollumn,"四、营业利润",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+31,beginCollumn,"加：营业外收入",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+32,beginCollumn,"减：营业外支出",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+33,beginCollumn,"其中：非流动资产处置净损失",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+34,beginCollumn,"加：利润总额差额(特殊报表科目)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+35,beginCollumn,"加：利润总额差额(合计平衡项目)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+36,beginCollumn,"五、利润总额",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+37,beginCollumn,"减：所得税",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+38,beginCollumn,"加：未确认的投资损失",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+39,beginCollumn,"加：净利润差额(特殊报表科目)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+40,beginCollumn,"加：净利润差额(合计平衡项目)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+41,beginCollumn,"六、净利润",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+42,beginCollumn,"减：少数股东损益",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+43,beginCollumn,"归属于母公司所有者的净利润",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+44,beginCollumn,"加：其他综合收益",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+45,beginCollumn,"七、综合收益总额",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+46,beginCollumn,"减：归属于少数股东的综合收益总额",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+47,beginCollumn,"归属于母公司普通股东综合收益总额",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+48,beginCollumn,"八、每股收益",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+49,beginCollumn,"(一) 基本每股收益(元)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+50,beginCollumn,"(二) 稀释每股收益(元)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
  }
    
    /**
     * 公司近5年财务比率指标统计列标题
     * 
     * @param cellVoList
     * @param beginRow
     * @param beginCollumn
     */
    public static void getComInfoRationsCollumnTitle(List<XlsCellVo> cellVoList,int beginRow,int beginCollumn){
  	 	 cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+2,beginCollumn,"项目",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+3,beginCollumn,"盈利能力",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+4,beginCollumn,"净资产收益率(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+5,beginCollumn,"总资产报酬率(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+6,beginCollumn,"销售(营业)利润率(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+7,beginCollumn,"成本费用利润率(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+8,beginCollumn,"营运能力",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+9,beginCollumn,"总资产周转率(次)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+10,beginCollumn,"应收账款周转率(次)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+11,beginCollumn,"存货周转率(次)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+12,beginCollumn,"流动资产周转率(次)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+13,beginCollumn,"偿债能力",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+14,beginCollumn,"资产负债率(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+15,beginCollumn,"已获利息倍数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+16,beginCollumn,"流动比率(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+17,beginCollumn,"速动比率(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+18,beginCollumn,"成长能力",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+19,beginCollumn,"销售(营业)增长率(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+20,beginCollumn,"资本保值增值率(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+21,beginCollumn,"销售(营业)利润增长率(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+22,beginCollumn,"总资产增长率(%)",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
  }
}
