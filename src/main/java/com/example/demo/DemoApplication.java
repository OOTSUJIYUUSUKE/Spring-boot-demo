package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@SpringBootApplication
@RestController
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello")

    public String hello(@RequestParam(value = "country", defaultValue = "jp") String value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String strDateTime = localDateTime.format(formatter);
        if (value.equals("us")) {
            return String.format("Hello World! It's %s.", strDateTime);
        }
        else if (value.equals("fr")) {
            return String.format("Bonjour le monde! Il est %s.", strDateTime);
        }
        else if (value.equals("kr")) {
            return String.format("안녕하세요 세계! 지금 %s 시입니다.", strDateTime);
        }
        else {
            return String.format("こんにちは! 現在時刻は%sです。", strDateTime);
        }
    }
}