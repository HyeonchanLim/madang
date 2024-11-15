package com.green.madang.manager.book;

import com.green.madang.common.model.MyResponse;
import com.green.madang.manager.book.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor //생성자 만들어 준다.
@RequestMapping("manager/book")
@Tag(name = "도서" , description = "도서 API" )
public class BookController {
    private final BookService service;

    @PostMapping
    @Operation(summary = "도서 입고 처리" , description = "도서 입고 처리 API")
    public MyResponse<Integer> insBook(@RequestBody BookPostReq p) {
        int result = service.insBook(p);
        MyResponse<Integer> response = new MyResponse<>("책 등록 완료", result);
        return response;
    }

    @GetMapping
    @Operation(summary = "도서 목록" , description = "도서 목록 API")
    // parameterobject 를 modelattribute 앞에 붙여주면 박스 생김
    public MyResponse<List<BookGetRes>> selBookList(@ParameterObject @ModelAttribute BookGetReq p){
        List<BookGetRes> list = service.selBookList(p);
        return new MyResponse<>(p.getPage() + "페이지 데이터",list);
    }
    @PutMapping
    @Operation(summary = "도서 수정")
    public MyResponse<Integer> updBook(@RequestBody BookPutReq p) {
        return new MyResponse<>(p.getBookId() + "번 도서 수정"
                , service.updBook(p));
    }

    @DeleteMapping
    public int delBook(BookDelReq p){
        return service.delBook(p);
    }
}