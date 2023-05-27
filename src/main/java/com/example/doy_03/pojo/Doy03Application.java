package com.example.doy_03.pojo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/example/doy_03/dao")//进行扫描对应的接口
public class Doy03Application {

    public static void main(String[] args) {
        SpringApplication.run(Doy03Application.class, args);
    }

}
