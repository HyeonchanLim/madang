package com.green.madang.manager.book.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookGetReq {

    private int page;
    @Schema(description = "한 페이지마다 보여질 아이템 수", example = "30", requiredMode = Schema.RequiredMode.REQUIRED)
    private int size;
    @Schema(description = "도서 제목에서 검색을 한다.", example = "검색 텍스트", requiredMode = Schema.RequiredMode.REQUIRED)
    private String searchText;
    @JsonIgnore //Swagger 문서에서 멤버필드가 안 나왔으면 할 때 이 애노테이션을 붙이면 된다.
    private int startIdx; //(page - 1) * size
}
    // swagger 문서에서 멤버필드가 안 나왔으면 할 때 이 애노테이션을 사용 startIdx 는 사라짐
