package com.cn.mybatis.mapper;

import java.util.List;

import com.cn.mybatis.pojo.OrderCustom;
import com.cn.mybatis.pojo.Orders;
public interface OrderMapperCustom {
	/**
	 * ��ѯ���������û���Ϣ
	 * @return
	 */
	List<OrderCustom> findOrderUser();
    List<Orders>findOrderUserResultMap();
    List<Orders>findOrderUserAndOrderDetail();
    List<Orders>findOrderUserLazyLoading();
}
