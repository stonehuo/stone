package com.kpap.common.util.chart;

import java.awt.Color;
import java.awt.Font;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.axis.CategoryAxis;  
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;  
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * 
 * 柱形图<BR>
 *
 * @auther shenhaiwen
 * @date 2016-12-21 下午10:04:51
 */
public class BarChart { 
	public List<Color> colors=Arrays.asList(new Color(79, 129, 189),new Color(192, 80, 77),new Color(155, 187, 89),new Color(128, 100,162),new Color(75, 172,198),new Color(247, 150,70));
    ChartPanel frame1; 
    private JFreeChart chart;
     public JFreeChart getChart() {
		return chart;
	}
	public  BarChart(String title,String rowTitle,String collumnTitle,TreeMap<String, TreeMap<String,Double>> treeMap){  
        CategoryDataset dataset = getDataSet(treeMap);  
        chart = ChartFactory.createBarChart3D(  
        		title, // 图表标题  
        		rowTitle, // 目录轴的显示标签  
        		collumnTitle, // 数值轴的显示标签  
                            dataset, // 数据集  
                            PlotOrientation.VERTICAL, // 图表方向：水平、垂直  
                            true,           // 是否显示图例(对于简单的柱状图必须是false)  
                            false,          // 是否生成工具  
                            false           // 是否生成URL链接  
                            );  
          
        //从这里开始  
        CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象  
        plot.setBackgroundPaint(Color.white); 
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        for (int i=0;i<dataset.getRowCount();i++) {  
        	renderer.setSeriesPaint(i, colors.get(i));
        } 
        //显示条目标签
        renderer.setBaseItemLabelsVisible(true);

        CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表  
        domainAxis.setLabelFont(new Font("宋体",Font.BOLD,14));         //水平底部标题  
        domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题  
        ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状  
        rangeAxis.setLabelFont(new Font("宋体",Font.BOLD,15));  
        chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 15));  
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体  
            
        //到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题  
        frame1=new ChartPanel(chart,true);        //这里也可以用chartFrame,可以直接生成一个独立的Frame  
           
    }  
       private static CategoryDataset getDataSet(TreeMap<String, TreeMap<String,Double>> treeMap) {  
           DefaultCategoryDataset dataset = new DefaultCategoryDataset();
           Iterator<String> ir= treeMap.keySet().iterator();
           while(ir.hasNext()){
        	   String nameKey = (String) ir.next();
        	   TreeMap<String,Double> valueTreeMap = treeMap.get(nameKey);
        	   Iterator<String> valueIr = valueTreeMap.keySet().iterator();
        	   while(valueIr.hasNext()){
        		   Object object =  valueIr.next();
        		   if(object == null){
        			   continue;
        		   }
        		   String key = (String) object;
        		   double value = 0;
        		   if(valueTreeMap.get(key) != null){
        			   value = (double)valueTreeMap.get(key);
        		   }
        		   dataset.addValue(value, key, nameKey);  
        	   }
           }
           return dataset;  
}  
public ChartPanel getChartPanel(){  
    return frame1;  
      
} 
} 