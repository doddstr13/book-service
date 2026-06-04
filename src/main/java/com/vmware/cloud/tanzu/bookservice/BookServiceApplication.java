package com.vmware.cloud.tanzu.bookservice;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@Log
@SpringBootApplication
public class BookServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner loadData(BookRepository repo) {
        return commandLineRunner -> {
            Stream.of("Game of Thrones", "Kite Runner", "Unicorn Project",
                "Even a Geek can Speak", "Leviathan Wakes"). forEach(title -> repo.save(new Book(null, title)));
            repo.findAll().forEach(book -> log.info(book.getTitle()));
        };
    }

}


