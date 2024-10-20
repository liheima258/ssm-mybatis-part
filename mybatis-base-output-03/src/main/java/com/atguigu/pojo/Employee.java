package com.atguigu.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

//若有注解，则别名为其注解值
@Alias("Employee")
@Data
public class Employee {

    private Integer empId;

    private String empName;

    private Double empSalary;
}