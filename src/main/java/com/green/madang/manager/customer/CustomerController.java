package com.green.madang.manager.customer;

import com.green.madang.common.model.MyResponse;
import com.green.madang.manager.customer.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("manager/customer")
@Tag(name = "고객", description = "고객 관리")
    /*
    PathVariable
    (get) / board
    (get) / board/1
    get 방식에서 주소값 구분하기 위해서 PathVariable 사용
    (delete) / board/1
    에서는 쿼리스트링 사용
     */
    // modelattribute 는 한번에 전부
    // requestparam 은 각각 따로 해줘야 함 그리고 primitive 타입같은거만
    // @ParameterObject - Swagger용 애노테이션, RequestParam으로 설정했을 때 나오는 FORM처럼 되게 한다.
public class CustomerController {
    private final CustomerService service;

    @PostMapping
    @Operation(summary = "고객 등록")
    public MyResponse<Integer> postCustomer(@RequestBody CustomerPostReq p) {
        int result = service.postCustomer(p);
        return new MyResponse<>("고객이 등록되었습니다.", result);
    }

    @GetMapping
    @Operation(summary = "고객 리스트", description = "검색할 내용이 있을 시 검색타입, 검색내용을 모두 보내주어야 한다.")
    //@ParameterObject - Swagger용 애노테이션, RequestParam으로 설정했을 때 나오는 FORM처럼 되게 한다.
    public MyResponse<List<CustomerGetRes>> getCustomerList(@ParameterObject @ModelAttribute CustomerGetReq p) {
        log.info("get-req: {}", p);
        //log.info 는 로그를 기록하는 메소드 , p는 getreq 객체에 들어오는 파라미터를 로그로 남기기 위한 용도로 사용
        List<CustomerGetRes> res = service.getCustomerList(p);
        return new MyResponse<>(p.getPage() + "페이지 데이터", res);
    }

    //RequestParam을 이용한 GetMapping
    // required = false 여기서 false 를 사용할 경우 값이 제공되지 않으면 null 이 설정되지만
    // true 로 작성했을 경우 반드시 값이 제공되어야 한다 제공받지 못 하면 에러가 발생한다.
    @GetMapping("/param")
    @Operation(summary = "고객 리스트2", description = "검색할 내용이 있을 시 검색타입, 검색내용을 모두 보내주어야 한다.")
    public MyResponse<List<CustomerGetRes>> getCustomerList2( @RequestParam int page
            , @RequestParam int size
            , @RequestParam(name="search_type", required = false) String searchType
            , @RequestParam(name="search_text", required = false) String searchText) {
        CustomerGetReq p = new CustomerGetReq(page, size, searchType, searchText);
        log.info("get-req: {}", p);
        List<CustomerGetRes> res = service.getCustomerList(p);
        return new MyResponse<>(p.getPage() + "페이지 데이터", res);
    }


    @PutMapping
    @Operation(summary = "고객 수정", description = "부분 수정 가능합니다.")
    public MyResponse<Integer> putCustomer(@RequestBody CustomerPutReq p) {
        int result = service.putCustomer(p);
        return new MyResponse<>(p.getCustId() + "번 고객을 수정하였습니다.", result);
    }

    @DeleteMapping
    public MyResponse<Integer> deleteCustomer(@RequestParam(value = "cust_id") int custId) {
        log.info("custId: {}", custId);
        int result = service.deleteCustomer(custId);
        return new MyResponse<>(custId + "번 고객을 삭제하였습니다.", result);
    }
}