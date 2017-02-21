package com.kpap.common.util.chart;

import java.awt.Color;
import java.awt.Font;  
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.TimeSeries;  
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;
  
/**
 * 
 * 折线图<BR>
 *
 * @auther shenhaiwen
 * @date 2016-12-21 下午10:58:13
 */
public class TimeSeriesChart {  
	public List<Color> colors=Arrays.asList(new Color(79, 129, 189),new Color(192, 80, 77),new Color(155, 187, 89),new Color(128, 100,162),new Color(75, 172,198),new Color(247, 150,70));
    ChartPanel frame1; 
    private JFreeChart chart;
    
    public JFreeChart getChart() {
		return chart;
	}
    public TimeSeriesChart(String title,String collumnTitle,String rowTitle,TreeMap<String, TreeMap<Integer,Double>> treeMap){
        XYDataset xydataset = createDataset(treeMap);  
        chart = ChartFactory.createTimeSeriesChart(title, rowTitle, collumnTitle,xydataset, true, true, true);  
        XYPlot xyplot = (XYPlot) chart.getPlot();  
        xyplot.setBackgroundPaint(Color.white);
        XYLineAndShapeRenderer xylinerenderer = (XYLineAndShapeRenderer)xyplot.getRenderer();  
        xylinerenderer.setBaseShapesVisible(true); 
        
        for (int i=0;i<xydataset.getSeriesCount();i++) {  
        	xylinerenderer.setSeriesPaint(i, colors.get(i));
        } 
        
        DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();  
        //dateaxis.setDateFormatOverride(new SimpleDateFormat("yyyy"));
        dateaxis.setTickUnit(new DateTickUnit(DateTickUnit.YEAR, 1, new SimpleDateFormat("yyyy"))); 
        frame1=new ChartPanel(chart,true);  
        dateaxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题  
        dateaxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题  
        ValueAxis rangeAxis=xyplot.getRangeAxis();//获取柱状  
        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));  
        chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));  
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体  
        

  
    }   
     private static XYDataset createDataset(TreeMap<String, TreeMap<Integer,Double>> treeMap) {  //这个数据集有点多，但都不难理解  
    	 Iterator<String> ir= treeMap.keySet().iterator();
    	 TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();  
    	 while(ir.hasNext()){
    		 String nameKey= (String)ir.next();
    		 TimeSeries  timeseries = new TimeSeries(nameKey,org.jfree.data.time.Year.class);
    		 TreeMap<Integer,Double> map = treeMap.get(nameKey);
    		 Iterator<Integer> yearIr= map.keySet().iterator();
    		 while(yearIr.hasNext()){
    			 Object object = yearIr.next();
    			 if(object == null){
    				 continue;
    			 }
    			 int yearKey = (int)object;
    			 double value  = 0;
    			 if(map.get(yearKey) != null){
    				 value = (double)map.get(yearKey);
    			 }
    			 timeseries.add(new Year(yearKey), value);  
    		 }
    		 timeseriescollection.addSeries(timeseries);  
    	 } 
         return timeseriescollection;  
      }
     
     
      public ChartPanel getChartPanel(){  
            return frame1;  
              
        }  
}  
