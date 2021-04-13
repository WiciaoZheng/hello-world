package com.chao.demo.sometest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DemoTest extends BaseTest {

    @Autowired
    private UserProperties userProperties;

    @Test
    public void test() {

        System.out.println(userProperties.getUsers().get(0).getName());
        // System.out.println(LocalDateTime.parse("2021-04-03T00:00:01", DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        // System.out.println(DateTimeUtils.getNow());
        // System.out.println(DateTimeUtils.getPeriod("2020-01-01", "2020-01-03", DateTimeUtils.YEAR));
        // System.out.println(DateTimeUtils.getDuration("2020-01-01 12:00:00", "2020-01-03 00:00:00", DateTimeUtils.HOUR));
        // System.out.println(DateTimeUtils.getDuration("2020-01-01 12:00:00", "2020-01-03 12:00:01", DateTimeUtils.HOUR));
    }
}
