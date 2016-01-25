package com.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.code.UpperFirstCharacter;

import freemarker.template.Configuration;
import freemarker.template.Template;

@SuppressWarnings("unchecked")
public class Test {
	
	public static void main(String[] args) {
		System.err.println("dd");
		Configuration cfg = new  Configuration();
		try {
			cfg.setClassForTemplateLoading(Test.class ,  "/com" ); //指定模板所在的classpath目录   
            cfg.setSharedVariable("upperFC" ,  new  UpperFirstCharacter()); //  添加一个"宏"共享变量用来将属性名首字母大写   
            Template t = cfg.getTemplate("temp/javabean.html" ); //指定模板   
            FileOutputStream fos = new  FileOutputStream( new  File( "d:/Student.java")); //生成文件路径   
            Map data = new  HashMap();  
            data.put("package" ,  "com.generate" ); //包路径
            data.put("className" ,  "Student" );  //实体名
            data.put("description", "学生实体");//实体描述
            data.put("author", "wujl");
            data.put("createDate", "2016-01-25");
            List pros = new  ArrayList();  
            Map pro_1 = new  HashMap();  
            pro_1.put("proType" , String.class.getSimpleName()); //字段类型 
            pro_1.put("proName" ,  "name" ); //字段名
            pro_1.put("fieldNote" ,  "姓名" );//字段注释
            pros.add(pro_1);  
              
            Map pro_2 = new  HashMap();  
            pro_2.put("proType" , String.class.getSimpleName());  
            pro_2.put("proName" ,  "sex" );  
            pro_2.put("fieldNote" ,  "性别" );
            pros.add(pro_2);  
              
            Map pro_3 = new  HashMap();  
            pro_3.put("proType" , Integer.class.getSimpleName());  
            pro_3.put("proName" ,  "age" );  
            pro_3.put("fieldNote" ,  "年龄" );
            pros.add(pro_3);  
              
            data.put("properties" , pros);  
            t.process(data, new  OutputStreamWriter(fos, "utf-8" )); //   
            fos.flush();  
            fos.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
