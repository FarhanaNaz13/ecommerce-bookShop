package com.adminportal.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.ResourceUtils;

import com.adminportal.domain.Order;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


public interface OrderService {

	 default List<Order> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	Order findOne(Long id);

	    void removeOne(Long id);

	    
	    public default  String exportReport(String format) throws FileNotFoundException, JRException{
	    	List<Order> orderList = findAll();
	    	String path = "D://jasper//New folder//JasperReports";
	    	File file = ResourceUtils.getFile("classpath: src/main/resources/orderList.jrxml");
	    	JasperReport jasper = JasperCompileManager.compileReport(file.getAbsolutePath());
			  JRBeanCollectionDataSource ds = new  JRBeanCollectionDataSource(orderList);
	    	
			  
			  Map<String,Object> parameters = new HashMap<String,Object>();
			  parameters.put("Order List", "customers");
			  JasperPrint jasperPrint = JasperFillManager.fillReport(jasper,parameters,ds);
			  
			  if(format.equalsIgnoreCase("html")) {
				  JasperExportManager.exportReportToHtmlFile(jasperPrint,path +"//orderList.html");
			  }
              if(format.equalsIgnoreCase("pdf")) {
            	  JasperExportManager.exportReportToPdfFile(jasperPrint,path +"//orderList.pdf");
			  }
	    	return "path : " + path;
	    }
  
}
