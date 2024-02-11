package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = {
    "datasource.url=jdbc:mysql://localhost:3306/db_example",
    "datasource.username=root",
    "datasource.password=''",
})

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

}


