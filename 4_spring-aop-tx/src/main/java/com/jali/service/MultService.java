package com.jali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lijiang
 * @create 2021-03-13 0:01
 */
@Service
public class MultService {

    @Autowired
    BookService bookService;

    @Transactional
    public void mult() {
        // REQUIRES_NEW，自己的异常，不回滚
        bookService.buyBookByTx1();
        // REQUIRED 异常回滚
        bookService.buyBookByTx2();
    }

    // @Transactional
    public void testSupport(){
        bookService.buyBookByTx1();
    }
}
