package com.example.demo.controller;

import com.example.demo.entity.Teacher;
import com.example.demo.repository.TeacherRepository;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/teacher")
@CrossOrigin("*")
public class TeacherController {

    private final TeacherRepository teacherRepository;

    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @PostMapping("/register")
    public Map<String, Object> registerTeacher(@RequestBody Teacher teacher) {
        Map<String, Object> response = new HashMap<>();
        if (teacherRepository.findByEmail(teacher.getEmail()) != null) {
            response.put("status", "error");
            response.put("message", "Email already registered");
            return response;
        }
        Teacher savedTeacher = teacherRepository.save(teacher);
        response.put("status", "success");
        response.put("teacher", savedTeacher);
        return response;
    }

    @PostMapping("/login")
    public Map<String, Object> loginTeacher(@RequestBody Teacher loginData) {
        Map<String, Object> response = new HashMap<>();
        Teacher teacher = teacherRepository.findByEmail(loginData.getEmail());
        if (teacher == null) {
            response.put("status", "error");
            response.put("message", "Email not found");
            return response;
        }
        if (!teacher.getPassword().equals(loginData.getPassword())) {
            response.put("status", "error");
            response.put("message", "Incorrect password");
            return response;
        }
        response.put("status", "success");
        response.put("teacher", teacher);
        return response;
    }
}
