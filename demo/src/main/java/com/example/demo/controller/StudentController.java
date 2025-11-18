package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Register student
    @PostMapping("/register")
    public Student register(@RequestBody Student student) {
        return studentService.register(student);
    }

    // Login student
    @PostMapping("/login")
    public Student login(@RequestBody Student student) {
        return studentService.login(student.getEmail(), student.getPassword());
    }

    // Get student by ID
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
}
