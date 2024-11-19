package com.green.madang.manager.order;

import com.green.madang.manager.order.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderGetRes> selOrderList(OrderGetReq p);
}