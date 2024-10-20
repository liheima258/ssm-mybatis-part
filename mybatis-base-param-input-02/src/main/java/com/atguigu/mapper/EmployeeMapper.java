package com.atguigu.mapper;

import com.atguigu.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface EmployeeMapper {


    Employee selectEmployee(Integer empId);

    int insertEmployee(Employee employee);

    int updateEmployee(@Param("empId") Integer empId, @Param("empSalary") Double empSalary);

    int updateEmployeeByMap(Map<String, Object> paramMap);
}