package com.crud.loja.config;

import com.crud.loja.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("Dev")
public class DevConfig {
    @Autowired
    private DBService dbService;

    @Bean
    public void instatiateDatabase (){
        dbService.instantiateTestsData();
    }
}
