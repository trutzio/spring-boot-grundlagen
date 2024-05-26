package com.example.demo;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataSourceSandbox implements ApplicationRunner {

    private final static Logger log = LoggerFactory.getLogger(DataSourceSandbox.class);

    private final DataSource dataSource;

    private final JdbcTemplate jdbcTemplate;

    public DataSourceSandbox(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info(dataSource.toString());

        // JDBC pure
        Connection connection = dataSource.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT id,name FROM Person");
        while (resultSet.next()) {
            log.info("Person: {} {}",
                    resultSet.getInt("id"),
                    resultSet.getString("name"));
        }

        // JDBC Template
        String name = jdbcTemplate.queryForObject("SELECT name FROM Person where id=1", String.class);
        log.info("Name for 1: {}", name);
    }

}
