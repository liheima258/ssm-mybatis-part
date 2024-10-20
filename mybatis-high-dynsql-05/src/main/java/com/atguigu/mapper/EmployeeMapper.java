package com.atguigu.mapper;


import com.atguigu.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {

    //根据 员工姓名或薪水 查询员工 ==> where + if
    List<Employee> selectEmployeeByCondition(Employee employee);

    //更改单个员工信息 ==> set + if
    int updateEmployeeDynamic(Employee employee);

    //根据 员工姓名或薪水 查询员工 ==> choose + when
    List<Employee> selectEmployeeByConditionByChoose(Employee employee);

    //根据 员工集合 批量插入员工信息 ==> foreach
    int insertEmployeeBatch(@Param("empList") List<Employee> employeeList);

    //根据 员工 集合批量更改员工信息 ==> foreach
    int updateEmployeeBatch(@Param("empList") List<Employee> empList);

}
