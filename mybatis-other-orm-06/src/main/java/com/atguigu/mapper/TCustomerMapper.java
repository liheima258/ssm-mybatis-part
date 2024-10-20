package com.atguigu.mapper;

import com.atguigu.pojo.TCustomer;

/**
* @author 86173_slridnp
* @description 针对表【t_customer】的数据库操作Mapper
* @createDate 2024-07-22 17:34:30
* @Entity com.atguigu.pojo.TCustomer
*/
public interface TCustomerMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TCustomer record);

    int insertSelective(TCustomer record);

    TCustomer selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TCustomer record);

    int updateByPrimaryKey(TCustomer record);

}
