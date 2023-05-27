package com.example.doy_03;

import com.example.doy_03.dao.BooksDao;
import com.example.doy_03.pojo.Books;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URL;

@SpringBootTest
@MapperScan("com/example/doy_03/dao")
public class Doy03ApplicationTests {

    /**
     * spring中的注入，
     *         @Autowired  标识，创建的一个对象
     *             new  books()
     *      在这里标识，注入到当前的这个类中，那么可以进行调用对应的方法
     *         booksDao.xxxx()
     * */
    @Autowired
    private BooksDao booksDao;

    @Test
    public   void contextLoads() throws IOException {

//        System.out.println("测试类");
        //定义一个url,就是访问抓取数据的一个地址
        String  urls="https://search.jd.com/Search?keyword=java";
        Document parse = Jsoup.parse(new URL(urls), 5000);
//        System.out.println(parse);


        Element j_goodsList = parse.getElementById("J_goodsList");
//        System.out.println("j_goodsList = " + j_goodsList);
        //获取多个li  ，注意li是返回的一个数组，Elements
        Elements li = j_goodsList.getElementsByTag("li");
        /**
         * 获取一个数据，那么就需要使用循环的方式进行遍历
         * */
        int i=0;
        for (Element element : li) {
            /**
             * getElementsByTag  返回是一个数组对象
             *    那么要取数组中的第一个数据，那么就使用eq()方法，传入的参数是数组的下标
             */
            String img = element.getElementsByTag("img").eq(0).attr("data-lazy-img");
            //   System.out.println("img = " + img);
            String number = element.getElementsByClass("p-price").eq(0).text();
            //   System.out.println("text = " + text);
            String name = element.getElementsByClass("p-name").eq(0).text();
            System.out.println("name = " + name);

            /**
             * 怎么将这些数据存储到数据库中?
             */

            Books books = new Books();
            books.setName(name);
            books.setNumber(number);
            books.setUrl(img);
            booksDao.insert(books);

        }
        System.out.println("添加成功");


    }
}