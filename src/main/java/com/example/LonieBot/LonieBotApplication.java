package com.example.LonieBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.linecorp.bot.spring.boot.webmvc.configuration.LineBotWebMvcConfigurer;

@SpringBootApplication
@Import({LineBotWebMvcConfigurer.class}) // 強制載入 SDK 的路徑配置
public class LonieBotApplication {
    public static void main(String[] args) {
        SpringApplication.run(LonieBotApplication.class, args);
    }
}