package com.orange.service.dao.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by IntelliJ IDEA 14.
 * User: karl.zhao
 * Time: 2016/1/6 0006.
 */
@Configuration
@MapperScan(
        basePackages = {"com.orange.service.dao.mapper"},
        sqlSessionFactoryRef = "sqlSessionFactory"
)
public class DataBaseConfig {
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    @Value("${db.url}")
    private String databaseUrl;
    @Value("${db.driverName}")
    private String driverName;
    @Value("${db.connectionTimeout}")
    private int connectionTimeout;

    @Bean
    public DataSource dataSource(){

        HikariConfig config = new HikariConfig();
        config.setUsername(username);
        config.setPassword(password);
        config.setJdbcUrl(databaseUrl);
        try {
            config.setDriverClassName(driverName);
        }
        catch (Exception i)
        {
            i.printStackTrace();
        }
        config.setConnectionTimeout(connectionTimeout);

        return new HikariDataSource(config);
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        // 实体类放的地方
        sessionFactory.setTypeAliasesPackage("com.orange.service.domain");

        return sessionFactory.getObject();
    }
}
