package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/register")
    public Student register(@RequestBody Student student) {
        return studentService.register(student);
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Student student) {
        Map<String, Object> response = new HashMap<>();
        Student s = studentService.login(student.getEmail(), student.getPassword());
        if (s == null) {
            response.put("status", "error");
            response.put("message", "Invalid credentials");
        } else {
            response.put("status", "success");
            response.put("student", s);
        }
        return response;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
}
