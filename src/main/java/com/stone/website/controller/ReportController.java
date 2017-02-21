package com.kpap.website.controller;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kpap.basis.exception.BusinessException;
import com.kpap.common.util.ResultMap;
import com.kpap.website.service.impl.ReportExportHandler;

/**
 * 
 * 报告生成控制器<BR>
 *
 * @auther shenhaiwen
 * @date 2016-12-11 下午10:10:06
 */
@Controller
public class ReportController {
	
	@Autowired
	private ReportExportHandler reportExportHandler;
	
	private static final Logger logger = LoggerFactory.getLogger(ReportController.class);
	
	/**
	 * 导出评价报告基础元素，包括基础数据及图片
	 * 
	 * @return
	 */
	@RequestMapping(value="/exportReport")
	public void exportReport(HttpServletRequest request,HttpServletResponse response){
		String proCode = request.getParameter("proCode");
		String reportType = request.getParameter("reportType"); // 评价evaluate，评估assessment
//		// 导出数据
		long beginTime = System.currentTimeMillis();
		String result = "";
		try {
			result =  reportExportHandler.doExport(proCode,reportType);
		} catch (Exception e) {
			logger.error("导出订单失败：",e);
			throw new BusinessException("导出失败，原因："+e.getMessage());
		}
		String detail = "共计费时["+(System.currentTimeMillis()-beginTime)+"]ms,导出路径为："+result;
		logger.info("=======导出报表结束，"+detail+"=======");
		
	}
	
	/**
	 * 测试 TODO - 框架走通
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<String, String>();
		// TODO 测试架构的测试数据
		map.put("专利权人", "浙江吉利汽车研究院有限公司");
		map.put("专利申请日", "20141212");
		map.put("专利名称", "汽车构建创新发明");
		map.put("被引证次数", "102");
		
		String proCode = "";
		// 导出数据
		long beginTime = System.currentTimeMillis();
		ReportExportHandler handler = new ReportExportHandler();
		String result = "";
		try {
			result =  handler.doExport(proCode,"assessment");
		} catch (Exception e) {
			logger.error("导出订单失败：",e);
			throw new BusinessException("导出失败，原因："+e.getMessage());
		}
		String detail = "共计费时["+(System.currentTimeMillis()-beginTime)+"]ms,导出路径为："+result;
		logger.info("=======导出订单结束，"+detail+"=======");
	}

	

}
