package com.atguigu.mapper;

import com.atguigu.pojo.Employee;


/**
 *    t_emp表对应数据库SQL语句映射接口!
 *    接口只规定方法,参数和返回值!
 *    mapper.xml中编写具体SQL语句!
 */
public interface EmployeeMapper {

    /**
     * 根据员工id查询员工数据方法
     * @param empId  员工id
     * @return 员工实体对象
     */

    /*
       命名规则：
            方法名和SQL的id一致
            方法返回值和resultType一致
            方法的参数和SQL的参数一致
            接口的全类名和映射配置文件的名称空间一致
     */

    Employee selectEmployee(Integer empId);
}