package com.example.demo.service;

import com.example.demo.entity.Teacher;
import com.example.demo.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher register(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher login(String email, String password) {
        Teacher teacher = teacherRepository.findByEmail(email);
        if (teacher != null && teacher.getPassword().equals(password)) {
            return teacher;
        }
        return null;
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
}
