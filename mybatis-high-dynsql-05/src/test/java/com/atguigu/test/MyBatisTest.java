package com.atguigu.test;

import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyBatisTest {

    private SqlSession session;
    // junit会在每一个@Test方法前执行@BeforeEach方法

    @BeforeEach
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder()
                .build(
                        Resources.getResourceAsStream("mybatis-config.xml"))
                .openSession();
    }

    // junit会在每一个@Test方法后执行@@AfterEach方法
    @AfterEach
    public void clear() {
        session.commit();
        session.close();
    }

    @Test
    // List<Employee> selectEmployeeByCondition(Employee employee);
    public void test_01(){
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setEmpName("tom");
        employee.setEmpSalary(400.0);
        List<Employee> employees = mapper.selectEmployeeByCondition(employee);
        System.out.println("employees = " + employees);
    }

    @Test
    // int updateEmployeeDynamic(Employee employee);
    public void test_02(){
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setEmpId(1);
        employee.setEmpName("tom2");
        employee.setEmpSalary(50.0);
        int i = mapper.updateEmployeeDynamic(employee);
        System.out.println("i = " + i);
    }

    @Test
    // List<Employee> selectEmployeeByConditionByChoose(Employee employee);
    public void test_03(){
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setEmpName("tom2");
        employee.setEmpSalary(300.0);
        List<Employee> employees = mapper.selectEmployeeByConditionByChoose(employee);
        System.out.println("employees = " + employees);
    }

    @Test
    // int insertEmployeeBatch(@Param("emplist") List<Employee> employeeList);
    public void test_04(){
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setEmpName("tom123");
        employee.setEmpSalary(100.0);
        Employee employee1 = new Employee();
        employee1.setEmpName("tom345");
        employee1.setEmpSalary(20.0);
        List<Employee> list = new ArrayList<>();
        list.add(employee);
        list.add(employee1);
        int i = mapper.insertEmployeeBatch(list);
        System.out.println("i = " + i);
    }

    @Test
    // int updateEmployeeBatch(@Param("empList") List<Employee> empList);
    public void test_05(){
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setEmpId(1);
        employee.setEmpName("tom6");
        Employee employee1 = new Employee();
        employee1.setEmpId(2);
        employee1.setEmpName("tom5");
        List<Employee> list = new ArrayList<>();
        list.add(employee);
        list.add(employee1);
        int i = mapper.updateEmployeeBatch(list);
        System.out.println("i = " + i);
    }
}