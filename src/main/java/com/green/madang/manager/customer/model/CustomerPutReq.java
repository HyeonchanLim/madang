package com.green.madang.manager.customer.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerPutReq {
    @Schema(title = "고객ID", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    // requiredMode = Schema.RequiredMode.REQUIRED 이 값은 해당 필드가 반드시 제공되어야 함을 의미
    // 만약 custid 가 없이 호출되면 요청이 유효하지 않아 에러가 발생한다
    // Schema.RequiredMode.NOT_REQUIRED 를 작성하면 제공하지 않아도 요청이 유효하게 처리되지만 쓰지는 않는다.
    private int custId;
    @Schema(title = "고객 이름", example = "홍길동")
    private String name;
    @Schema(title = "고객 주소", example = "대구시 중구")
    private String address;
    @Schema(title = "고객 휴대폰 번호", example = "010-0000-0000")
    private String phone;
}