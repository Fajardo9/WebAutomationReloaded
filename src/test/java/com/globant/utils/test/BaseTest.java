package com.globant.utils.test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class BaseTest {
    public static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    @Test
    public static void main(String[] args) {
        log.info("Hello World!");
    }
}
