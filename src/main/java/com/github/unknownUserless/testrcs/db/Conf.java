package com.github.unknownUserless.testrcs.db;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class Conf {

    @Value("${db.filepath}")
    private String dbFilePath;

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.driverClassName("org.sqlite.JDBC");
        builder.url("jdbc:sqlite:"+dbFilePath);

        return builder.build();
    }

}
