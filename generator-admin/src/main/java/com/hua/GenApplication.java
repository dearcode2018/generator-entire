package com.hua;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot方式启动类
 *
 * @author stylefeng
 * @Date 2017/5/21 12:06
 */
@SpringBootApplication
public class GenApplication 
{
    protected final static Logger logger = LoggerFactory.getLogger(GenApplication.class);

    /**
     * 
     * @description 
     * @param args
     * @author qianye.zheng
     */
    public static void main(String[] args) {
    	LogManager l = null;
        SpringApplication.run(GenApplication.class, args);
        logger.info("Lemur Gen Application is success!");
    }
}
