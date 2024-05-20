package com.joao.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.joao.bookstore.service.DbService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DbService dbService;
	
    @Bean
    public DbService instanciaBaseDeDados() {
        this.dbService.instanciaBaseDeDados();
        return this.dbService;
    }
}
