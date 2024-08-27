package com.example.uac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 用户认证授权中心
 *
 */
@SpringBootApplication
public class UacApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(UacApplication.class,args);
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
