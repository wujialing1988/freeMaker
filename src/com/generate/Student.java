package com.generate;  
  
import java.util.Date;  
  
import java.io.Serializable;  

/**
 * 描述：学生实体
 * 作者：wujl
 * 时间：2016-01-25
 **/
public class Student implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
 
    private String name; //姓名
    private String sex; //性别
    private Integer age; //年龄
      
    public void setName(String name){  
        this.name=name;  
    }  
      
    public String getName(){  
        return this.name;  
    }  
    public void setSex(String sex){  
        this.sex=sex;  
    }  
      
    public String getSex(){  
        return this.sex;  
    }  
    public void setAge(Integer age){  
        this.age=age;  
    }  
      
    public Integer getAge(){  
        return this.age;  
    }  
}  