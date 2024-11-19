package com.green.madang.manager.order;

import com.green.madang.common.model.MyResponse;
import com.green.madang.manager.order.model.OrderGetReq;
import com.green.madang.manager.order.model.OrderGetRes;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("manager/order")
public class OrderController {
    private final OrderService service;

    @GetMapping
    public MyResponse<List<OrderGetRes>> getOrderList(@ParameterObject @ModelAttribute OrderGetReq p) {
        List<OrderGetRes> list = service.getOrderList(p);
        return new MyResponse<>(list.size() + " rows", list);
    }
}