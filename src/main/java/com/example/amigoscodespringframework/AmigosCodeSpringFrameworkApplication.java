package com.example.amigoscodespringframework;

import com.example.amigoscodespringframework.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class AmigosCodeSpringFrameworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmigosCodeSpringFrameworkApplication.class, args);
    }

    @GetMapping("/hello")
    public List<Student> hello() {
        return List.of(
                new Student(1L,
                        "Emanuel",
                        "emanuel@gmail.com",
                        20, LocalDate.of(2002,
                        Month.MAY,
                        19)
                )
        );
    }

}
