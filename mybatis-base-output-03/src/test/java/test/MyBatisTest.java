package test;

import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class MyBatisTest {

    private SqlSession session;

    //junit5会在每一个@Test方法前执行@BeforeEach方法
    @BeforeEach
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder()
                .build(
                        Resources.getResourceAsStream("mybatis-config.xml"))
                .openSession();
    }

    //junit5会在每一个@Test方法后执行@@AfterEach方法
    @AfterEach
    public void clear() {
        session.commit();
        session.close();
    }

    //场景一
    @Test
    public void test_01() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        int i = mapper.selectEmpCount();
        System.out.println("i = " + i);
    }

    //场景二
    @Test
    public void test_02() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = mapper.selectEmployee(1);
        System.out.println("employee = " + employee);
    }

    //场景三
    @Test
    public void test_03() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Map<String, Object> resultMap = employeeMapper.selectEmpNameAndMaxSalary();
        Set<Map.Entry<String, Object>> entrySet = resultMap.entrySet();
        for (Map.Entry<String, Object> entry : entrySet) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + "=" + value);
        }
    }

    //场景四
    @Test
    public void test_04() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        List<Employee> employeeList = employeeMapper.selectAll();
        for (Employee employee : employeeList) {
            System.out.println("employee = " + employee);
        }
    }

    //场景五
    @Test
    public void test_05() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setEmpName("john");
        employee.setEmpSalary(666.66);
        employeeMapper.insertEmployee(employee);
        System.out.println("employee.getEmpId() = " + employee.getEmpId());
    }

    //总结
    @Test
    public void test_06() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Employee employee = employeeMapper.selectEmployeeByRM(1);
        System.out.println("employee = " + employee);
    }

}