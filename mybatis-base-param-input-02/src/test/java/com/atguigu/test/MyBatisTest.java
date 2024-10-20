package com.atguigu.test;

import com.atguigu.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.lang.model.SourceVersion;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void testUpdateEmpNameByMap() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("empSalaryKey", 999.99);
        paramMap.put("empIdKey", 5);
        int result = mapper.updateEmployeeByMap(paramMap);
        System.out.println("result = " + result);
    }

    //junit5会在每一个@Test方法后执行@@AfterEach方法
    @AfterEach
    public void clear() {
        session.commit();
        session.close();
    }

}