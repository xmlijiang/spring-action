package com.jali.service;

import com.jali.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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

    /**
     * propagation：传播特性：表示不同的事务之间执行的关系（事务套事务）
     * isolation：隔离级别：4种隔离级别，会引发不同的数据错乱问题
     * timeout：超时时间，单位秒，超时后会报Transaction timed out超时异常
     * readOnly：只读事务，如果配置了只读事务，那么在事务运行期间，不允许对数据进行修改，否则抛出异常：data modification are not allowed
     * rollbackFor：
     * rollbackForClassName：
     * noRollbackFor：noRollbackFor = {ArithmeticException.class}发生某个异常时也不回滚
     * noRollbackForClassName：改成“java.lang.ArithmeticException”
     */
//    @Transactional(timeout = 3)
    @Transactional(noRollbackFor = {ArithmeticException.class})
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

    @Transactional(propagation = Propagation.SUPPORTS)
    public void buyBookByTx1(){
        bookDao.getPrice(1);
        bookDao.updateBalance("zhangsan",100);
        bookDao.updateStock(1);
        // 出现异常
         int i = 1/0;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void buyBookByTx2(){
        bookDao.updateBookPrice(1,99);
        int i = 1/0;
    }
}
