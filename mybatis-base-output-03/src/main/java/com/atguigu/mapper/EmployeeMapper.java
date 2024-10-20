package com.atguigu.mapper;


import com.atguigu.pojo.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {


    //查询员工的总数
    int selectEmpCount();

    //根据id查询员工
    Employee selectEmployee(Integer empId);

    //查询工资最高的员工的姓名和他的工资、以及部门平均工资
    Map<String,Object> selectEmpNameAndMaxSalary();

    //查询返回所有的员工
    List<Employee> selectAll();

    //插入一个员工
    int insertEmployee(Employee employee);

    //根据id查询员工（resultMap方式重命名）
    Employee selectEmployeeByRM(Integer empId);

}