package com.example.amigoscodespringframework.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudent() {
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
