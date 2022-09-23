package com.example.amigoscodespringframework.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
    return args -> {

        Student emanuel = new Student(1L, "Emanuel", "emanuel@email.com", LocalDate.of(2002, Month.MAY, 19));
        Student joao = new Student(2L, "João", "joão@email.com", LocalDate.of(2002, Month.JANUARY, 19));

        studentRepository.saveAll(
                List.of(emanuel, joao)
        );

        };
    }

}
