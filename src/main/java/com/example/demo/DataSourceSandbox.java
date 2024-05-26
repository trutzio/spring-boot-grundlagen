package com.example.demo;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSourceSandbox implements ApplicationRunner {

    private final static Logger log = LoggerFactory.getLogger(DataSourceSandbox.class);

    private DataSource dataSource;

    public DataSourceSandbox(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info(dataSource.toString());
        Connection connection = dataSource.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT id,name FROM Person");
        while (resultSet.next()) {
            log.info("Person: {} {}",
                    resultSet.getInt("id"),
                    resultSet.getString("name"));
        }
    }

}
