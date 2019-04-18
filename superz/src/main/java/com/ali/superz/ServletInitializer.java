package com.ali.superz;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 项目打包步骤四,打包项目成war包就需要使用，
 * 相当于就是一个web.xml文件
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 指向原先用main方法执行的Application启动类
        return builder.sources(SuperzApplication.class);
    }

}