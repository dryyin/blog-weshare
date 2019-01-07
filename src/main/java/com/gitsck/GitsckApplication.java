package com.gitsck;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gitsck.mapper")
public class GitsckApplication {

    public static void main(String[] args){
        SpringApplication.run(GitsckApplication.class,args);
    }
}
