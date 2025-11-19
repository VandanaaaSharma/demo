package com.example.demo;

import com.example.demo.entity.Subject;
import com.example.demo.repository.SubjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // Automatically add subjects on startup if table is empty
   @Bean
CommandLineRunner initSubjects(SubjectRepository repo) {
    return args -> {
        if (repo.count() == 0) {
            repo.save(new Subject("Mathematics"));
            repo.save(new Subject("Physics"));
            repo.save(new Subject("Chemistry"));
        }
    };
}
}
