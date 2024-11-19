package com.green.madang.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderGetRes {
    @JsonProperty("order_id")
    private int orderId;
    @JsonProperty("sale_price")
    private int bookId;
    @JsonProperty("order_date")
    private int saleprice;
    @JsonProperty("book_id")
    private String bookName;
    @JsonProperty("book_name")
    private String orderdate;
}
