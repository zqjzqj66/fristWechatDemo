package com.imooc.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: DruidConfig
 * @date 2018/12/22 21:07
 */
@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource druid(){
        return new DruidDataSource();
    }

}
