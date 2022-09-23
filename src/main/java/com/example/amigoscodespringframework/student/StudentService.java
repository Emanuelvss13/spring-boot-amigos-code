package com.example.amigoscodespringframework.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent()) {
            throw new IllegalStateException("Email Taken");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);

        if(!exists) {
            throw new IllegalStateException("Student not Found!");
        }

        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String email, String name) {
        Optional<Student> student = studentRepository.findById(studentId);

        if(student.isEmpty()) {
            throw new IllegalStateException("Student not Found!");
        }

        if( email != null && email.length() > 0 && !Objects.equals(student.get().getEmail(), email)) {
            Optional<Student> studentByEmail = studentRepository.findStudentByEmail(email);

            if(studentByEmail.isPresent()) {
                throw new IllegalStateException("Email Taken");
            }

            student.get().setEmail(email);
        }

        if( name != null && name.length() > 0 && !Objects.equals(student.get().getName(), name)){
            student.get().setName(name);
        }
    }
}
