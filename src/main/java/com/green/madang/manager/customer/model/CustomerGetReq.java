package com.green.madang.manager.customer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.bind.annotation.BindParam;

//immutable 객체
@Getter
@ToString
public class CustomerGetReq {

    public CustomerGetReq(int page, int size, @BindParam("search_type") String searchType, @BindParam("search_text") String searchText) {
        this.page = page;
        this.size = size;
        this.searchType = searchType;
        this.searchText = searchText;
        this.startIdx = (page - 1) * size;
    }

    @Schema(description = "page값", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private int page;
    @Schema(description = "페이지에 보이는 고객정보 수", example = "50", requiredMode = Schema.RequiredMode.REQUIRED)
    private int size;
    @JsonIgnore
    private int startIdx; //(page - 1) * size

    @Schema(name="search_type", description = "검색타입: {name, address, phone}중 한 값을 보낸다. ", example = "name")
    private String searchType;

    @Schema(name="search_text", description = "검색내용", example = "ani")
    private String searchText;

}