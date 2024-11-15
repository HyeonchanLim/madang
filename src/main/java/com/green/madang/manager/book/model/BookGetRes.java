package com.green.madang.manager.book.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookGetRes {
    private int bookId;
    private String bookName;
    private String publisher;
    private int price;
}
