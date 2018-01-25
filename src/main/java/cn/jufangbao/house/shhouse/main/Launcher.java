package cn.jufangbao.house.shhouse.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Launcher.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:40:13.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
@SpringBootApplication
@ImportResource("classpath:spring/spring-web.xml")
public class Launcher {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Launcher.class, args);
    }
}
