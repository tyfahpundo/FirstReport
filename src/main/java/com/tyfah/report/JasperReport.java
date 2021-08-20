package com.tyfah.report;

import java.util.HashMap;
import java.util.Map;

public class JasperReport {
    public static void main(String[] args) {
        try{
            String filePath = "\\home\\tyfah\\IdeaProjects\\FirstReport\\src\\main\\resources\\FirstReport.jrxml";

            Map<String,Object> parameters = new HashMap<String,Object>();
            parameters.put("studentName", "Tafadzwa");
        }catch(Exception e){
            System.out.println("Exception While creating report");
        }
    }
}
