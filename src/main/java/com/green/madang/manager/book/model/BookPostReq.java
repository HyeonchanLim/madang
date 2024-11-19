package com.green.madang.manager.book.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
// Schema 작성하지 않으면 기본적으로 멤버필드명 타입 으로 표시
// 작성할 경우 해당하는 멤버필드에 Schema 설명이 추가된다.
public class BookPostReq {
    @Schema(title = "도서 이름", description = "설명할거 있으면 적으면 된다.", example = "학교 종이 땡땡땡!", requiredMode = Schema.RequiredMode.REQUIRED)
    private String bookName;
    @Schema(title = "출판사 이름", example = "한빛출판사", requiredMode = Schema.RequiredMode.REQUIRED)
    private String publisher;
    @Schema(title = "도서 가격", example = "12000", requiredMode = Schema.RequiredMode.REQUIRED)
    private int price;
}
