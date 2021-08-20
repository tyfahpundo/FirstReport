package com.tyfah.report;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.sf.jasperreports.engine.JasperCompileManager.compileReport;

public class JasperReport {
    public static void main(String[] args) {
        try{
            String filePath = "/home/tyfah/IdeaProjects/FirstReport/src/main/resources/FirstReport.jrxml";

            Map<String,Object> parameters = new HashMap<String,Object>();
            parameters.put("studentName", "Tafadzwa");

            Student stud1 = new Student(1L,"Tafadzwa","Pundo","Skymaster","Harare");
            Student stud2 = new Student(2L,"Alex","Pundo","DuvhaPark","Mpumalanga");

            List<Student> list = new ArrayList<Student>();
            list.add(stud1);
            list.add(stud2);
            //Passing The list to the JasperReport
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);
            //Compile the The jasperReport
            net.sf.jasperreports.engine.JasperReport report = JasperCompileManager.compileReport(filePath);
            JasperPrint print = JasperFillManager.fillReport(report,parameters,dataSource);
            //Convert to pdf
            JasperExportManager.exportReportToPdfFile(print,"/home/tyfah/IdeaProjects/FirstReport.pdf");
            System.out.println("Report Created.....");
        }catch(Exception e){
            System.out.println("Exception While creating report");
        }
    }
}
