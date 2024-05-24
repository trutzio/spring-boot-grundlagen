package com.example.demo;

import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BeansLogger  implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(BeansLogger.class);

    private final ApplicationContext applicationContext;

    public BeansLogger(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Stream.of(applicationContext.getBeanDefinitionNames()).forEach(log::info);
    }

}
