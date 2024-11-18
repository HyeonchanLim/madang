package com.green.madang.manager.book;

import com.green.madang.common.model.MyResponse;
import com.green.madang.manager.book.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequiredArgsConstructor //생성자 만들어 준다.
@RequestMapping("manager/book")
@Tag(name = "도서", description = "도서 API")
public class BookController {

    private final BookService service;

    @PostMapping
    @Operation(summary = "도서 입고", description = "<div>도서 입고 처리 API</div>" +
            "<div>하하하하</div>" +
            "<div>크크크크크</div>")
    public MyResponse<Integer> postBook(@RequestBody BookPostReq p) {
        log.info("BookPostReq : {}", p);
        int result = service.postBook(p);
        MyResponse<Integer> response = new MyResponse<>("책 등록 완료", result);
        return response;
    }

    @GetMapping
    @Operation(summary = "도서 리스트", description = "도서 정보 리스트<br> 보기 API <br> dkdkdkd <ol><li>일번</li><li>이번</li></ol>")
    public MyResponse<List<BookGetRes>> getBookList(@ParameterObject @ModelAttribute BookGetReq p) {
        List<BookGetRes> list = service.getBookList(p);
        return new MyResponse<>(p.getPage() + "페이지 데이터", list);
    }

    @PutMapping
    @Operation(summary = "도서 수정")
    public MyResponse<Integer> putBook(@RequestBody BookPutReq p) {
        return new MyResponse<>(p.getBookId() + "번 도서 수정"
                , service.putBook(p));
    }

    @DeleteMapping
    @Operation(summary = "도서 삭제")
    public MyResponse<Integer> deleteBook(@ParameterObject @ModelAttribute BookDeleteReq p) {
        return new MyResponse<>(p.getBookId() + "번 도서 삭제"
                , service.deleteBook(p));
    }
}