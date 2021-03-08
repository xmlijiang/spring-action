package com.jali.service;

import com.jali.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lijiang
 * @create 2021-03-09 0:04
 */
@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public void buyBook(){
        bookDao.getPrice(1);
        bookDao.updateBalance("zhangsan",100);
        bookDao.updateStock(1);
    }

    public void buyBookByError(){
        bookDao.getPrice(1);
        bookDao.updateBalance("zhangsan",100);
        int i = 1/0;
        bookDao.updateStock(1);
    }

    @Transactional
    public void buyBookByTX(){
        bookDao.getPrice(1);
        bookDao.updateBalance("zhangsan",100);
        int i = 1/0;
        bookDao.updateStock(1);
    }

    @Transactional
    public void buyBookByTxTry1(){
        bookDao.getPrice(1);
        bookDao.updateBalance("zhangsan",100);
        try {
            int i = 1/0;
        }catch (Exception e){
            e.printStackTrace();
        }
        // 此时异常只是打印，不影响事务回滚，可正常更新数据
        bookDao.updateStock(1);
    }

    @Transactional
    public void buyBookByTxTry2(){
        try{
            bookDao.getPrice(1);
            bookDao.updateBalance("zhangsan",100);
            // 此时执行到此处，发生异常，直接到catch中，不会往下执行updateStock，然后上面两句正常提交了
            int i = 1/0;
            bookDao.updateStock(1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
