package com.green.madang.manager.customer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerGetRes {

    @Schema(name="custId", description = "고객ID")
    private int custId;
    @Schema(description = "고객 이름")
    private String name;
    @Schema(description = "고객 주소")
    private String address;
    @Schema(description = "고객 휴대폰 번호")
    private String phone;
}