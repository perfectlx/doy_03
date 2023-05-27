package com.example.doy_03.controller;
import com.example.doy_03.pojo.Books;
import com.example.doy_03.utsils.ReturnUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 开挖机的人
 * @Date 2023/5/27 11:23
 */
@RestController
@RequestMapping("/books/")
public class ListBookController {

    @RequestMapping("getListBook")
    public List<Books> getListBooks(Books books) {
        ArrayList<Books> books1 = new ArrayList<>();
        ReturnUtils returnUtils = new ReturnUtils();
        try {

            for (int i = 0; i < 100; i++) {
                Books book = new Books();
                books.setId(i);
                books.setNumber(String.valueOf(i));
                books.setName("第"+i+"册书籍");
                books1.add(books);
                System.out.println(i);
            }
        } catch (Exception e) {
            returnUtils.setCode(500);
            returnUtils.setMessage(e.getMessage());
            returnUtils.setList(null);
    }

        return (List<Books>) returnUtils;
    }
}

