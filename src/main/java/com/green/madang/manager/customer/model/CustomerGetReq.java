package com.green.madang.manager.customer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.bind.annotation.BindParam;

/*
우리가 만드는 api 는 응답 때 json 형태로 응답한다.
응답시 객체에 있는 특정 멤버필드의 값을 제외하고 싶을 때
@JsonIgnore를 멤버필드에 붙이면 제외시킬 수 있다.
(응답 때 JsonIgnore를 쓰는 경우는 거의 없다.)
swagger 문서상에 응답 schema 에서 안 보이기도 한다.
 */

//immutable 객체
@Getter
@ToString
public class CustomerGetReq {
    // schema , jsonignore 애노테이션은 swagger용 애노테이션
    // 필수는 아니지만 프론트를 위해 사용
    @Schema(description = "page값", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private int page;
    @Schema(description = "페이지에 보이는 고객정보 수", example = "50", requiredMode = Schema.RequiredMode.REQUIRED)
    private int size;
    // @Schema(hidden = true) 밑에 jsonignore 처럼 안보이게 가능함
    // @JsonIgnore // 이렇게 작성하면 swagger 에서 startidx 가 안 보이게 됨
    // 데이터는 필요하지만 front 에서 볼 필요 없을 경우 이걸 사용해서 가리면 됨
    // 문서상에 parameters 부분에서 보이지 않게 하는 역할
    @JsonIgnore
    private int startIdx; //(page - 1) * size

    @Schema(name="search_type", description = "검색타입: {name, address, phone}중 한 값을 보낸다. ", example = "name")
    private String searchType;

    @Schema(name="search_text", description = "검색내용", example = "ani")
    private String searchText;

    // bindparam 에 작성한 명칭으로만 받고 뒤에서 받는 매개변수 타입명은 아님
    // 앞으로 _ 언더바 사용하게 변경
    public CustomerGetReq(int page, int size, @BindParam("search_type") String searchType, @BindParam("search_text") String searchText) {
        this.page = page;
        this.size = size;
        this.searchType = searchType;
        this.searchText = searchText;
        this.startIdx = (page - 1) * size;
    }
}
