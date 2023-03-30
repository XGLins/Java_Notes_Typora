package com.hnsm.spring.service.impl;

import com.hnsm.spring.service.BookService;
import com.hnsm.spring.service.CheckoutService;
import org.springframework.transaction.annotation.Transactional;

public class CheckoutServiceImpl implements CheckoutService {

    private BookService bookService;

    @Override
    @Transactional
    public void checkout(Integer userId, Integer[] bookIds) {
        for (Integer bookId : bookIds){
            bookService.buyBook(userId,bookId);
        }
    }
}
