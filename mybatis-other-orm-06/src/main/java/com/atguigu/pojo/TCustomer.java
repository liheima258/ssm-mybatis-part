package com.atguigu.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * @TableName t_customer
 */


//使用插件 可以自动生成实体类对象、接口和xml文件 再正常使用即可
@Data
public class TCustomer implements Serializable {
    private Integer customerId;

    private String customerName;

    private static final long serialVersionUID = 1L;
}