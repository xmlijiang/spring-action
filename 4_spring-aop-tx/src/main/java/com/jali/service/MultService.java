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
        bookService.buyBookByTx1();
        bookService.buyBookByTx2();
    }
}
