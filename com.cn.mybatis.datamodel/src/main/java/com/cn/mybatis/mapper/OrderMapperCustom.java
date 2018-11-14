package com.cn.mybatis.mapper;

import java.util.List;

import com.cn.mybatis.pojo.OrderCustom;
import com.cn.mybatis.pojo.Orders;
public interface OrderMapperCustom {
	/**
	 * 查询订单关联用户信息
	 * @return
	 */
	List<OrderCustom> findOrderUser();
    List<Orders>findOrderUserResultMap();
    List<Orders>findOrderUserAndOrderDetail();
    List<Orders>findOrderUserLazyLoading();
}
