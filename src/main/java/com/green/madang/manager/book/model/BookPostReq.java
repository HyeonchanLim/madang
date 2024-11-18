package com.green.madang.manager.book.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class BookPostReq {
    @Schema(title = "도서 이름", description = "설명할거 있으면 적으며 된다.", example = "학교 종이 땡땡땡!", requiredMode = Schema.RequiredMode.REQUIRED)
    private String bookName;
    @Schema(title = "출판사 이름", example = "한빛출판사", requiredMode = Schema.RequiredMode.REQUIRED)
    private String publisher;
    @Schema(title = "도서 가격", example = "12000", requiredMode = Schema.RequiredMode.REQUIRED)
    private int price;
}
/*
public class BookPostReq {
   @Schema(title = "도서 이름", description = "설명할거 있으면 적으며 된다.",
   example = "학교 종이 땡땡땡!", requiredMode = Schema.RequiredMode.REQUIRED)
   // example - 기본값  , requiredmode - * 표시로 무조건 입력받아야 한다는 필수값을 표시
    private String bookName;
    @Schema(title = "출판사 이름", example = "한빛출판사", requiredMode = Schema.RequiredMode.REQUIRED)
    private String publisher;
    @Schema(title = "도서 가격", example = "12000", requiredMode = Schema.RequiredMode.REQUIRED)
    private int price;
}
 */