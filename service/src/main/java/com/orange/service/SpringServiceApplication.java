package com.orange.service;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by IntelliJ IDEA 14.
 * User: karl.zhao
 * Time: 2016/2/14 0014.
 */
@SpringBootApplication
public class SpringServiceApplication {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger(SpringServiceApplication.class);

        //该函数，直接看官网说明，其实就是启动用的。
        // 个人理解，执行该函数，就会加载指定的注解函数、类。
        SpringApplication.run(SpringServiceApplication.class, args);

        logger.info("-------- start succeed ----------");
    }
}
