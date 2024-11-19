package com.green.madang.manager.order;

import com.green.madang.manager.order.model.OrderGetReq;
import com.green.madang.manager.order.model.OrderGetRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper mapper;

    public List<OrderGetRes> getOrderList(OrderGetReq p) {
        // startIdx값 세팅
        /*
        int page = p.getPage();
        int size = p.getSize();
        int startIdx = (page - 1) * size;
        p.setStartIdx(startIdx);
        */
        p.setStartIdx( (p.getPage() - 1) * p.getSize() );

        return mapper.selOrderList(p);
    }
}