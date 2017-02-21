package com.kpap.common.util.chart;

import java.awt.Color;
import java.awt.Font;
import java.util.Arrays;
import java.util.List;

import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
  
/**
 * 
 * 折线图<BR>
 *
 * @auther hdl
 * @date 2016-12-21 下午10:58:13
 */
public class LineChart {  
	public List<Color> colors=Arrays.asList(new Color(79, 129, 189),new Color(192, 80, 77),new Color(155, 187, 89),new Color(128, 100,162),new Color(75, 172,198),new Color(247, 150,70));
    ChartPanel frame1; 
    private JFreeChart chart;
    
    public JFreeChart getChart() {
		return chart;
	}
    public LineChart(String title,String collumnTitle,String rowTitle,String[] rowKeys,String[] colKeys,double[][] data){
    	CategoryDataset categoryDataset =DatasetUtilities.createCategoryDataset(rowKeys, colKeys, data);  
        chart = ChartFactory.createLineChart(
        		title, // 标题  
        		rowTitle, // categoryAxisLabel （category轴，横轴，X轴标签）  
                collumnTitle, // valueAxisLabel（value轴，纵轴，Y轴的标签）  
                categoryDataset, // dataset  
                PlotOrientation.VERTICAL, 
                true, // legend  
                false, // tooltips  
                false); // URLs  
        CategoryPlot  categoryPlot  = (CategoryPlot) chart.getPlot();  
        categoryPlot.setBackgroundPaint(Color.white);
        LineAndShapeRenderer  renderer  = (LineAndShapeRenderer)categoryPlot.getRenderer();  
        renderer.setBaseShapesVisible(true);  
        for (int i=0;i<categoryDataset.getRowCount();i++) {  
        	renderer.setSeriesPaint(i, colors.get(i));
        } 
        
        CategoryAxis categoryAxis = (CategoryAxis)categoryPlot.getDomainAxis();  
        frame1=new ChartPanel(chart,true);  
        categoryAxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题  
        categoryAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题  
        ValueAxis rangeAxis=categoryPlot.getRangeAxis();//获取柱状  
        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));  
        chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));  
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体  
        

  
    }   
      public ChartPanel getChartPanel(){  
            return frame1;  
              
        }  
}  
