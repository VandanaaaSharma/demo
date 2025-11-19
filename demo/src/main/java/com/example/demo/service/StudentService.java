package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Register a student
    public Student register(Student student) {
        return studentRepository.save(student);
    }

    // Login by email and password
    public Student login(String email, String password) {
        return studentRepository.findByEmail(email)
                .filter(s -> s.getPassword().equals(password))
                .orElse(null);
    }

    // Get student by primary key
    public Student getStudentById(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Get student by studentId field
    public Student getStudentByStudentId(String studentId) {
        return studentRepository.findByStudentId(studentId).orElse(null);
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
