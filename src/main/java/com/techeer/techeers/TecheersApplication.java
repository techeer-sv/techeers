package com.techeer.techeers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TecheersApplication {

    public static void main(String[] args) {
        SpringApplication.run(TecheersApplication.class, args);
    }

}
