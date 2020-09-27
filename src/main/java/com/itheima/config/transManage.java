package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
@Component
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement(proxyTargetClass = true)
public class transManage {
    @Value("${jdbc.url}")
   private String url;
    @Value("${jdbc.username}")
   private String username;
    @Value("${jdbc.password}")
   private String password;
    @Value("${jdbc.driver}")
   private String driver;
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }


    @Bean
    public DataSourceTransactionManager transactionManager(@Qualifier("dataSource")DataSource dataSource){
        DataSourceTransactionManager tx = new DataSourceTransactionManager();
        tx.setDataSource(dataSource);
        return tx;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(@Qualifier("dataSource") DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }
}
