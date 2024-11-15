package com.green.madang.manager.book;

import com.green.madang.manager.book.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookMapper mapper;

    public int insBook(BookPostReq p) {
        return mapper.insBook(p);
    }

    public List<BookGetRes> selBookList(BookGetReq p){
        //sIdx 값 세팅
        p.setStartIdx((p.getPage()-1)*p.getSize());
        return mapper.selBookList(p);
    }

    public int updBook(BookPutReq p) {
        return mapper.updBook(p);
    }

    public int delBook(BookDelReq p){
        return mapper.delBook(p);
    }
}