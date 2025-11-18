package com.example.demo.controller;

import com.example.demo.entity.Teacher;
import com.example.demo.service.TeacherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
@CrossOrigin("*")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    // Register teacher
    @PostMapping("/register")
    public Teacher register(@RequestBody Teacher teacher) {
        return teacherService.register(teacher);
    }

    // Login teacher
    @PostMapping("/login")
    public Teacher login(@RequestBody Teacher teacher) {
        return teacherService.login(teacher.getEmail(), teacher.getPassword());
    }

    // Get all teachers
    @GetMapping("/all")
    public java.util.List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }
}
