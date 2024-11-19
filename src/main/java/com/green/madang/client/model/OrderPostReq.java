package com.green.madang.client.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderPostReq {
    @Schema(description = "주문자 id", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private int custId;
    @Schema(description = "주문 도서 id", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private int bookId;
}