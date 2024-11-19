package com.green.madang.manager.order.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderGetRes {
    private int orderId;
    private int salePrice;
    private String orderDate;
    private int custId;
    private String name;
    private int bookId;
    private String bookName;
}