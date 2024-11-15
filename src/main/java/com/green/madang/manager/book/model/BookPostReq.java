package com.green.madang.manager.book.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookPostReq {
    @Schema(title = "도서 이름" , description = "설명할거 있으면 적으면 된다.")
    private String bookName;
    @Schema(title = "출판사 이름")
    private String publisher;
    @Schema(title = "도서 가격")
    private int price;
}