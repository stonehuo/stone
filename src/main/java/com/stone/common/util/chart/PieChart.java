package com.kpap.common.util.chart;

import java.awt.Color;
import java.awt.Font;  
import java.text.DecimalFormat;  
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry; 
  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;  
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
  
/**
 * 
 * 饼图<BR>
 *
 * @auther shenhaiwen
 * @date 2016-12-21 下午10:06:50
 */
public class PieChart {  
	public List<Color> colors=Arrays.asList(new Color(79, 129, 189),new Color(192, 80, 77),new Color(155, 187, 89),new Color(128, 100,162),new Color(75, 172,198),new Color(247, 150,70));
    private JFreeChart chart;
    
    public JFreeChart getChart() {
		return chart;
	}
    
    public PieChart(String title,HashMap<String,Double> dateSet){  
          DefaultPieDataset data = getDataSet(dateSet);  
          chart = ChartFactory.createPieChart(title,data,true,false,false);  
          chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
          chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,10));
         
          PiePlot pieplot = (PiePlot) chart.getPlot();
          pieplot.setLabelFont(new Font("宋体",Font.BOLD,10));//解决乱码 
          pieplot.setIgnoreNullValues(true);//设置不显示空值  
          pieplot.setIgnoreZeroValues(true);//设置不显示负值  
          
          pieplot.setBackgroundPaint(Color.white); //设置背景色
          pieplot.setShadowPaint(Color.WHITE);
          for (int i=0;i<data.getItemCount();i++) {
        	  pieplot.setSectionPaint(data.getKey(i), colors.get(i));    
          } 
          
          //设置百分比  
          DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题  
          NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象  
          StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象  
          pieplot.setLabelGenerator(sp1);//设置饼图显示百分比  
        
          //没有数据的时候显示的内容  
          pieplot.setNoDataMessage("无数据显示");  
          pieplot.setCircular(true);  
          //pieplot.setLabelGap(0D);  
        
    }  
    private static DefaultPieDataset getDataSet(HashMap<String,Double> dateSet) {  
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Entry<String, Double> entry : dateSet.entrySet()) {
        	 dataset.setValue(entry.getKey(),entry.getValue()); 
        }
        return dataset;  
    }  
}  
