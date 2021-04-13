package com.chao.demo.sometest;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix="user")    // 用来指定properties配置文件中的key前缀
@PropertySource("classpath:config/user.yml")  // 配置文件所在位置
public class UserProperties {

    private List<User> users;

    @Data
    public static class User {

        private String name;

        private int age;

        private char gender;
    }
}
